package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.service.info.SectionService;

@Controller
@RequestMapping("info")
public class InformationController {
	
	@GetMapping("directions") //오시는 길(지도 넣기)
	public String directions() {
		return "thymeleaf/info/directions";
	}
	
	@GetMapping("section") //진료과 화면
	public String section() {
		return "thymeleaf/info/section";
	}
	
	@Autowired
	SectionService sectionService;
	@GetMapping("sections")
	public String section(Integer num) {
		sectionService.execute(num);
		return "thymeleaf/info/sections";
	}

}
