package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hospital.command.PatientCommand;
import hospital.service.AutoNumService;
import hospital.service.CheckService;
import hospital.service.patient.PatientDeleteService;
import hospital.service.patient.PatientDetailService;
import hospital.service.patient.PatientListService;
import hospital.service.patient.PatientUpdateService;
import hospital.service.patient.PatientWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("patient")
public class PatientController {
	@Autowired
	PatientWriteService patientWriteService;
	@Autowired
	PatientListService patientListService;
	@Autowired
	PatientDetailService patientDetailService;
	@Autowired
	PatientUpdateService patientUpdateService;
	@Autowired
	PatientDeleteService patientDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("patientWrite")
	public String patientWrite(PatientCommand patientCommand, Model model) {
		String autoNum = autoNumService.execute("pat_", 5, "patient_num","patient");
		patientCommand.setPatientNum(autoNum);
		model.addAttribute("patientCommand", patientCommand);
		return "thymeleaf/patient/patientWrite";
	}
	
	@PostMapping("patientWrite")
	public String patientWrite( //@Validated 
			PatientCommand patientCommand
			, BindingResult result 
			) {
		//if(result.hasErrors()) { return "thymeleaf/patient/patientWrite"; }
		patientWriteService.execute(patientCommand);
		return "redirect:/";
	}
	@GetMapping("patientList")
	public String patientList(@RequestParam(value="searchWord", required=false) String searchWord
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		patientListService.execute(page, searchWord, model);
		return "thymeleaf/patient/patientList";
	}
	@GetMapping("patientSearch")
	public String patientSearch(@RequestParam(value="searchWord", required=false) String searchWord
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		patientListService.patientSearch(page, searchWord, model);
		return "thymeleaf/patient/patientSearch";
	}
	@GetMapping("patientMyPage")
	public String patientMypage(HttpSession session, Model model) {
		patientDetailService.execute(session, model);
		return "thymeleaf/patient/patientMy";
	}

	@GetMapping("patientDetail")
	public String patientDetail(HttpSession session, Model model) {
		patientDetailService.execute(session, model);
		return "thymeleaf/patient/patientDetail";
	}

	@GetMapping("patientUpdate")
	public String patientUpdate(HttpSession session, Model model) {
		patientDetailService.execute(session, model);
		return "thymeleaf/patient/patientUpdate";
	}

	@PostMapping("patientUpdate")
	public String patientUpdate(HttpSession session, PatientCommand patientCommand) {
		patientUpdateService.execute(session, patientCommand);
		return "redirect:patientDetail?patientNum=" + patientCommand.getPatientNum();
	}

	@GetMapping("patientDelete")
	public String patientDelete(HttpSession session) {
		patientDeleteService.execute(session);
		session.invalidate();
		return "redirect:/";
	}
}
