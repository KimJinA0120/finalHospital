package hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.domain.AuthInfoDTO;
import hospital.mapper.EmployeeMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeDeleteService {
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String employeeId = auth.getUserId();
		String employeeNum = employeeMapper.employeeNumSelect(employeeId);

		employeeMapper.employeeDelete(employeeNum);
		
	}

}
