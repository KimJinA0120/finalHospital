package hospital.service.WardRoomBed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.RoomDTO;
import hospital.mapper.BedMapper;

@Service
public class AllRoomListService {
	@Autowired
	BedMapper bedMapper;
	
	public void execute(Model model) {
		List<RoomDTO> list = bedMapper.allRoomList();
		model.addAttribute("list", list);
	}
}
