package hospital.command;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ReceiptCommand {
	String receiptNum;
	String patientNum;
	String empNum;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime receiptDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	LocalDateTime reservationDate;
}
