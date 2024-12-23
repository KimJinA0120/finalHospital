package hospital.service.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.PatientDTO;
import hospital.domain.StartEndPageDTO;
import hospital.mapper.PatientMapper;
import hospital.service.StartEndPageService;

@Service
public class PatientListService {
	@Autowired
	PatientMapper patientMapper;
	@Autowired
	StartEndPageService startEndPageService;

	public void execute(Integer page, String searchWord, Model model) {
		int limit=10;
		
		StartEndPageDTO sepDTO=startEndPageService.execute(page, limit, searchWord);
		List<PatientDTO> list=patientMapper.patientSelectAll(sepDTO);
		
		Integer count=patientMapper.patientCount();
		startEndPageService.execute(page, limit, count,  searchWord, list, model);
		
		//model.addAttribute("list", list);
		
	}

	public void patientSearch(Integer page, String searchWord, Model model) {
		int limit=10;
		
		StartEndPageDTO sepDTO=startEndPageService.execute(page, limit, searchWord);
		List<PatientDTO> list=patientMapper.patientSelectAll(sepDTO);
		
		Integer count=patientMapper.patientCount();
		startEndPageService.execute(page, limit, count,  searchWord, list, model);
		
		//model.addAttribute("list", list);
		
	}

}
