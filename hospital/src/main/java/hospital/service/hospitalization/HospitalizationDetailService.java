package hospital.service.hospitalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.HospitalizationDTO;
import hospital.mapper.HospitalizationMapper;

@Service
public class HospitalizationDetailService {
	@Autowired
	HospitalizationMapper hospitalizationMapper;
	
	public void execute(Model model, String hospitalizationNum) {
		HospitalizationDTO dto = hospitalizationMapper.hospitalizationSelectOne(hospitalizationNum);
		model.addAttribute("hospitalizationCommand", dto);
	}

}
