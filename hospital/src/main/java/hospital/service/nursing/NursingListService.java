package hospital.service.nursing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.NursingDTO;
import hospital.mapper.NursingMapper;

@Service
public class NursingListService {
	
	@Autowired
	NursingMapper nursingMapper;
	public void execute(Model model) {
		List<NursingDTO> list = nursingMapper.selectList();
		model.addAttribute("list", list);
	}

}
