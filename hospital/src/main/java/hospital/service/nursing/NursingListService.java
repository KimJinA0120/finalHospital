package hospital.service.nursing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.HosPatientDTO;
import hospital.domain.RoomDTO;
import hospital.domain.SEPhosPatientDTO;
import hospital.mapper.HosPatientMapper;
import hospital.mapper.NursingMapper;
import hospital.service.hosPatient.SepHpService;

@Service
public class NursingListService {
	
	@Autowired
	NursingMapper nursingMapper;
	@Autowired
	SepHpService sepHpService;
	@Autowired
	HosPatientMapper hosPatientMapper;
	
	public void execute(int page, String searchWord, String location
						, String roomN, Model model) {
		int limit=10;
		SEPhosPatientDTO hpSEP 
		= sepHpService.execute(page, limit, searchWord, location, roomN, null);
		
		List<HosPatientDTO> list = nursingMapper.selectList(hpSEP);
		Integer count = nursingMapper.count();
		
		List<RoomDTO> room = hosPatientMapper.selectDropDown(location);
		
		sepHpService.execute(page,limit,count,searchWord,list,location,room,roomN, null, model);
	}
	
	public void wholeList(int page, String searchWord, String location, String roomN
			, String hpState, Model model) {
		
		
	}
	
}
