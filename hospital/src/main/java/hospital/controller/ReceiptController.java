package hospital.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hospital.command.ReceiptCommand;
import hospital.service.AutoNumService;
import hospital.service.receipt.PatientsService;
import hospital.service.receipt.ReceiptInsertService;
import hospital.service.receipt.ReceiptListService;


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
	PatientsService patientsService;
	
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
	
	@GetMapping("patients")
	public String patients() {
		
		return "thymeleaf/receipt/patients";
	}
	@PostMapping("patientsList")
	public @ResponseBody Map<String, Object> patientsList(
			@RequestParam(value = "page" , required = false , defaultValue = "1") int page
			,@RequestParam(value = "searchWord", required = false) String searchWord) {
		Map<String, Object> map = patientsService.execute(page, searchWord);
		return map;
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
	public String reservationForm(Model model) {
		String autoNum = autoNumService.execute("r_", 3, "receipt_num", "receipt");
		model.addAttribute("autoNum", autoNum);
		return "thymeleaf/receipt/reservationForm";
	}
	
	@PostMapping("reservationInsert")
	public String reservationInsert(ReceiptCommand receiptCommand) {
		receiptInsertService.execute1(receiptCommand);
		return "redirect:/";
	}
	
}
