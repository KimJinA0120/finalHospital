package hospital.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("stockDTO")
public class StockDTO {
	String timestamp;
	String symbol;
	double price;
	int volume;
	long cumulativeVolume;
	Timestamp createdDate;

}
