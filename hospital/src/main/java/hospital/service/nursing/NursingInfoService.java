package hospital.service.nursing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.NursingDTO;
import hospital.mapper.NursingMapper;

@Service
public class NursingInfoService {
	
	@Autowired
	NursingMapper nursingMapper;
	public void execute(String num, Model model) {
		NursingDTO dto = nursingMapper.selectOne(num);
		model.addAttribute("nursCommand", dto);
	}

}
