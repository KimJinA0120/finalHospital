package hospital.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("qna")
public class QnADTO {
	String qnaNum;
	String empNum;
	String patientNum;
	String qnaType;
	String qnaTitle;
	String qnaQContent;
	Date qnaQDate;
	Date qnaADate;
	String qnaAContent;
	
	String patientId;
}
