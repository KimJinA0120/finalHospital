package hospital.service.surgery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.SurgeryDTO;
import hospital.mapper.SurgeryMapper;

@Service
public class SurgeryDetailService {
	@Autowired
	SurgeryMapper surgeryMapper;
	public void execute(String surgeryNum, Model model) {
		SurgeryDTO dto = surgeryMapper.surgeryOneSelect(surgeryNum);
		model.addAttribute("dto", dto);
	}
}
