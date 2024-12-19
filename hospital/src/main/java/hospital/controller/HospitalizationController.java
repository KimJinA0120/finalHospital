package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("hospitalizationList")
	public String hospitalizationList(Model model) {
		hospitalizationListService.execute(model);
		return "thymeleaf/hospitalization/hospitalizationList";
	}
	
	@GetMapping("hospitalizationForm")
	public String hospitalizationForm(Model model) {
		String autoNum 
		= autoNumService.execute("HOS_", 5, "HOSPITALIZATION_NUM", "hospitalization");
		HospitalizationCommand hospitalizationCommand = new HospitalizationCommand();
		hospitalizationCommand.setHospitalizationNum(autoNum);
		// model.addAttribute("autoNum", autoNum);
		model.addAttribute("hospitalizationCommand",hospitalizationCommand);
		return "thymeleaf/hospitalization/hospitalizationForm";
	}
	
	@PostMapping("hospitalizationRegist")
	public String hospitalizationRegist(HospitalizationCommand hospitalizationCommand) {
		hospitalizationWriteService.execute(hospitalizationCommand);
		return "redirect:hospitalizationList";
	}
	
	@GetMapping("hospitalizationDetail/{hospitalizationNum}")
	public String hospitalizationDetail(
			@PathVariable("hospitalizationNum") String hospitalizationNum
			, Model model) {
		hospitalizationDetailService.execute(model, hospitalizationNum);
		return "thymeleaf/hospitalization/hospitalizationInfo";
	}
	
	@RequestMapping(value="hospitalizationUpdate/{hospitalizationNum}", method=RequestMethod.GET)
	public String hospitalizationUpdate(
			@PathVariable("hospitalizationNum") String hospitalizationNum
			, Model model) {
		hospitalizationDetailService.execute(model, hospitalizationNum);
		return "thymeleaf/hospitalization/hospitalizationModify";
	}
	
	@RequestMapping(value="hospitalizationUpdate", method=RequestMethod.POST)
	public String hospitalizationUpdate(
			HospitalizationCommand hospitalizationCommand) {
		hospitalizationUpdateService.execute(hospitalizationCommand);
		return "redirect:hospitalizationList";
	}
	
	@GetMapping("hospitalizationDelete/{hospitalizationNum}")
	public String hospitalizationDelete(@PathVariable("hospitalizationNum") String hospitalizationNum) {
		hospitalizationDeleteService.execute(hospitalizationNum);
		return "redirect:../hospitalizationList";
	}
	

}
