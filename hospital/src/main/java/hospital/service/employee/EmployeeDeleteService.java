package hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.domain.AuthInfoDTO;
import hospital.mapper.PatientMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeDeleteService {
	@Autowired
	PatientMapper patientMapper;
	public void execute(HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String patientId = auth.getUserId();
		String patientNum = patientMapper.patientNumSelect(patientId);

		patientMapper.patientDelete(patientNum);
		
	}

}
