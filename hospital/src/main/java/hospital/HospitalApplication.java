package hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@RequestMapping("/")
	public String index() {
		
		return "thymeleaf/index";
	}
	@RequestMapping("empIndex")
	public String empIndex() {
		
		return "thymeleaf/empIndex";
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
	
	
	

}
