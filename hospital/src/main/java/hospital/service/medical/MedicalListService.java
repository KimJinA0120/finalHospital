package hospital.service.medical;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.MedicalDTO;
import hospital.domain.StartEndPageDTO;
import hospital.mapper.MedicalMapper;
import hospital.service.StartEndPageService;

@Service
public class MedicalListService {
	@Autowired
	MedicalMapper medicalMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	public void execute(Integer page, String searchWord, Model model) {
		int limit = 3;
		
		StartEndPageDTO sepDTO = startEndPageService.execute(limit, page, searchWord);
		List<MedicalDTO> list = medicalMapper.medicalSelectList(sepDTO);
		
		int count = medicalMapper.medicalCount(searchWord);
		startEndPageService.execute(page, limit, count, searchWord, list, model);
	}

}
