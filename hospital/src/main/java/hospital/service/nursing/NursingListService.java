package hospital.service.nursing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.NursingDTO;
import hospital.domain.StartEndPageDTO;
import hospital.mapper.NursingMapper;
import hospital.service.StartEndPageService;

@Service
public class NursingListService {
	
	@Autowired
	NursingMapper nursingMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(int page, String searchWord, Model model) {
		int limit=10;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord, null);
		List<NursingDTO> list = nursingMapper.selectList(sepDTO);
		Integer count = nursingMapper.count();
		
		startEndPageService.execute(page,limit,count,searchWord,list, model, null);
	}

}
