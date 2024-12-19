package hospital.domain;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("receipt")
public class ReceiptDTO {
	String receiptNum;
	String patientNum;
	String empNum;
	LocalDateTime receiptDate;
	LocalDateTime reservationDate;
}
