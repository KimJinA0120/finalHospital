package hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hospital.command.FindCommand;


@Controller
@RequestMapping("find")
public class FindController {
	
	@GetMapping("findPatientId") //환자 ID 찾기
	public String findPatientId() {
		return "thymeleaf/find/findId";
	}
	@PostMapping("findPatientId") 
	public String findPatientId(FindCommand findCommand) {
		return "thymeleaf/find/findIdOk";
	}
	@GetMapping("findPatientPw") //환자 비밀번호 찾기
	public String findPatientPw() {
		return "thymeleaf/find/findPw";
	}
	@PostMapping("findPatientPw")
	public String findPatientPW(FindCommand findCommand) {
		return "thymeleaf/find/findPwOk";
	}
	@GetMapping("findEmpId")
	public String findEmpId() {
		return "thymeleaf/find/findId";
	}
	@PostMapping("findEmpId")
	public String findEmpId(FindCommand findCommand) {
		return "thymeleaf/find/findIdOk";
	}
	@GetMapping("findEmpPw")
	public String findEmpPw() {
		return "thymeleaf/find/findPw";
	}
	@PostMapping("findEmpPw")
	public String findEmpPw(FindCommand findCommand) {
		return "thymeleaf/find/findPwOk";
	}
	
}
