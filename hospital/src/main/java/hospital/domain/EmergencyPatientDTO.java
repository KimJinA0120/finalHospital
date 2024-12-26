package hospital.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("EmergencyPatientDTO")
public class EmergencyPatientDTO {
	String emerPatientNum;
	String emerBedNum;
	String patientNum;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date inDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date outDate;
	String docNum;
	String nurNum;
	String hospitalizationStatus;
}
