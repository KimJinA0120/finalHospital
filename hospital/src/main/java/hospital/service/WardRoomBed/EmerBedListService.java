package hospital.service.WardRoomBed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.EmergencyDTO;
import hospital.mapper.BedMapper;

@Service
public class EmerBedListService {
	@Autowired
	BedMapper bedMapper;
	
	public void execute(Model model) {
		List<EmergencyDTO> list = bedMapper.emerBedList();
		model.addAttribute("list", list);
	}

}
