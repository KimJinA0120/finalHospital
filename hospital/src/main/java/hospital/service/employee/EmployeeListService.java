package hospital.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.EmployeeDTO;
import hospital.mapper.EmployeeMapper;

@Service
public class EmployeeListService {
	@Autowired
	EmployeeMapper employeeMapper;

	public void execute(Model model) {
		List<EmployeeDTO> list=employeeMapper.employeeSelectAll();
		model.addAttribute("list", list);
		
	}

}
