package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.ClinicalCommand;
import hospital.service.clinical.ClinicalListService;
import hospital.service.clinical.ClinicalWriteService;

@Controller
@RequestMapping("clinical")
public class ClinicalController {
	@Autowired
	ClinicalWriteService clinicalWriteService;
	@Autowired
	ClinicalListService clinicalListService;
	
	// 임상병리 리스트
	@GetMapping("clinicalList")
	public String clinicalList(Model model) {
		clinicalListService.execute(model);
		return "thymeleaf/clinical/clinicalList";
	}
	// 임상병리 소견서 작성 페이지
	@GetMapping("clinicalWrite")
	public String clinicalWrite() {
		return "thymeleaf/clinical/clinicalWrite";
	}
	// 임상병리 소견서 작성
	@PostMapping("clinicalWrite")
	public String clinicalWrite(ClinicalCommand clinicalCommand) {
		clinicalWriteService.execute(clinicalCommand);
		return "redirect:clinicalList";
	}
}
