package hospital.service.clinical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.ClinicalDTO;
import hospital.mapper.ClinicalMapper;

@Service
public class ClinicalDetailService {
	@Autowired
	ClinicalMapper clinicalMapper;
	public void execute(String clinicalNum, String inspectionNum, Model model) {
		ClinicalDTO dto = clinicalMapper.clinicalOneSelect(clinicalNum, inspectionNum);
		model.addAttribute("dto", dto);
	}
}
