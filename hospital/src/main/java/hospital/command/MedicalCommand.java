package hospital.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MedicalCommand {
	String medicalNum;
	String receiptNum;
	String patientNum;
	String diagnosticName;
	String diagnosticContent;
	String medicinePrescript;
	String examinationPrescript;
	String handlePrescript;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date inputDate;
	String empNum;
}
