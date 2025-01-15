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
import hospital.command.PatientCommand;
import hospital.domain.AuthInfoDTO;
import hospital.mapper.EmployeeMapper;
import hospital.service.AutoNumService;
import hospital.service.employee.EmployeeDeleteService;
import hospital.service.employee.EmployeeDetailService;
import hospital.service.employee.EmployeeListService;
import hospital.service.employee.EmployeeUpdateService;
import hospital.service.employee.EmployeeWriteService;
import hospital.service.employee.SectionListService;
import hospital.service.patient.PatientWriteService;
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
	
	// 직업(의사, 간호사, 의료기사, 일반직원)에 따라 직원번호 앞글자(sep)가 변경
	@PostMapping("selectEmpSep")
	public @ResponseBody String selectEmpSep(String jobSep) {
		String autoNum = autoNumService.execute(jobSep, 5, "emp_num","employee");
		return autoNum;
	}

	@GetMapping("employeeWrite")
	public String employeeWrite(EmployeeCommand employeeCommand, Model model) {
		model.addAttribute("employeeCommand", employeeCommand);
		return "thymeleaf/employee/employeeWrite";
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
	
	@Autowired
	PatientWriteService patientWriteService;
	
	@GetMapping("patientRegist") //직원이 환자등록하는 링크
	public String patientRegsit(PatientCommand patientCommand, Model model) {
		String autoNum = autoNumService.execute("pat_", 5, "patient_num","patient");
		patientCommand.setPatientNum(autoNum);
		model.addAttribute("patientCommand", patientCommand);
		return "thymeleaf/employee/patientRegist";
	}
	@PostMapping("patientRegist") //직원이 환자등록하는 링크
	public String patientRegist(@Validated PatientCommand patientCommand, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "thymeleaf/employee/patientRegist";
		}
		patientWriteService.execute(patientCommand);
		return "redirect:/";
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
			, @RequestParam(value="kind",required=false) String kind){
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
	
	
	@GetMapping("employeeList") //직원목록
	public String employeeList(@RequestParam(value="searchWord", required=false) String searchWord
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		employeeListService.execute(searchWord, page, model);
		return "thymeleaf/employee/employeeList";
	}
	@GetMapping("employeeMyPage") //직원마이페이지
	public String employeeMypage(HttpSession session, Model model) {
		employeeDetailService.execute(session, model);
		return "thymeleaf/employee/employeeMy";
	}
	@Autowired
	EmployeeMapper employeeMapper;

	@GetMapping("employeeDetail") //본인과 원무행정과 직원만 접근 가능
	public String employeeDetail(HttpSession session, String empNum, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String empId=auth.getUserId();
		String empNum2=employeeMapper.employeeNumSelect(empId);
		employeeDetailService.execute(session, model);
		if(empNum.equals(empNum2)||empNum2.substring(0, 3).equals("emp")) {
			return "thymeleaf/employee/employeeDetail";
		}else
		return "redirect:employeeList";
	}

	@GetMapping("employeeUpdate")
	public String employeeUpdate(HttpSession session, Model model) {
		employeeDetailService.execute(session, model);
		return "thymeleaf/employee/employeeUpdate";
	}

	@PostMapping("employeeUpdate")
	public String employeeUpdate(HttpSession session
			, EmployeeCommand employeeCommand
			, BindingResult result, Model model) {
		if(employeeCommand.getEmpPhone().length()<9 || employeeCommand.getEmpPhone().length()>11) {
			  result.rejectValue("empPhone", "employeeCommand.empPhone", "'-' 제외 숫자 9~11자");
		}else employeeUpdateService.execute(session, employeeCommand);
		
		if(result.hasErrors()) { return "thymeleaf/employee/employeeUpdate"; }
		return "redirect:employeeDetail?empNum="+ employeeCommand.getEmpNum();
	}

	@GetMapping("employeeDelete")
	public String employeeDelete(HttpSession session) {
		employeeDeleteService.execute(session);
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("employeesDelete") //원무행정과 직원이 접근하는 기능
	public String employeesDelete(String empNum) {
		employeeDeleteService.execute2(empNum);
		return "redirect:employeeList";
	}
	@GetMapping("doctorList")
	public String doctorList(@RequestParam(value="searchWord", required=false) String searchWord
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		employeeListService.doctorSearch(searchWord, page, model, null);
		return "thymeleaf/employee/doctorList";
	}
	
	@GetMapping("doctorUpdate")
	public String doctorUpdate(@RequestParam(value="empNum") String empNum, Model model) {
		employeeDetailService.doctorDetail(empNum, model);
		return "thymeleaf/employee/doctorUpdate";
	}
	@PostMapping("doctorUpdate")
	public String doctorUpdate(DoctorCommand doctorCommand) {
		employeeUpdateService.doctorUpdate(doctorCommand);
		return "redirect:doctorList";
	}
	
	@GetMapping("empPwCon")
	public String empPwCon(EmployeeCommand employeeCommand){ //비밀번호 수정을 누르면 비밀번호 확인 페이지로 이동한다.
		return "thymeleaf/employee/pwCon";
	}
	@PostMapping("empPwCon")
	public String empPwCon(HttpSession session, EmployeeCommand employeeCommand, BindingResult result) { //비밀번호를 확인한다.
		employeeUpdateService.employeePwCon(session, employeeCommand, result);
		if(result.hasErrors()) {
			return "thymeleaf/employee/pwCon";
		}
		return "redirect:empPwUpdate";
	}
	@GetMapping("empPwUpdate")
	public String empPwUpdate(EmployeeCommand employeeCommand) { //비밀번호 확인이 정상적으로 되면 비밀번호 업데이트 화면으로 이동한다.
		return "thymeleaf/employee/pwUpdate";
	}
	@PostMapping("empPwUpdate")
	public String empPwUpdate(HttpSession session, @Validated EmployeeCommand employeeCommand
			, BindingResult result) { //비밀번호를 수정한다.
		if(result.hasErrors()) {
			return "thymeleaf/employee/pwUpdate";
		}else {
			employeeUpdateService.employeePwUpdate(session, employeeCommand);
		}
		return "redirect:employeeMyPage";
	}
	
	
}
