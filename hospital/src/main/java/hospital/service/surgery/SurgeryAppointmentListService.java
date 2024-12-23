package hospital.service.surgery;

import java.util.List;

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
	public void execute(int page, String searchWord, Model model) {
		int limit = 10;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord);
		
		List<SurgeryAppointmentDTO> list = surgeryMapper.surgeryAppointmentList(sepDTO);
		
		int count = surgeryMapper.surgeryAppointmentCount(searchWord);
		startEndPageService.execute(page, limit, count, searchWord, list, model);
	}
}
