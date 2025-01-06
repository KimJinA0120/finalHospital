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

import hospital.command.PatientCommand;
import hospital.service.AutoNumService;
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
	
	@GetMapping("patientWriteCon")
	public String patientWriteCon() {
		return "thymeleaf/patient/patientWriteCon";
	}

	@GetMapping("patientWrite")
	public String patientWrite(PatientCommand patientCommand, Model model) {
		String autoNum = autoNumService.execute("pat_", 5, "patient_num","patient");
		patientCommand.setPatientNum(autoNum);
		model.addAttribute("patientCommand", patientCommand);
		return "thymeleaf/patient/patientWrite";
	}
	
	@PostMapping("patientWrite")
	public String patientWrite( @Validated 
			PatientCommand patientCommand
			, BindingResult result 
			) {
		if(result.hasErrors()) { return "thymeleaf/patient/patientWrite"; }
		patientWriteService.execute(patientCommand);
		return "redirect:/";
	}
	@GetMapping("patientRegist")
	public String patientRegist(String patientNum, PatientCommand patientCommand, Model model) {
		
		return "thymeleaf/patient/patientWrite";
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
		patientDetailService.execute(session, null, model);
		return "thymeleaf/patient/patientMy";
	}

	@GetMapping("patientDetail")
	public String patientDetail(HttpSession session, String patientNum, Model model) {
		patientDetailService.execute(session, patientNum, model);
		return "thymeleaf/patient/patientDetail";
	}

	@GetMapping("patientUpdate")
	public String patientUpdate(HttpSession session, Model model) {
		patientDetailService.execute(session, null, model);
		return "thymeleaf/patient/patientUpdate";
	}

	@PostMapping("patientUpdate")
	public String patientUpdate(HttpSession session
			, PatientCommand patientCommand
			, BindingResult result, Model model) {
		if(patientCommand.getPatientPhone().length()<9 || patientCommand.getPatientPhone().length()>11) {
			  result.rejectValue("patientPhone", "patientCommand.patientPhone", "'-' 제외 숫자 9~11자");
		}else {
			patientUpdateService.execute(session, patientCommand);
		}
		
		if(result.hasErrors()) {
			return "thymeleaf/patient/patientUpdate";
		}else
		return "redirect:patientDetail?patientNum=" + patientCommand.getPatientNum();
	}
	
	@GetMapping("patPwCon")
	public String patPwCon(){ //비밀번호 수정을 누르면 비밀번호 확인 페이지로 이동한다.
		return "thymeleaf/patient/pwCon";
	}
	@PostMapping("patPwCon")
	public String patPwCon(HttpSession session, PatientCommand patientCommand) { //비밀번호를 확인한다.
		int i=patientUpdateService.patientPwCon(session, patientCommand);
		
		if(i==1) {
			return "redirect:patPwUpdate";
		}else return "redirect:patPwCon";
		
	}
	@GetMapping("patPwUpdate")
	public String patPwUpadate() { //비밀번호 확인이 정상적으로 되면 비밀번호 업데이트 화면으로 이동한다.
		return "thymeleaf/patient/pwUpdate";
	}
	@PostMapping("patPwUpdate")
	public String patPwUpdate(HttpSession session, PatientCommand patientCommand) { //비밀번호를 수정한다.
		patientUpdateService.patientPwUpdate(session, patientCommand);
		return "redirect:patientMyPage";
	}

	@GetMapping("patientDelete")
	public String patientDelete(HttpSession session) {
		patientDeleteService.execute(session);
		session.invalidate();
		return "redirect:/";
	}
}
