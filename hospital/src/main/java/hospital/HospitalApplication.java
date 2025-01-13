package hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.domain.AuthInfoDTO;
import jakarta.servlet.http.HttpSession;

@SpringBootApplication
@Controller
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@RequestMapping("/")
	public String index(HttpSession session) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		if(auth==null||auth.getGrade().equals("pat")) { //세션이 없거나 등급이 환자인 경우
			return "thymeleaf/index";
		}else {
			return "thymeleaf/empIndex";
		}
		
		
	}
	@RequestMapping("404")
	public String error() {
		
		return "thymeleaf/404";
	}
	@RequestMapping("blog-single")
	public String blog() {
		
		return "thymeleaf/blog-single";
	}
	@RequestMapping("contact")
	public String contact() {
		
		return "thymeleaf/contact";
	}
	@RequestMapping("appointment")
	public String appointment() {
		
		return "thymeleaf/appointment";
	}
	
	@GetMapping("getHeader")
	public String getHeader() {
		return "thymeleaf/getCss/getHeader";
	}
	
}
