package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.EmployeeCommand;
import hospital.service.AutoNumService;
import hospital.service.employee.EmployeeDeleteService;
import hospital.service.employee.EmployeeDetailService;
import hospital.service.employee.EmployeeListService;
import hospital.service.employee.EmployeeUpdateService;
import hospital.service.employee.EmployeeWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	EmployeeWriteService employeeWriteService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeDetailService employeeDetailService;
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("employeeWrite")
	public String employeeWrite(EmployeeCommand employeeCommand, Model model) {
		String autoNum = autoNumService.execute("emp_", 5, "emp_num","employee");
		employeeCommand.setEmpNum(autoNum);
		model.addAttribute("employeeCommand", employeeCommand);
		return "thymeleaf/employee/employeeWrite";
	}
	
	/*
	 * @Autowired IdcheckService idcheckService; // spring 방식
	 * 
	 * @PostMapping("employeeIdCheck") public @ResponseBody Integer
	 * employeeIdCheck(String employeeId) { // html, jsp파일경로(x) return
	 * idcheckService.execute(employeeId);
	 * 
	 * }
	 * 
	 * @Autowired EmailCheckService emailCheckService;
	 * 
	 * @PostMapping("employeeEmailCheck") public @ResponseBody Integer
	 * employeeEmailCheck(String employeeEmail) { return
	 * emailCheckService.execute(employeeEmail); }
	 */

	@PostMapping("employeeWrite")
	public String employeeWrite( //@Validated 
			EmployeeCommand employeeCommand
			, BindingResult result 
			) {
		//if(result.hasErrors()) { return "thymeleaf/employee/employeeWrite"; }
		employeeWriteService.execute(employeeCommand);
		return "redirect:/";
	}
	@GetMapping("employeeList")
	public String employeeList(Model model) {
		employeeListService.execute(model);
		return "thymeleaf/employee/employeeList";
	}
	@GetMapping("employeeMyPage")
	public String employeeMypage(HttpSession session, Model model) {
		employeeDetailService.execute(session, model);
		return "thymeleaf/employee/employeeMy";
	}

	@GetMapping("employeeDetail")
	public String employeeDetail(HttpSession session, Model model) {
		employeeDetailService.execute(session, model);
		return "thymeleaf/employee/employeeDetail";
	}

	@GetMapping("employeeUpdate")
	public String employeeUpdate(HttpSession session, Model model) {
		employeeDetailService.execute(session, model);
		return "thymeleaf/employee/employeeUpdate";
	}

	@PostMapping("employeeUpdate")
	public String employeeUpdate(HttpSession session, EmployeeCommand employeeCommand) {
		employeeUpdateService.execute(session, employeeCommand);
		return "redirect:employeeDetail?employeeNum=" + employeeCommand.getEmpNum();
	}

	@GetMapping("employeeDelete")
	public String employeeDelete(HttpSession session) {
		employeeDeleteService.execute(session);
		session.invalidate();
		return "redirect:/";
	}
}
