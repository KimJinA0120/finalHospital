package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hospital.command.ReceiptCommand;
import hospital.domain.AuthInfoDTO;
import hospital.mapper.LoginMapper;
import hospital.mapper.PatientMapper;
import hospital.service.AutoNumService;
import hospital.service.employee.EmployeeListService;
import hospital.service.patient.PatientListService;
import hospital.service.receipt.PatientReservationService;
import hospital.service.receipt.ReceiptInsertService;
import hospital.service.receipt.ReceiptListService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("receipt")
public class ReceiptController {
	@Autowired
	ReceiptListService receiptListService;
	@Autowired
	ReceiptInsertService receiptInsertService;
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	PatientListService patientListService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PatientMapper patientMapper;
	@Autowired
	PatientReservationService patientReservationService;
	
	@GetMapping("receiptList")
	public String receiptList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			, @RequestParam(value = "searchWord", required = false) String searchWord
			,Model model) {
		receiptListService.execute(page, searchWord, model);
		return "thymeleaf/receipt/receiptList";
	}
	
	@GetMapping("receiptForm")
	public String receiptForm(Model model) {
		String autoNum = autoNumService.execute("r_", 3, "receipt_num", "receipt");
		model.addAttribute("autoNum", autoNum);
		return "thymeleaf/receipt/receiptForm";
	}
	
	@PostMapping("receiptInsert")
	public String receiptInsert(ReceiptCommand receiptCommand) {
		receiptInsertService.execute(receiptCommand);
		return "redirect:receiptList";
	}
	
	@GetMapping("patientSearch")
	public String patientSearch(@RequestParam(value="searchWord", required=false) String searchWord
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		patientListService.patientSearch(page, searchWord, model);
		return "thymeleaf/patient/patientSearch";
	}
	
	@GetMapping("doctorSearch")
	public String doctorSearch(@RequestParam(value="searchWord", required=false) String searchWord
			, @RequestParam(value="page", required=false, defaultValue="1") Integer page
			, Model model) {
		employeeListService.doctorSearch(searchWord, page, model, null);
		return "thymeleaf/employee/doctorSearch";
	}
	
	@GetMapping("emp_reservationForm")
	public String emp_reservationForm(Model model) {
		String autoNum = autoNumService.execute("r_", 3, "receipt_num", "receipt");
		model.addAttribute("autoNum", autoNum);
		return "thymeleaf/receipt/emp_reservationForm";
	}
	
	@PostMapping("emp_reservationInsert")
	public String emp_reservationInsert(ReceiptCommand receiptCommand) {
		receiptInsertService.execute1(receiptCommand);
		return "redirect:receiptList";
	}
	
	@GetMapping("reservationForm")
	public String reservationForm(Model model, HttpSession session) {
		String autoNum = autoNumService.execute("r_", 3, "receipt_num", "receipt");
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String patientNum = patientMapper.patientNumSelect(auth.getUserId());
		model.addAttribute("autoNum", autoNum);
		model.addAttribute("patientNum", patientNum);
		return "thymeleaf/receipt/reservationForm";
	}
	
	@PostMapping("reservationInsert")
	public String reservationInsert(ReceiptCommand receiptCommand) {
		receiptInsertService.execute1(receiptCommand);
		return "redirect:/";
	}
	
	@GetMapping("patientReservation")
	public String patientReservation(HttpSession session, Model model) { 
		patientReservationService.execute(session, model);
		return "thymeleaf/receipt/patientReservation";
	}
	
}
