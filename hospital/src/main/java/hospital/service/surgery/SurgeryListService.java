package hospital.service.surgery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.StartEndPageDTO;
import hospital.domain.SurgeryListDTO;
import hospital.mapper.SurgeryMapper;
import hospital.service.StartEndPageService;

@Service
public class SurgeryListService {
	@Autowired
	SurgeryMapper surgeryMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(int page, String searchWord, String kind, Model model) {
		int limit = 10;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord, null);
		
		List<SurgeryListDTO> list = surgeryMapper.surgeryList(sepDTO);
		
		int count = surgeryMapper.surgeryAppointmentCount(searchWord, null);
		startEndPageService.execute(page, limit, count, searchWord, list, model, null);
		
	}
}
