package hospital.service.surgery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.OperatingRoomDTO;
import hospital.mapper.SurgeryMapper;

@Service
public class OperatingRoomListService {
	@Autowired
	SurgeryMapper surgeryMapper;
	public void execute(Model model) {
		List<OperatingRoomDTO> list = surgeryMapper.operatingRoomList();
		
		model.addAttribute("list", list);
	}
}
