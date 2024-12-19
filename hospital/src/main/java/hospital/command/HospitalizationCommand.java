package hospital.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class HospitalizationCommand {
	String hospitalizationNum;
	String bedNum;
	String patientNum;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date inDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date outDate;
	String hospitalizationStatus;

}
