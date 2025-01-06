package hospital.service.WardRoomBed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.WardDTO;
import hospital.mapper.BedMapper;

@Service
public class WardListService {
	@Autowired
	BedMapper bedMapper;
	
	public void execute(String wardNum, Model model) {
		List<WardDTO> list = bedMapper.wardList(wardNum);
		model.addAttribute("list", list);
	}

}
