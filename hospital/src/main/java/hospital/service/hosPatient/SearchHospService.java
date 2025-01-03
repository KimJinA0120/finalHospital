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
	
	public void execute(int page, String searchWord
						, String location, String roomN, Model model) {
		int limit=10;
		if(searchWord != null && searchWord != "") {
			searchWord = searchWord.trim();
		}
		
		SEPhosPatientDTO hpSEP 
		= sepHpService.execute(page, limit, searchWord, location, roomN);
		
		List<HosPatientDTO> list = hosPatientMapper.searchList(hpSEP);
		
		List<RoomDTO> room = hosPatientMapper.selectDropDown(location);
		
		Integer count = hosPatientMapper.searchCount(); // 입원번호 숫자
		sepHpService.execute(page,limit,count,searchWord,list
							, location, room, roomN, model);
		
	}

	public void selectWardPs(int page, String searchWord, String location, String roomN, Model model) {
		int limit=10;
		SEPhosPatientDTO hpSEP 
		= sepHpService.execute(page, limit, searchWord, location, roomN);
		
		List<HosPatientDTO> list = hosPatientMapper.searchWardPs(hpSEP);
		
		List<RoomDTO> room = hosPatientMapper.selectDropDown(location);
		
		Integer count = hosPatientMapper.searchCount(); // 입원번호 숫자
		sepHpService.execute(page,limit,count,searchWord,list
							, location, room, roomN, model);
		
		
		
	}

}
