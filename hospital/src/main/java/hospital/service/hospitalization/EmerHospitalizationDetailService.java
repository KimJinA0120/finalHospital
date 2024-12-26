package hospital.service.hospitalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.EmergencyPatientDTO;
import hospital.mapper.HospitalizationMapper;

@Service
public class EmerHospitalizationDetailService {
	@Autowired
	HospitalizationMapper hospitalizationMapper;
	
	public void execute(Model model, String emerPatientNum) {
		EmergencyPatientDTO dto = hospitalizationMapper.emerSelectOne(emerPatientNum);
		model.addAttribute("dto", dto);
	}
	
}
