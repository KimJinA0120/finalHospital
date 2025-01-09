package hospital.service.hospitalization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.HospitalizationDTO;
import hospital.domain.StartEndPageDTO;
import hospital.mapper.HospitalizationMapper;
import hospital.service.StartEndPageService;

@Service
public class HospitalizationListService {
	@Autowired
	HospitalizationMapper hospitalizationMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	public void execute(Integer page, String searchWord, Model model) {
		int limit = 10;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord, null);
		List<HospitalizationDTO> list = hospitalizationMapper.hospitalizationSelectList(sepDTO);
		int count = hospitalizationMapper.hospitalizatonCount(searchWord);
		startEndPageService.execute(page, limit, count, searchWord, list, model, null);
	}

}
