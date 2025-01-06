package hospital.domain;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("surgeryAppointment")
public class SurgeryAppointmentDTO {
	String surgeryAppointmentNum;
	String surgeryName;
	LocalDateTime surgeryDate;
	LocalDateTime surgeryEndDate;
	String sempNum;
	String aempNum;
	String operatingRoomNum;
	String wardprescriptNum;
}
