package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.SurgeryAppointmentCommand;
import hospital.service.AutoNumService;
import hospital.service.surgery.SurgeryAppointmentDeleteService;
import hospital.service.surgery.SurgeryAppointmentDetailService;
import hospital.service.surgery.SurgeryAppointmentListService;
import hospital.service.surgery.SurgeryAppointmentService;
import hospital.service.surgery.SurgeryAppointmentUpdateService;

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
	
	@GetMapping("surgeryAppointmentList") // 수술예약 리스트
	public String surgeryAppointmentList(Model model) {
		surgeryAppointmentListService.execute(model);
		return "thymeleaf/surgery/surgeryAppointmentList";
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
	@GetMapping("surgeryAppointmentDelete")
	public String surgeryAppointmentDelete(String surgeryAppointmentNum) {
		surgeryAppointmentDeleteService.execute(surgeryAppointmentNum);
		return "redirect:surgeryAppointmentList";
	}
}
