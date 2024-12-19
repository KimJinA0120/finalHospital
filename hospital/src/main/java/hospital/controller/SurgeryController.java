package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.SurgeryAppointmentCommand;
import hospital.service.surgery.SurgeryAppointmentListService;
import hospital.service.surgery.SurgeryAppointmentService;

@Controller
@RequestMapping("surgery")
public class SurgeryController {
	@Autowired
	SurgeryAppointmentService surgeryAppointmentService;
	@Autowired
	SurgeryAppointmentListService surgeryAppointmentListService;
	
	@GetMapping("surgeryAppointmentList")
	public String surgeryAppointmentList(Model model) {
		surgeryAppointmentListService.execute(model);
		return "thymeleaf/surgery/surgeryAppointmentList";
	}
	@GetMapping("surgeryAppointment")
	public String surgeryAppointment() {
		return "thymeleaf/surgery/surgeryAppointment";
	}
	@PostMapping("surgeryAppointment")
	public String surgeryAppointment(SurgeryAppointmentCommand surgeryAppintmentCommand) {
		surgeryAppointmentService.execute(surgeryAppintmentCommand);
		return "redirect:surgeryAppointmentList";
	}
}
