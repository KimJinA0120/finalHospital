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

	
	@GetMapping("patientLogin")
	public String patientlogin( 
			LoginCommand loginCommand, 
			Model model
			) {
		model.addAttribute("loginCommand", loginCommand);
		return "thymeleaf/patientLogin";
	}
	@PostMapping("patientLogin")
	public String patientLogin(@Validated LoginCommand loginCommand,
			BindingResult result, HttpSession session) {
		loginService.patientLogin(loginCommand, session, result);
		if(result.hasErrors()) { 
			 return "thymeleaf/login"; 
		}else {
			return "redirect:/";
			
		}
	}
	@GetMapping("employeeLogin")
	public String employeeLogin( 
			LoginCommand loginCommand, 
			Model model
			) {
		model.addAttribute("loginCommand", loginCommand);
		return "thymeleaf/employeeLogin";
	}
	@PostMapping("employeeLogin")
	public String employeeLogin(@Validated LoginCommand loginCommand
			,BindingResult result, HttpSession session
			) { 
		loginService.employeeLogin(loginCommand, session, result);
		if(result.hasErrors()) { 
			 return "thymeleaf/login";
		}else {
				return "redirect:/empIndex";
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
