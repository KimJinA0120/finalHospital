package hospital.service.medical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.MedicalDTO;
import hospital.mapper.MedicalMapper;

@Service
public class MedicalInfoService {
	@Autowired
	MedicalMapper medicalMapper;
	
	public void execute(String medicalNum, Model model) {
		MedicalDTO dto = medicalMapper.medicalSelectOne(medicalNum);
		model.addAttribute("medicalCommand", dto);
	}
	
}
