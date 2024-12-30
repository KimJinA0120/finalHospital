package hospital.service.medical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.MedicalCommand;
import hospital.domain.MedicalDTO;
import hospital.mapper.MedicalMapper;

@Service
public class MedicalUpdateService {
	@Autowired
	MedicalMapper medicalMapper;
	
	public void execute(MedicalCommand medicalCommand) {
		MedicalDTO dto = new MedicalDTO();
		dto.setMedicalNum(medicalCommand.getMedicalNum());
		dto.setDiagnosticContent(medicalCommand.getDiagnosticContent());
		dto.setDiagnosticName(medicalCommand.getDiagnosticName());
		dto.setExaminationPrescript(medicalCommand.getExaminationPrescript());
		dto.setHandlePrescript(medicalCommand.getHandlePrescript());
		dto.setInputDate(medicalCommand.getInputDate());
		dto.setMedicinePrescript(medicalCommand.getMedicinePrescript());
		medicalMapper.medicalUpdate(dto);
	}

}
