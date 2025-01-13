package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.service.find.FindIdService;
import hospital.service.find.FindPatientNumService;
import hospital.service.find.FindPwService;


@Controller
@RequestMapping("find")
public class FindController {
	@Autowired
	FindIdService findIdService;
	@Autowired
	FindPwService findPwService;
	@Autowired
	FindPatientNumService findPatientNumService;
	
	@GetMapping("findId") //환자 ID 찾기
	public String findPatientId() {
		return "thymeleaf/find/findId";
	}
	@PostMapping("findId") 
	public String findPatientId(String userName, String userPhone, String userEmail,Model model) {
		findIdService.findPatientId(userName,userPhone,userEmail,model);
		return "thymeleaf/find/findIdOk";
	}
	
	@GetMapping("findPw") //환자 비밀번호 찾기
	public String findPatientPw() {
		return "thymeleaf/find/findPw";
	}
	@PostMapping("findPw")
	public String findPatientPw(String userName, String userId, String userPhone, Model model) {
		findPwService.findPatientPw(userName, userId, userPhone, model);
		return "thymeleaf/find/findPwOk";
	}
	@GetMapping("findEmpId")
	public String findEmpId() {
		
		return "thymeleaf/find/findEmpId";
	}
	@PostMapping("findEmpId")
	public String findEmpId(String userName, String userPhone, String userEmail, Model model) {
		findIdService.findEmpId(userName,userPhone,userEmail, model);
		return "thymeleaf/find/findEmpIdOk";
	}
	@GetMapping("findEmpPw")
	public String findEmpPw() {
		return "thymeleaf/find/findEmpPw";
	}
	@PostMapping("findEmpPw")
	public String findEmpPw(String userName, String userId, String userPhone, Model model) {
		findPwService.findEmpPw(userName, userId, userPhone, model);
		return "thymeleaf/find/findEmpPwOk";
	}
	
	@GetMapping("findPatientNum")
	public String findPatientNum() {
		return "thymeleaf/find/findPatientNum";
	}
	@PostMapping("findPatientNum")
	public String findPatientNum(String patientName, String patientJuminF, String patientJuminB, Model model) {
		String patientJumin=patientJuminF+patientJuminB;
		findPatientNumService.execute(patientName, patientJumin, model);
		return "thymeleaf/find/findPatientNumOK";
	}
}
