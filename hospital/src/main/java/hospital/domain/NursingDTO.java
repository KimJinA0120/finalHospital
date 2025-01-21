package hospital.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Alias("nursing")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NursingDTO {
	String nursingNum;
	String wardPsNum;
	String empNum;
	String handleNurs;
	
	String nursingCon;
	String hanPres;
	
	String callStop;
	
	Date presDate;
	Date inputDate;
}
