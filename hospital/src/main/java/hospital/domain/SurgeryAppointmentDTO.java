package hospital.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("surgeryAppointment")
public class SurgeryAppointmentDTO {
	String surgeryAppointmentNum;
	String surgeryName;
	Date surgeryDate;
	String sempNum;
	String aempNum;
	String operatingRoomNum;
	String wardprescriptNum;
}
