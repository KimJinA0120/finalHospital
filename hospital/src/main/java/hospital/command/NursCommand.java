package hospital.command;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NursCommand {
	String nursingNum;
	@NotBlank(message = "병동처방번호를 입력하십시오.")
	String wardPsNum;
	String empNum;
	@NotBlank(message = "다시 로그인 하십시오.")
	String handleNurs; // 처치 실시한 간호사이자 작성자
	
	@NotBlank(message = "간호내용을 입력하십시오.")
	String nursingCon;
	String hanPres;
	
	String callStop;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@NotNull(message = "처치일시를 입력하십시오.")
	LocalDateTime presDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date inputDate;
}
