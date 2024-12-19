package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.WardPsCommand;
import hospital.service.AutoNumService;

@Controller
@RequestMapping("wardPS")
public class WardPsController {
	
	/// 리스트
	
	@RequestMapping("wardPsList")
	public String wardPsList() {
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
	
	@PostMapping("wardPsWrite")
	public String wardPsWrite(WardPsCommand wardPsCommand) {
		return "redirect:wardPsList";
	}
	
	
	
	
	
	
	
}
