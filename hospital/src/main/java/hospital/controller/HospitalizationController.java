package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.HospitalizationCommand;
import hospital.service.AutoNumService;
import hospital.service.hospitalization.EmerHospitalizationListService;
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
	// 입원
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
	// 응급입원
	@Autowired
	EmerHospitalizationListService emerHospitalizationListService;
	
	
	
	//////// 응급입원
	@RequestMapping("emerHospitalizationList") // 응급 입원 리스트
	public String emerhospitalizationList(Model model) {
		emerHospitalizationListService.execute(model);
		return "thymeleaf/hospitalization/emerHospitalizationList";
	}
	@RequestMapping("emerHospitalizationForm") // 응급입원 등록 화면
	public String emerHospitalizationForm(Model model) {
		String autoNum = autoNumService.execute("EMERHOS_", 9, "HOSPITALIZATION_NUM", "hospitalization");
		HospitalizationCommand hospitalizationCommand = new HospitalizationCommand();
		hospitalizationCommand.setHospitalizationNum(autoNum);
		model.addAttribute("hospitalizationCommand", hospitalizationCommand);
		return "thymeleaf/hospitalization/emerHospitalizationForm";
	}
	@PostMapping("emerHospitalizationRegist") // 응급입원 등록 
	public String emerHospitalizationRegist(HospitalizationCommand hospitalizationCommand) {
		hospitalizationWriteService.execute(hospitalizationCommand);
		return "redirect:emerHospitalizationList";
	}
	@GetMapping("emerHospitalizationDetail")
	public String emerHospitalizationDetail(String hospitalizationNum, Model model) {
		hospitalizationDetailService.execute(model, hospitalizationNum);
		return "thymeleaf/hospitalization/emerHospitalizationInfo";
	}
	@GetMapping("emerHospitalizationUpdate")
	public String emerHospitalizationUpdate(String hospitalizationNum, Model model) {
		hospitalizationDetailService.execute(model, hospitalizationNum);
		return "thymeleaf/hospitalization/emerHospitalizationModify";
	}
	@PostMapping("emerHospitalizationUpdate") // 입원 수정 
	public String emerHospitalizationUpdate(HospitalizationCommand hospitalizationCommand) {
		hospitalizationUpdateService.execute(hospitalizationCommand);
		return "redirect:emerHospitalizationList";
	}
	
	
	//////// 입원
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
	@GetMapping("hospitalizationUpdate") // 입원 수정화면 
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
