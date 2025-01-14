package hospital.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("data")
public class DataController {
	@Autowired
	StockRepository stockRepository;
	
	
	 @RequestMapping("test")
	    public String test() {
	  
	        return "thymeleaf/data/test"; 
	    }
	@RequestMapping("test1")
	public String test1() {
		
		return "thymeleaf/data/test1";
	}
}
