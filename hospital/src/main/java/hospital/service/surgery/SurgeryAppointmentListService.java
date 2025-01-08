package hospital.service.surgery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.StartEndPageDTO;
import hospital.domain.SurgeryAppointmentDTO;
import hospital.mapper.SurgeryMapper;
import hospital.service.StartEndPageService;

@Service
public class SurgeryAppointmentListService {
	@Autowired
	SurgeryMapper surgeryMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(String operatingRoomNum, int page, String searchWord, String kind, Model model) {
		int limit = 10;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord, kind);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("limit", limit);
		map.put("searchWord", searchWord);
		map.put("kind", kind);
		map.put("operatingRoomNum", operatingRoomNum);
		map.put("startRow", sepDTO.getStartRow());
		map.put("endRow", sepDTO.getEndRow());
		
		List<SurgeryAppointmentDTO> list = surgeryMapper.surgeryAppointmentList(map);
		
		int count = surgeryMapper.surgeryAppointmentCount(searchWord, kind);
		startEndPageService.execute(page, limit, count, searchWord, list, model, kind);
	}
}
