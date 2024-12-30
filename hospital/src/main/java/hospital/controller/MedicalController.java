package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hospital.command.MedicalCommand;
import hospital.service.AutoNumService;
import hospital.service.medical.MedicalInfoService;
import hospital.service.medical.MedicalInsertService;
import hospital.service.medical.MedicalListService;
import hospital.service.medical.MedicalUpdateService;


@Controller
@RequestMapping("medical")
public class MedicalController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	MedicalInsertService medicalInsertService;
	@Autowired
	MedicalListService medicalListService;
	@Autowired
	MedicalInfoService medicalInfoService;
	@Autowired
	MedicalUpdateService medicalUpdateService;
	
	@GetMapping("medicalForm")
	public String medicalForm(Model model) {
		String autoNum = autoNumService.execute("m_", 3, "medical_num", "medical");
		model.addAttribute("autoNum", autoNum);
		return "thymeleaf/medical/medicalForm";
	}
	@PostMapping("medicalInsert")
	public String medicalInsert(MedicalCommand medicalCommand) {
		medicalInsertService.execute(medicalCommand);
		return "redirect:medicalList";
	}
	
	@GetMapping("medicalList") 
	public String medicalList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			, @RequestParam(value = "searchWord", required = false) String searchWord
			,Model model) {
		medicalListService.execute(page, searchWord, model);
		return "thymeleaf/medical/medicalList";
	}
	
	@GetMapping("medicalInfo")
	public String medicalInfo(@RequestParam("medicalNum") String medicalNum, Model model) {
		medicalInfoService.execute(medicalNum, model);
		return "thymeleaf/medical/medicalInfo";
	}
	
	@GetMapping("medicalUpdate")
	public String medicalUpdate(@RequestParam("medicalNum") String medicalNum, Model model) {
		medicalInfoService.execute(medicalNum, model);
		return "thymeleaf/medical/medicalUpdate";
	}
	
	@PostMapping("medicalUpdate") 
	public String medicalUpdate(MedicalCommand medicalCommand) {
		medicalUpdateService.execute(medicalCommand);
		return "redirect:medicalInfo?medicalNum=" + medicalCommand.getMedicalNum();
	}
	
}
