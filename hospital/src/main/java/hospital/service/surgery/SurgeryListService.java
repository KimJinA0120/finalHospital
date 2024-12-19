package hospital.service.surgery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.SurgeryDTO;
import hospital.mapper.SurgeryMapper;

@Service
public class SurgeryListService {
	@Autowired
	SurgeryMapper surgeryMapper;
	public void execute(Model model) {
		List<SurgeryDTO> list = surgeryMapper.surgeryList();
		
		model.addAttribute("list", list);
	}
}
