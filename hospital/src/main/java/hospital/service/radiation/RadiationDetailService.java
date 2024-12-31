package hospital.service.radiation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.RadiationDTO;
import hospital.mapper.RadiationMapper;

@Service
public class RadiationDetailService {
	@Autowired
	RadiationMapper radiationMapper;
	public void execute(String radiationNum, Model model) {
		RadiationDTO dto = radiationMapper.radiationOneSelect(radiationNum);
		model.addAttribute("dto", dto);
	}
}
