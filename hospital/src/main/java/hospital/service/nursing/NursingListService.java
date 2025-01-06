package hospital.service.nursing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.NursingDTO;

import hospital.domain.StartEndPageDTO;
import hospital.mapper.HosPatientMapper;
import hospital.mapper.NursingMapper;
import hospital.service.StartEndPageService;
import hospital.service.hosPatient.SepHpService;

@Service
public class NursingListService {
	
	@Autowired
	NursingMapper nursingMapper;
	@Autowired
	SepHpService sepHpService;
	@Autowired
	HosPatientMapper hosPatientMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(int page, String searchWord, String kind, Model model) {
		int limit=10;
		if( kind != null && kind.equals("all")) { kind = null; }
		
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord, kind);
		
		List<NursingDTO> list = nursingMapper.selectList(sepDTO);
		
		Integer count = nursingMapper.count(); // 간호일지 숫자
		
		startEndPageService.execute(page, limit, count, searchWord, list, model, kind);
		
	}
			
	
}
