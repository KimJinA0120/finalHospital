package hospital.command;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class InspectionCommand {
	String inspectionNum;
	String inspectionName;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime inspectionDate;
	String wardprescriptNum;
	String medicalNum;
	String inspectionKind;
}
