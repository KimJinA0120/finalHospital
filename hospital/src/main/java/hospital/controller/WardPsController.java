package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hospital.command.WardPsCommand;
import hospital.service.AutoNumService;
import hospital.service.hosPatient.SearchHospService;
import hospital.service.wardPS.WardPsInfoService;
import hospital.service.wardPS.WardPsListService;
import hospital.service.wardPS.WardPsUpdateService;
import hospital.service.wardPS.WardPsWriteService;

@Controller
@RequestMapping("wardPS") /// 슬랙시 '/'는 루트이다. 그러므로 링크 앞에 /가 붙으면 홈페이지 바로 아래??가 된다.
public class WardPsController {
	

	@GetMapping("wardPsList")
	public String wardPsList() {
		
		return "thymeleaf/wardPS/wardPsList";
	}	
	
   @Autowired
   WardPsListService wardPsListService;
   @RequestMapping("WholeWardPsList")
   public String WholeWardPsList(
		   	@RequestParam(value = "page", required = false, defaultValue = "1") int page
		   , @RequestParam(value = "searchWord", required = false) String searchWord
		   , @RequestParam(value = "location", required = false) String location
		   , @RequestParam(value = "roomN", required = false) String roomN
		   , @RequestParam(value = "hpState", required = false) String hpState
		   , Model model) {
      wardPsListService.execute(page, searchWord, location, roomN, hpState, model);
      return "thymeleaf/wardPS/WholeWardPsList";
   }
   
   
   /// 등록
   @Autowired
   AutoNumService autoNumService;  // 번호자동부여서비스
   @GetMapping("wardPsWrite")
   public String wardPsWrite(Model model) {
      String autoNum 
      = autoNumService.execute("WPS_", 5, "WARDPRESCRIPT_num", "WARDPRESCRIPT");
      
      WardPsCommand wardPsCommand = new WardPsCommand();
      wardPsCommand.setWardPsNum(autoNum);
      model.addAttribute("wardPsCommand", wardPsCommand);
      return "thymeleaf/wardPS/wardPsWrite";
   }
   @Autowired
   WardPsWriteService wardPsWriteService;
   @PostMapping("wardPsWrite")
   public String wardPsWrite(@Validated WardPsCommand wardPsCommand
		   					, BindingResult result) {
	  if (result.hasErrors()) {
		  return "thymeleaf/wardPS/wardPsWrite";
	} 
      wardPsWriteService.execute(wardPsCommand);
      return "redirect:wardPsList";
   }
   
   
  
   
   // 상세정보
   @Autowired
   WardPsInfoService wardPsInfoService;
   @GetMapping("wardPsInfo")
   public String wardPsInfo(String num ,Model model) {
	   wardPsInfoService.execute(num, model);
	   return "thymeleaf/wardPS/wardPsInfo";
   }
   
   
   // 수정
   @GetMapping("wardPsUpdate")
   public String wardPsUpdate(String num, Model model) {
	   wardPsInfoService.execute(num, model);
	   return "thymeleaf/wardPS/wardPsUpdate";
   }
   @Autowired
   WardPsUpdateService wardPsUpdateService;
   @PostMapping("wardPsUpdate")
   public String wardPsUpdate(WardPsCommand wardPsCommand) {
	   wardPsUpdateService.execute(wardPsCommand);
	   return "redirect:wardPsInfo?num="+wardPsCommand.getWardPsNum();
   }
   
   ////////////// 입원번호 찾기
   @Autowired
   SearchHospService searchHospService;
   
   @GetMapping("searchHosp")
   public String searchHosp(
		   @RequestParam(value = "page", required = false, defaultValue = "1") int page
		   , @RequestParam(value = "searchWord", required = false) String searchWord
		   , @RequestParam(value = "location", required = false) String location
		   , @RequestParam(value = "roomN", required = false) String roomN
		   , Model model) {
	   searchHospService.execute(page, searchWord, location, roomN, model);
	   return "thymeleaf/hosPatient/searchHosp";
   }
 
   
}
