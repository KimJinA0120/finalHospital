package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.HospitalizationCommand;
import hospital.service.AutoNumService;
import hospital.service.hospitalization.HospitalizationDeleteService;
import hospital.service.hospitalization.HospitalizationDetailService;
import hospital.service.hospitalization.HospitalizationListService;
import hospital.service.hospitalization.HospitalizationUpdateService;
import hospital.service.hospitalization.HospitalizationWriteService;

@Controller
@RequestMapping("Hospitalization")
public class HospitalizationController {
	
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	HospitalizationWriteService hospitalizationWriteService;
	@Autowired
	HospitalizationListService hospitalizationListService;
	@Autowired
	HospitalizationDetailService hospitalizationDetailService;
	@Autowired
	HospitalizationUpdateService hospitalizationUpdateService;
	@Autowired
	HospitalizationDeleteService hospitalizationDeleteService;
	
	@RequestMapping("hospitalizationList") // 입원 리스트
	public String hospitalizationList(Model model) {
		hospitalizationListService.execute(model);
		return "thymeleaf/hospitalization/hospitalizationList";
	}
	
	@GetMapping("hospitalizationForm") // 입원 등록 화면
	public String hospitalizationForm(Model model) {
		String autoNum 
		= autoNumService.execute("HOS_", 5, "HOSPITALIZATION_NUM", "hospitalization");
		HospitalizationCommand hospitalizationCommand = new HospitalizationCommand();
		hospitalizationCommand.setHospitalizationNum(autoNum);
		// model.addAttribute("autoNum", autoNum);
		model.addAttribute("hospitalizationCommand",hospitalizationCommand);
		return "thymeleaf/hospitalization/hospitalizationForm";
	}
	
	@PostMapping("hospitalizationRegist") // 입원 등록
	public String hospitalizationRegist(HospitalizationCommand hospitalizationCommand) {
		hospitalizationWriteService.execute(hospitalizationCommand);
		return "redirect:hospitalizationList";
	}
	
	@GetMapping("hospitalizationDetail") // 입원 상세
	public String hospitalizationDetail(String hospitalizationNum, Model model) {
		hospitalizationDetailService.execute(model, hospitalizationNum);
		return "thymeleaf/hospitalization/hospitalizationInfo";
	}
	
	@GetMapping(value="hospitalizationUpdate") // 입원 수정화면
	public String hospitalizationUpdate(String hospitalizationNum, Model model) {
		hospitalizationDetailService.execute(model, hospitalizationNum);
		return "thymeleaf/hospitalization/hospitalizationModify";
	}
	
	@PostMapping("hospitalizationUpdate") // 입원 수정
	public String hospitalizationUpdate(HospitalizationCommand hospitalizationCommand) {
		hospitalizationUpdateService.execute(hospitalizationCommand);
		return "redirect:hospitalizationList";
	}
	
	@GetMapping("hospitalizationDelete") // 입원내역 삭제
	public String hospitalizationDelete(String hospitalizationNum) {
		hospitalizationDeleteService.execute(hospitalizationNum);
		return "redirect:hospitalizationList";
	}
	

}
