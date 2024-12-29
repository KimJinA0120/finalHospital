package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hospital.command.LoginCommand;
import hospital.service.CheckService;
import hospital.service.LoginService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	LoginService loginService;

	
	@GetMapping("")
	public String patientlogin(//@Validated 
			LoginCommand loginCommand, 
			Model model
			) {
		model.addAttribute("loginCommand", loginCommand);
		return "thymeleaf/login";
	}
	@PostMapping("patientLogin")
	public String patientLogin(@Validated LoginCommand loginCommand, HttpSession session,
			BindingResult result) { //@Validated, BindingResult result
		if(result.hasErrors()) { 
			 return "redirect:/login"; 
		}else {
		Integer i=loginService.patientLogin(loginCommand, session, result);
			if(i==1) {
				return "redirect:/";
			}else return "redirect:/login";
		}
	}
	@PostMapping("employeeLogin")
	public String employeeLogin(@Validated LoginCommand loginCommand, HttpSession session,
			BindingResult result) { //@Validated, BindingResult result
		if(result.hasErrors()) { 
			 return "redirect:/login"; 
		}else {
		Integer i=loginService.employeeLogin(loginCommand, session, result);
			if(i==1) {
				return "redirect:/empIndex";
			}else return "redirect:/login";
		}
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	 @Autowired 
	  CheckService checkService; // spring 방식
	  
	  @PostMapping("userIdCheck") 
	  public @ResponseBody Integer userIdCheck(String userId) { // html, jsp파일경로(x) return
		  return checkService.idCheck(userId);
	  }
	  
	  @PostMapping("userEmailCheck") 
	  public @ResponseBody Integer userEmailCheck(String userEmail) { 
		  return checkService.emailCheck(userEmail); 
	  }
}
