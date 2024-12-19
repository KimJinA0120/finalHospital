package hospital.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SurgeryCommand {
	String surgeryNum;
	String surgeryAppointmentNum;
	String surgeryContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date inputDate;
	String sempNum;
}
