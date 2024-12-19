package hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.AuthInfoDTO;
import hospital.domain.EmployeeDTO;
import hospital.mapper.EmployeeMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeDetailService {
	@Autowired
	EmployeeMapper employeeMapper;
	
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String employeeId=auth.getUserId();
		String employeeNum=employeeMapper.employeeNumSelect(employeeId);
		EmployeeDTO dto=employeeMapper.employeeSelectOne(employeeNum);
		
		model.addAttribute("dto", dto);
		
	}

}
