package hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("WardRoomBed")
public class WardRoomBedController {
	
	@RequestMapping("WardList")
	public String wardList() {
		return "thymeleaf/wardRoomBed/wardList";
	}

}
