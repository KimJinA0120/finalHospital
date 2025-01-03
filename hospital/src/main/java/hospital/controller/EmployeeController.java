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
import org.springframework.web.bind.annotation.ResponseBody;

import hospital.command.DoctorCommand;
import hospital.command.EmployeeCommand;
import hospital.service.AutoNumService;
import hospital.service.employee.EmployeeDeleteService;
import hospital.service.employee.EmployeeDetailService;
import hospital.service.employee.EmployeeListService;
import hospital.service.employee.EmployeeUpdateService;
import hospital.service.employee.EmployeeWriteService;
import hospital.service.employee.SectionListService;
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
	@Autowired
	SectionListService sectionListService;

	@GetMapping("employeeWrite")
	public String employeeWrite(EmployeeCommand employeeCommand, Model model) {
		model.addAttribute("employeeCommand", employeeCommand);
		return "thymeleaf/employee/employeeWrite";
	}
	
	// 직업(의사, 간호사, 의료기사, 일반직원)에 따라 직원번호 앞글자(sep)가 변경
	@PostMapping("selectEmpSep")
	public @ResponseBody String selectEmpSep(String jobSep) {
		String autoNum = autoNumService.execute(jobSep, 5, "emp_num","employee");
		return autoNum;
	}
	
	@GetMapping("sectionSearch")
	public String sectionSearch(
			@RequestParam(value="searchWord", required=false) String searchWord
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model
			, @RequestParam(value="kind",required=false) String kind) {
		sectionListService.execute(searchWord, page, model, kind);
		return "thymeleaf/employee/sectionSearch";
	}
	@GetMapping("employeeSearch")
	public String employeeSearch(@RequestParam(value="searchWord", required=false) String searchWord
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model
			, @RequestParam(value="kind",required=false)String kind){
		employeeListService.employeeSearch(searchWord, page, model, kind);
		return "thymeleaf/employee/employeeSearch";
	}
	@GetMapping("doctorSearch")
	public String doctorSearch(@RequestParam(value="searchWord", required=false) String searchWord
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model
			, @RequestParam(value="kind", required=false) String kind) {
		employeeListService.doctorSearch(searchWord, page, model, kind);
		return "thymeleaf/employee/doctorSearch";
	}

	@PostMapping("employeeWrite")
	public String employeeWrite(@Validated 
			EmployeeCommand employeeCommand
			, BindingResult result 
			) {
		if(result.hasErrors()) { return "thymeleaf/employee/employeeWrite"; }
		employeeWriteService.execute(employeeCommand);
		if(employeeCommand.getJobCategory().equals("doc_")) {
			employeeWriteService.doctorWrite(employeeCommand);
		}
		return "redirect:/";
	}
	@GetMapping("employeeList")
	public String employeeList(@RequestParam(value="searchWord", required=false) String searchWord
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		employeeListService.execute(searchWord, page, model);
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
	@GetMapping("doctorList")
	public String doctorList(@RequestParam(value="searchWord", required=false) String searchWord
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		employeeListService.doctorSearch(searchWord, page, model, null);
		return "thymeleaf/employee/doctorList";
	}
	
	@GetMapping("doctorUpdate")
	public String doctorUpdate(String empNum, Model model) {
		employeeDetailService.doctorDetail(empNum, model);
		return "thymeleaf/employee/doctorUpdate";
	}
	@PostMapping("doctorUpdate")
	public String doctorUpdate(DoctorCommand doctorCommand) {
		employeeUpdateService.doctorUpdate(doctorCommand);
		return "redirect:employeeList";
	}
	
	@GetMapping("empPwCon")
	public String empPwCon(){ //비밀번호 수정을 누르면 비밀번호 확인 페이지로 이동한다.
		return "thymeleaf/employee/pwCon";
	}
	@PostMapping("empPwCon")
	public String empPwCon(HttpSession session, EmployeeCommand employeeCommand) { //비밀번호를 확인한다.
		int i=employeeUpdateService.employeePwCon(session, employeeCommand);
		if(i==1) {
			return "redirect:empPwUpdate";
		}else return "redirect:empPwCon";
		
	}
	@GetMapping("empPwUpdate")
	public String empPwUpdate() { //비밀번호 확인이 정상적으로 되면 비밀번호 업데이트 화면으로 이동한다.
		return "thymeleaf/employee/pwUpdate";
	}
	@PostMapping("empPwUpdate")
	public String empPwUpdate(HttpSession session, EmployeeCommand employeeCommand) { //비밀번호를 수정한다.
		employeeUpdateService.employeePwUpdate(session, employeeCommand);
		return "redirect:employeeMyPage";
	}
	
}
