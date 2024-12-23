package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hospital.command.SurgeryAppointmentCommand;
import hospital.command.SurgeryCommand;
import hospital.service.AutoNumService;
import hospital.service.surgery.OperatingRoomListService;
import hospital.service.surgery.SurApsDeleteService;
import hospital.service.surgery.SurgeryAppointmentDeleteService;
import hospital.service.surgery.SurgeryAppointmentDetailService;
import hospital.service.surgery.SurgeryAppointmentListService;
import hospital.service.surgery.SurgeryAppointmentService;
import hospital.service.surgery.SurgeryAppointmentUpdateService;
import hospital.service.surgery.SurgeryDetailService;
import hospital.service.surgery.SurgeryListService;
import hospital.service.surgery.SurgeryUpdateService;
import hospital.service.surgery.SurgeryWriteService;

@Controller
@RequestMapping("surgery")
public class SurgeryController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	SurgeryAppointmentService surgeryAppointmentService;
	@Autowired
	SurgeryAppointmentListService surgeryAppointmentListService;
	@Autowired
	SurgeryAppointmentDetailService surgeryAppointmentDetailService;
	@Autowired
	SurgeryAppointmentUpdateService surgeryAppointmentUpdateService;
	@Autowired
	SurgeryAppointmentDeleteService surgeryAppointmentDeleteService;
	@Autowired
	SurgeryWriteService surgeryWriteService;
	@Autowired
	SurgeryListService surgeryListService;
	@Autowired
	OperatingRoomListService operatingRoomListService;
	@Autowired
	SurgeryDetailService surgeryDetailService;
	@Autowired
	SurgeryUpdateService surgeryUpdateService;
	@Autowired
	SurApsDeleteService surApsDeleteService;
	
	
	// 수술 예약
	@GetMapping("surgeryAppointmentList") // 수술예약 리스트
	public String surgeryAppointmentList(
			@RequestParam(value="page", required = false, defaultValue = "1") int page,
			@RequestParam(value="searchWord", required = false) String searchWord,
			Model model) {
		surgeryAppointmentListService.execute(page, searchWord, model);
		return "thymeleaf/surgery/surgeryAppointmentList";
	}
	@PostMapping("surApsDelete") // 리스트에서 수술예약 선택 삭제
	public String surApsDelete(
			@RequestParam(value="nums") String surApsDel []) {
		surApsDeleteService.execute(surApsDel);
		return "redirect:surgeryAppointmentList";
	}
	@GetMapping("surgeryAppointment") // 수술예약 화면
	public String surgeryAppointment(Model model) {
		String autoNum = autoNumService.execute("SurgeryAp_", 11, "SURGERY_APPOINTMENT_NUM", "surgery_appointment");
		model.addAttribute("autoNum", autoNum);
		return "thymeleaf/surgery/surgeryAppointment";
	}
	@PostMapping("surgeryAppointment") // 수술예약
	public String surgeryAppointment(SurgeryAppointmentCommand surgeryAppintmentCommand) {
		surgeryAppointmentService.execute(surgeryAppintmentCommand);
		return "redirect:surgeryAppointmentList";
	}
	@GetMapping("surgeryAppointmentDetail") // 수술예약 상세
	public String surgeryAppointmentDetail(String surgeryAppointmentNum, Model model) {
		surgeryAppointmentDetailService.execute(surgeryAppointmentNum, model);
		return "thymeleaf/surgery/surgeryAppointmentDetail";
	}
	@GetMapping("surgeryAppointmentModify") // 수술예약 수정화면
	public String surgeryAppointmentModify(String surgeryAppointmentNum, Model model) {
		surgeryAppointmentDetailService.execute(surgeryAppointmentNum, model);
		return "thymeleaf/surgery/surgeryAppointmentModify";
	}
	@PostMapping("surgeryAppointmentModify") // 수술예약 수정
	public String surgeryAppointmentModify(SurgeryAppointmentCommand surgeryAppointmentCommand) {
		surgeryAppointmentUpdateService.execute(surgeryAppointmentCommand);
		return "redirect:surgeryAppointmentDetail?surgeryAppointmentNum="+surgeryAppointmentCommand.getSurgeryAppointmentNum();
	}
	@GetMapping("surgeryAppointmentDelete") // 수술예약 삭제
	public String surgeryAppointmentDelete(String surgeryAppointmentNum) {
		surgeryAppointmentDeleteService.execute(surgeryAppointmentNum);
		return "redirect:surgeryAppointmentList";
	}
	
	
	// 수술결과 기록
	@GetMapping("surgeryList") // 수술기록 리스트
	public String surgeryList(Model model) {
		surgeryListService.execute(model);
		return "thymeleaf/surgery/surgeryList";
	}
	@GetMapping("surgeryWrite") // 수술기록 화면
	public String surgeryWrite(String surgeryAppointmentNum, Model model) {
		String autoNum = autoNumService.execute("Surgery_", 9, "SURGERY_NUM", "surgery");
		model.addAttribute("autoNum", autoNum);
		if(surgeryAppointmentNum != null) {
			model.addAttribute("surgeryAppointmentNum", surgeryAppointmentNum);
		}
		return "thymeleaf/surgery/surgeryWrite";
	}
	@PostMapping("surgeryWrite") // 수술 기록하기
	public String surgeryWrite(SurgeryCommand surgeryCommand) {
		surgeryWriteService.execute(surgeryCommand);
		return "redirect:surgeryList";
	}
	@GetMapping("surgeryDetail") // 수술 상세보기
	public String surgeryDetail(String surgeryNum, Model model) {
		surgeryDetailService.execute(surgeryNum, model);
		return "thymeleaf/surgery/surgeryDetail";
	}
	@GetMapping("surgeryModify")  // 수술내용 수정화면
	public String surgeryModify(String surgeryNum, Model model) {
		surgeryDetailService.execute(surgeryNum, model);
		return "thymeleaf/surgery/surgeryModify";
	}
	@PostMapping("surgeryUpdate")
	public String surgeryUpdate(SurgeryCommand surgeryCommand) {
		surgeryUpdateService.execute(surgeryCommand);
		return "redirect:surgeryDetail?surgeryNum="+surgeryCommand.getSurgeryNum();
	}
	
	// 수술실 찾기
	@GetMapping("operatingRoomList")
	public String operatingRoomList(Model model) {
		operatingRoomListService.execute(model);
		return "thymeleaf/surgery/operatingRoomList";
	}
	//수술예약 찾기
	@GetMapping("surApList")
	public String surApList(
			@RequestParam(value="page", required= false, defaultValue = "1") int page, 
			@RequestParam(value="searchWord", required= false) String searchWord, 
			Model model) {
		surgeryAppointmentListService.execute(page, searchWord, model);
		return "thymeleaf/surgery/surApList";
	}
}
