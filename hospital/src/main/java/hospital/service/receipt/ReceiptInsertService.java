package hospital.service.receipt;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.ReceiptCommand;
import hospital.domain.ReceiptDTO;
import hospital.mapper.ReceiptMapper;

@Service
public class ReceiptInsertService {
	@Autowired
	ReceiptMapper receiptMapper;
	
	public void execute(ReceiptCommand receiptCommand) {
		ReceiptDTO dto = new ReceiptDTO();
		dto.setEmpNum(receiptCommand.getEmpNum());
		dto.setPatientNum(receiptCommand.getPatientNum());
		dto.setReceiptDate(receiptCommand.getReceiptDate());
		dto.setReceiptNum(receiptCommand.getReceiptNum());
		dto.setReservationDate(receiptCommand.getReservationDate());
		receiptMapper.receiptInsert(dto);
	}
	public void execute1(ReceiptCommand receiptCommand) {
		ReceiptDTO dto = new ReceiptDTO();
		dto.setEmpNum(receiptCommand.getEmpNum());
		dto.setPatientNum(receiptCommand.getPatientNum());
		dto.setReceiptDate(receiptCommand.getReceiptDate());
		dto.setReceiptNum(receiptCommand.getReceiptNum());
		dto.setReservationDate(receiptCommand.getReservationDate());
		receiptMapper.reservationInsert(dto);
	}
}
