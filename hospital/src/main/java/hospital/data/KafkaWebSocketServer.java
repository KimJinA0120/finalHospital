package hospital.data;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import hospital.HospitalApplication;
import hospital.domain.StockDTO;

@Component
public class KafkaWebSocketServer extends WebSocketServer {
	
	@Autowired
	StockRepository stockRepository;
	
    private Set<WebSocket> connections = ConcurrentHashMap.newKeySet();
    public KafkaWebSocketServer(StockRepository stockRepository, InetSocketAddress address) {
        super(address);
        this.stockRepository = stockRepository;
    }
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        connections.add(conn);
        System.out.println("New WebSocket connection: " + conn.getRemoteSocketAddress());
    }
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        connections.remove(conn);
        System.out.println("Closed WebSocket connection: " + conn.getRemoteSocketAddress());
    }
    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("Received message from WebSocket client: " + message);
        // 여기에 WebSocket 클라이언트로부터 받은 메시지를 처리하는 로직을 추가할 수 있습니다.
        
    }
    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
    }
    @Override
    public void onStart() {
        System.out.println("WebSocket server started successfully");
    }
    
    public void start() {
        super.start();
        System.out.println("WebSocket server started on port: " + this.getPort());
    }
    
    public void broadcastMessage(String message) {
        for (WebSocket conn : connections) {
            conn.send(message);
        }
    }
    public static void main(String[] args) {
    	 ApplicationContext context = SpringApplication.run(HospitalApplication.class, args);
         KafkaWebSocketServer server = context.getBean(KafkaWebSocketServer.class);
         server.start(); // 서버 시작
         server.startKafkaConsumer(); // Kafka 소비자 시작
    }
    public void startKafkaConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");  // Kafka 서버 주소
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "websocket-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("stock"));  // 읽고자 하는 Kafka 토픽명
        // Kafka 메시지 수신 및 WebSocket 전송 쓰레드 실행
        new Thread(() -> {
            try {
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000)); //0.1초마다 값 가져옴
                    for (ConsumerRecord<String, String> record : records) {
                        System.out.printf("Received message: key = %s, value = %s, topic = %s, partition = %d, offset = %d\n",
                                record.key(), record.value(), record.topic(), record.partition(), record.offset());
                        // Kafka 메시지를 WebSocket 클라이언트들에게 브로드캐스트
                        // 거래시간 / 종목코드 / 체결가격 / 거래량 / 누적 거래량
                        // 데이터 파싱
                        String[] pairs = record.value().split(":");
                        JSONObject stockData = new JSONObject(); // JSON으로 데이터 전송
                        StockDTO stockDTO = new StockDTO ();
                        for (String pair : pairs) {
                            String[] keyValue = pair.split("=");
                            if (keyValue.length == 2) {
                                String key = keyValue[0].trim();
                                String value = keyValue[1].trim();
                                // 필요에 따라 변환
                                switch (key) {
                                    case "거래시간":
                                        stockData.put("timestamp", value);
                                        stockDTO.setTimestamp(value);
                                        break;
                                    case "종목코드":
                                        stockData.put("symbol", value);
                                        stockDTO.setSymbol(value);
                                        break;
                                    case "체결가격":
                                        stockData.put("price", Double.parseDouble(value));
                                        stockDTO.setPrice(Double.parseDouble(value));
                                        break;
                                    case "거래량":
                                        stockData.put("volume", Integer.parseInt(value));
                                        stockDTO.setVolume(Integer.parseInt(value));
                                        break;
                                    case "누적거래량":
                                        stockData.put("cumulativeVolume", Long.parseLong(value));
                                        stockDTO.setCumulativeVolume(Long.parseLong(value));
                                        break;
                                    default:
                                        System.out.println("Unknown key: " + key);
                                }
                            }
                        }
                        //System.out.println("stockData = " + stockData.toString());
                        // Kafka 메시지를 WebSocket 클라이언트들에게 브로드캐스트
                        // db insert
                        stockRepository.stockInsert(stockDTO);
                        broadcastMessage(stockData.toString()); // brodcast로 데이터 보냄
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                consumer.close();
            }
        }).start();
    }
}