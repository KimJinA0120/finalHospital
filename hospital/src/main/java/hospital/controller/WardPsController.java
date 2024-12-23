package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.WardPsCommand;
import hospital.service.AutoNumService;
import hospital.service.wardPS.WardPsDeleteService;
import hospital.service.wardPS.WardPsInfoService;
import hospital.service.wardPS.WardPsListService;
import hospital.service.wardPS.WardPsUpdateService;
import hospital.service.wardPS.WardPsWriteService;

@Controller
@RequestMapping("wardPS")
public class WardPsController {
   
   /// 리스트
   @Autowired
   WardPsListService wardPsListService;
   @RequestMapping("wardPsList")
   public String wardPsList(Model model) {
      wardPsListService.execute(model);
      return "thymeleaf/wardPS/wardPsList";
   }
   
   
   /// 등록
   @Autowired
   AutoNumService autoNumService;  // 번호자동부여서비스
   @GetMapping("wardPsWrite")
   public String wardPsWrite(Model model) {
      String autoNum 
      = autoNumService.execute("WPS_", 5, "WARDPRESCRIPT_num", "WARDPRESCRIPT");
      model.addAttribute("autoNum", autoNum);
      return "thymeleaf/wardPS/wardPsWrite";
   }
   @Autowired
   WardPsWriteService wardPsWriteService;
   @PostMapping("wardPsWrite")
   public String wardPsWrite(WardPsCommand wardPsCommand) {
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
   
   // 삭제
   @Autowired
   WardPsDeleteService wardPsDeleteService;
   @RequestMapping("wardPsDelete")
   public String wardPsDelete(String num) {
	   wardPsDeleteService.execute(num);
	   return "redirect:wardPsList";
   }
   
}
