package hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wardPS")
public class WardPsController {
	
	@RequestMapping("wardPsList")
	public String wardPsList() {
		return "thymeleaf/wardPS/wardPsList";
	}
}
