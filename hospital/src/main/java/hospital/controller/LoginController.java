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
import hospital.mapper.CheckMapper;
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
			 return "thymeleaf/patientLogin"; 
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
			 return "thymeleaf/employeeLogin";
		}else {
				return "redirect:/";
		}
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	@Autowired 
	CheckMapper checkMapper;
	  
	@PostMapping("userIdCheck") 
	public @ResponseBody Integer userIdCheck(String userId) { // html, jsp파일경로(x) return
		return checkMapper.checkId(userId);
	}
	  
	@PostMapping("userEmailCheck") 
	public @ResponseBody Integer userEmailCheck(String userEmail) { 
		return checkMapper.checkEmail(userEmail); 
	}
	@PostMapping("patientJuminCheck")
	public @ResponseBody Integer patientJuminCheck(String patientJuminF, String patientJuminB) {
		String patientJumin=patientJuminF+patientJuminB;
		return checkMapper.patientJuminCon(patientJumin);
	}
	@PostMapping("employeeJuminCheck")
	public @ResponseBody Integer employeeJuminCheck(String empJuminF, String empJuminB) {
		String empJumin=empJuminF+empJuminB;
		return checkMapper.employeeJuminCon(empJumin);
	}
	  
	  
/*	  @GetMapping("item.login")
		public String item() {
			return "thymeleaf/login";
		}
		@PostMapping("item.login")
		public void item(LoginCommand loginCommand, BindingResult result	
				, HttpSession session, HttpServletResponse response) {
			loginService.patientLogin(loginCommand, session, result);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String str = "<script language='javascript'>";
			   str += "opener.location.reload();";
			   str += "window.self.close();";
			   str += "</script>";
			   out.print(str);
			   out.close();
			
		}*/

}
