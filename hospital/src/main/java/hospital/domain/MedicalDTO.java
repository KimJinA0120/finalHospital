package hospital.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("medical")
public class MedicalDTO {
	String medicalNum;
	String receiptNum;
	String patientNum;
	String diagnosticName;
	String diagnosticContent;
	String medicinePrescript;
	String examinationPrescript;
	String handlePrescript;
	Date inputDate;
	String empNum;
}
