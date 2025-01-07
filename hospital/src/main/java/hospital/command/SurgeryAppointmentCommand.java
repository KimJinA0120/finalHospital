package hospital.command;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SurgeryAppointmentCommand {
	String surgeryAppointmentNum;
	String surgeryName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime surgeryDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime surgeryEndDate;
	
	String sempNum;
	String aempNum;
	String operatingRoomNum;
	String wardprescriptNum;
	String surgeryStatus;
}
