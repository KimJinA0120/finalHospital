package hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.data.KafkaWebSocketServer;
import hospital.domain.AuthInfoDTO;
import jakarta.servlet.http.HttpSession;

@SpringBootApplication
@Controller
public class HospitalApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HospitalApplication.class, args);
		KafkaWebSocketServer server = context.getBean(KafkaWebSocketServer.class); // Spring에서 관리되는 빈으로 가져오기
        server.start(); // 서버 시작
        server.startKafkaConsumer(); 
	}

	@RequestMapping("/")
	public String index(HttpSession session) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		if(auth==null||auth.getGrade().equals("pat")) { //세션이 없거나 등급이 환자인 경우
			return "thymeleaf/index";
		}else {
			return "thymeleaf/empIndex";
		}
		
		
	}
	@RequestMapping("404")
	public String error() {
		
		return "thymeleaf/404";
	}
	@RequestMapping("blog-single")
	public String blog() {
		
		return "thymeleaf/blog-single";
	}
	@RequestMapping("contact")
	public String contact() {
		
		return "thymeleaf/contact";
	}
	@RequestMapping("appointment")
	public String appointment() {
		
		return "thymeleaf/appointment";
	}
	
	// 직원 헤더
	@GetMapping("getHeader")
	public String getHeader() {
		return "thymeleaf/getCss/getHeader";
	}
	
	// 환자용 헤더
	@GetMapping("getPatHeader")
	public String getPatHeader() {
		return "thymeleaf/getCss/getPatHeader";
	}
	
	@GetMapping("getFooter")
	public String getFooter() {
		return "thymeleaf/getCss/getFooter";
	}
	
}
