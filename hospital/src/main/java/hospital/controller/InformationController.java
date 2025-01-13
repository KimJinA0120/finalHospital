package hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("info")
public class InformationController {
	
	@GetMapping("directions") //오시는 길
	public String directions() {
		return "thymeleaf/info/directions";
	}
	

}
