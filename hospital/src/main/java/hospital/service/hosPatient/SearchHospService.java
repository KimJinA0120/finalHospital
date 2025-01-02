package hospital.service.hosPatient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.HosPatientDTO;
import hospital.domain.RoomDTO;
import hospital.domain.SEPhosPatientDTO;
import hospital.domain.StartEndPageDTO;
import hospital.mapper.HosPatientMapper;
import hospital.service.StartEndPageService;

@Service
public class SearchHospService {
	
	@Autowired
	StartEndPageService startEndPageService;
	@Autowired
	SepHpService sepHpService;
	@Autowired
	HosPatientMapper hosPatientMapper;
	
	public void execute(int page, String searchWord, String location, String hpStatus, Model model) {
		int limit=10;
		
		/*
		 * StartEndPageDTO sepDTO = startEndPageService.execute(page, limit,
		 * searchWord);
		 * 
		 * List<HosPatientDTO> list = hosPatientMapper.searchList(sepDTO); Integer count
		 * = hosPatientMapper.searchCount();
		 * 
		 * startEndPageService.execute(page,limit,count,searchWord,list, model);
		 */
		
//		String hpStatus = "";

		SEPhosPatientDTO hpSEP 
		= sepHpService.execute(page, limit, searchWord, location, hpStatus);
		
		List<HosPatientDTO> list = hosPatientMapper.searchList(hpSEP);
		
		List<RoomDTO> room = hosPatientMapper.selectDropDown(location);
		
		Integer count = hosPatientMapper.searchCount(); // 입원번호 숫자
		sepHpService.execute(page,limit,count,searchWord,list, model, room);
		
	}

	public void selectWardPs(int page, String searchWord, Model model) {
		int limit=10;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord, null);
		
		List<HosPatientDTO> list = hosPatientMapper.searchWardPs(sepDTO);
		Integer count = hosPatientMapper.searchCount();
		
		startEndPageService.execute(page,limit,count,searchWord,list, model, null);
		
	}

}
