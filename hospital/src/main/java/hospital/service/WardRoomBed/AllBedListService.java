package hospital.service.WardRoomBed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.BedDTO;
import hospital.domain.EmergencyDTO;
import hospital.mapper.BedMapper;

@Service
public class AllBedListService {
	@Autowired
	BedMapper bedMapper;
	
	public void execute(Model model) {
		List<BedDTO> list = bedMapper.bedList();
		model.addAttribute("list", list);
		List<EmergencyDTO> emerlist = bedMapper.emerBedList();
		model.addAttribute("emerlist", emerlist);
	}

}
