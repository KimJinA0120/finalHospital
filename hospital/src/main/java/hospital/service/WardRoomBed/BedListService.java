package hospital.service.WardRoomBed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.BedDTO;
import hospital.mapper.BedMapper;

@Service
public class BedListService {
	@Autowired
	BedMapper bedMapper;
	
	public void execute(Model model) {
		List<BedDTO> list = bedMapper.bedList();
		model.addAttribute("list", list);
	}

}
