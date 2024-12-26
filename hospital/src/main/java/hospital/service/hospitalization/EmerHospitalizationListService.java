package hospital.service.hospitalization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.HospitalizationDTO;
import hospital.mapper.HospitalizationMapper;

@Service
public class EmerHospitalizationListService {
	@Autowired
	HospitalizationMapper hospitalizationMapper;
	
	public void execute(Model model) {
		List<HospitalizationDTO> list = hospitalizationMapper.emerHospitalizationSelectList();
		model.addAttribute("list", list);
		
	}

}
