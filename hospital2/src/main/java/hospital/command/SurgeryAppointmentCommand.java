package hospital.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SurgeryAppointmentCommand {
	String surgeryAppointmentNum;
	String surgeryName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date surgeryDate;
	
	String sempNum;
	String aempNum;
	String operatingRoomNum;
	String wardprescriptNum;
}
