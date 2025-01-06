package hospital.service.wardPS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.HosPatientDTO;
import hospital.domain.RoomDTO;
import hospital.domain.SEPhosPatientDTO;
import hospital.domain.WardPsDTO;
import hospital.mapper.HosPatientMapper;
import hospital.mapper.WardPsMapper;
import hospital.service.hosPatient.SepHpService;

@Service
public class WardPsListService {
   
   @Autowired
   WardPsMapper wardPsMapper;
   @Autowired
   HosPatientMapper hosPatientMapper;
   @Autowired
   SepHpService sepHpService;
   public void execute(int page, String searchWord, String location
		   				, String roomN, String hpState, Model model) {
      int limit = 10;
      SEPhosPatientDTO hpSEP 
      = sepHpService.execute(page, limit, searchWord, location, roomN, hpState);
      
	  List<WardPsDTO> list = wardPsMapper.selectList(hpSEP);
	  List<RoomDTO> room = hosPatientMapper.selectDropDown(location);
	  
	  Integer count = wardPsMapper.count(); // 입원번호 숫자
	  
      sepHpService.execute(page, limit, count, searchWord, list, location, room, roomN, hpState, model);
   }

}

