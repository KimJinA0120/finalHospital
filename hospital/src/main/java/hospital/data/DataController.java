package hospital.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.domain.StockDTO;

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
	@RequestMapping("test2")
	public String test2() {
		
		return "thymeleaf/data/test2";
	}
}
