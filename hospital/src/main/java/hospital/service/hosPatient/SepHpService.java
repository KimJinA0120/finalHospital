package hospital.service.hosPatient;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.HosPatientDTO;
import hospital.domain.RoomDTO;
import hospital.domain.SEPhosPatientDTO;


@Service
public class SepHpService {

	public SEPhosPatientDTO execute(int page, int limit, String searchWord
									, String location, String roomN, String hpState) {
		int startRow = ((page-1) * limit) + 1;
		int endRow = startRow + limit - 1;
		
		SEPhosPatientDTO hpSEP 
		= new SEPhosPatientDTO(startRow, endRow, searchWord, location, roomN, hpState);
		return hpSEP;
	}

	
	public void execute(int page, int limit, Integer count, String searchWord
						, List<HosPatientDTO> list, String location
						, List<RoomDTO> room, String roomN, String hpState
						, Model model) {
		
		int limitPage = 10; // 1 ~ 10, 11 ~ 20, 21 ~ 30, ...
		int startPageNum = (int)((double) page / limitPage + 0.95 - 1) * limitPage + 1;
		int endPageNum = startPageNum + limitPage - 1;
		int maxPage = (int)((double)count / limit + 0.95);
		if(endPageNum > maxPage) endPageNum = maxPage;
		
		if(endPageNum == 0) endPageNum = 1;
		if(searchWord == null) searchWord="";
		if(location == null) location = "";
		if(roomN==null) roomN="";
		if(hpState==null) hpState="";
		
		model.addAttribute("list", list);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("page", page);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("count", count);
		model.addAttribute("maxPage", maxPage);
		
		model.addAttribute("location", location);
		model.addAttribute("room", room);
		model.addAttribute("roomN", roomN);
		model.addAttribute("hpState", hpState);
		
	}

}
