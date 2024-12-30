package hospital.service.medical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.command.MedicalCommand;
import hospital.domain.MedicalDTO;
import hospital.mapper.MedicalMapper;
import hospital.mapper.ReceiptMapper;

@Service
public class MedicalInsertService {
	@Autowired
	MedicalMapper medicalMapper;
	@Autowired
	ReceiptMapper receiptMapper;

	public void execute(MedicalCommand medicalCommand) {
		MedicalDTO dto = new MedicalDTO();
		dto.setDiagnosticContent(medicalCommand.getDiagnosticContent());
		dto.setDiagnosticName(medicalCommand.getDiagnosticName());
		dto.setEmpNum(medicalCommand.getEmpNum());
		dto.setExaminationPrescript(medicalCommand.getExaminationPrescript());
		dto.setHandlePrescript(medicalCommand.getHandlePrescript());
		dto.setInputDate(medicalCommand.getInputDate());
		dto.setMedicalNum(medicalCommand.getMedicalNum());
		dto.setMedicinePrescript(medicalCommand.getMedicinePrescript());
		dto.setPatientNum(medicalCommand.getPatientNum());
		dto.setReceiptNum(medicalCommand.getReceiptNum());
		medicalMapper.medicalInsert(dto);
		
	}

}
