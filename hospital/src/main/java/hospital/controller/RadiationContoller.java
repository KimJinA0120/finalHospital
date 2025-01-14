package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.RadiationCommand;
import hospital.service.AutoNumService;
import hospital.service.radiation.RadiationDetailService;
import hospital.service.radiation.RadiationListService;
import hospital.service.radiation.RadiationWriteService;

@Controller
@RequestMapping("radiation")
public class RadiationContoller {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	RadiationWriteService radiationWriteService;
	@Autowired
	RadiationListService radiationListService;
	@Autowired
	RadiationDetailService radiationDetailService;
	
	@GetMapping("radiationList")
	public String radiationList(Model model) {
		radiationListService.execute(model);
		return "thymeleaf/radiation/radiationList";
	}
	@GetMapping("radiationWrite")
	public String radiationWrite(String inspectionNum, Model model) {
		String autoNum = autoNumService.execute("rad_",5,"RADIATION_NUM","radiation");
		model.addAttribute("autoNum", autoNum);
		if(inspectionNum != null) {
			model.addAttribute("inspectionNum", inspectionNum);
		}
		return "thymeleaf/radiation/radiationWrite";
	}
	@PostMapping("radiationWrite")
	public String radiationWrite(RadiationCommand radiationCommand) {
		radiationWriteService.execute(radiationCommand);
		return "redirect:radiationList";
	}
	@GetMapping("radiationDetail")
	public String radiationDetail(String radiationNum, String inspectionNum, Model model) {
		radiationDetailService.execute(radiationNum, inspectionNum, model);
		return "thymeleaf/radiation/radiationDetail";
	}
}
