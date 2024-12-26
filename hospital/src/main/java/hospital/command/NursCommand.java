package hospital.command;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class NursCommand {
	String nursingNum;
	String wardPsNum;
	String empNum;
	String handleNurs; // 처치 실시한 간호사이자 작성자
	String updateNurs; // 수정한 간호사
	String nursingCon;
	String hanPres;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	LocalDateTime presDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date inputDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date updateDate;
}
