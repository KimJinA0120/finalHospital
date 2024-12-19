package hospital.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("surgery")
public class SurgeryDTO {
	String surgeryNum;
	String surgeryAppointmentNum;
	String surgeryContent;
	Date inputDate;
	String sempNum;
}
