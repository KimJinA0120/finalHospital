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
									, String location, String hpStatus) {
		int startRow = ((page-1) * limit) + 1;
		int endRow = startRow + limit - 1;
		SEPhosPatientDTO hpSEP 
		= new SEPhosPatientDTO(startRow, endRow, searchWord, location, hpStatus);
		return hpSEP;
	}

	
	public void execute(int page, int limit, Integer count, String searchWord
						, List<HosPatientDTO> list, Model model
						,List<RoomDTO> room) {
		
		int limitPage = 10; // 1 ~ 10, 11 ~ 20, 21 ~ 30, ...
		int startPageNum = (int)((double) page / limitPage + 0.95 - 1) * limitPage + 1;
		int endPageNum = startPageNum + limitPage - 1;
		int maxPage = (int)((double)count / limit + 0.95);
		if(endPageNum > maxPage) endPageNum = maxPage;
		
		if(endPageNum == 0) endPageNum = 1;
		if(searchWord == null) searchWord="";
		
		model.addAttribute("list", list);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("page", page);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("count", count);
		model.addAttribute("maxPage", maxPage);
		
		model.addAttribute("room", room);
		
	}

}
