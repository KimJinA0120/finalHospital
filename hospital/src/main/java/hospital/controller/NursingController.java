package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.NursCommand;
import hospital.service.AutoNumService;
import hospital.service.nursing.NursingDeleteService;
import hospital.service.nursing.NursingInfoService;
import hospital.service.nursing.NursingListService;
import hospital.service.nursing.NursingUpdateService;
import hospital.service.nursing.NursingWriteService;

@Controller
@RequestMapping("nursing")
public class NursingController {
	
	// 리스트
	@Autowired
	NursingListService nursingListService;
	@RequestMapping("nursingList")
	public String nursingList(Model model) {
		nursingListService.execute(model);
		return "thymeleaf/nursing/nursingList";
	}
	
	
	// 등록
	@Autowired
	AutoNumService autoNumService;
	@GetMapping("nursingWrite")
	public String nursingWrite(Model model) {
		String autoNum = autoNumService.execute("nursing_", 9, "nursing_num", "nursing");
		model.addAttribute("autoNum", autoNum);
		return "thymeleaf/nursing/nursingWrite";
	}
	@Autowired
	NursingWriteService nursingWriteService;
	@PostMapping("nursingWrite")
	public String nursingWrite(NursCommand nursCommand) {
		nursingWriteService.execute(nursCommand);
		return "redirect:nursingList";
	}
	
	
	// 상세정보
	@Autowired
	NursingInfoService nursingInfoService;
	@RequestMapping("nursingInfo")
	public String nursingInfo(String num, Model model) {
		nursingInfoService.execute(num, model);
		return "thymeleaf/nursing/nursingInfo";
	}
	
	
	// 수정
	@GetMapping("nursingUpdate")
	public String nursingUpdate(String num, Model model) {
		nursingInfoService.execute(num, model);
		return "thymeleaf/nursing/nursingUpdate";
	}
	@Autowired
	NursingUpdateService nursingUpdateService;
	@PostMapping("nursingUpdate")
	public String nursingUpdate(NursCommand nursCommand) {
		nursingUpdateService.execute(nursCommand);
		return "redirect:nursingInfo?num="+nursCommand.getNursingNum();
	}
	
	
	// 삭제
	@Autowired
	NursingDeleteService nursingDeleteService;
	@RequestMapping("nursingDelete")
	public String nursingDelete(String num) {
		nursingDeleteService.execute(num);
		return "redirect:nursingList";
	}
	
	
	
	
}
