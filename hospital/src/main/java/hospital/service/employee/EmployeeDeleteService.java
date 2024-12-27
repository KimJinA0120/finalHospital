package hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.domain.AuthInfoDTO;
import hospital.mapper.DoctorMapper;
import hospital.mapper.EmployeeMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeDeleteService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	DoctorMapper doctorMapper;
	public void execute(HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empId = auth.getUserId();
		String empNum = employeeMapper.employeeNumSelect(empId);
		
		String section = empNum.substring(0, 3);
		System.out.println(section);
		if (section.equals("doc")) {
			doctorDelete(empNum);
		}

		employeeMapper.employeeDelete(empNum);
		
	}
	
	public void doctorDelete(String empNum) {
		doctorMapper.doctorDelete(empNum);
	}

}
