package hospital.service.radiation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.RadiatInspectionDTO;
import hospital.mapper.RadiationMapper;

@Service
public class RadiationListService {
	@Autowired
	RadiationMapper radiationMapper;
	public void execute(Model model) {
		List<RadiatInspectionDTO> list = radiationMapper.radiationAllSelect();
		model.addAttribute("list", list);
	}
}
