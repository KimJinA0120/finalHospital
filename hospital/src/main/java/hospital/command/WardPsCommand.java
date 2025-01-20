package hospital.command;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class WardPsCommand {
	String wardPsNum;
	@NotBlank(message = "입원번호를 선택하세요.")
	String hospNum;
	String empNum; // 담당의
	String writeDoc; // 작성자
	   
	@NotBlank(message = "진단명을 입력하세요.")
	String diagName;
	@NotEmpty(message = "진단내용을 입력하세요.")
	String diagCont;
	String medicPres;
	String examPres;
	String hanPres;
	
	String callStop;
	String stopCause;
	String stopDoc;
	   
	Date inputDate;
	Date stopDate;
}
