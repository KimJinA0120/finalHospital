package hospital.service.wardPS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.WardPsDTO;
import hospital.mapper.WardPsMapper;

@Service
public class WardPsInfoService {
	
	@Autowired
	WardPsMapper wardPsMapper;
	public void execute(String num, Model model) {
		WardPsDTO dto = wardPsMapper.selectOne(num);
		model.addAttribute("wardPsCommand", dto);
	}

}
