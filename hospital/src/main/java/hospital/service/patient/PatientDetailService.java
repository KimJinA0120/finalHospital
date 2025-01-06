package hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.AuthInfoDTO;
import hospital.domain.PatientDTO;
import hospital.mapper.PatientMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class PatientDetailService {
	@Autowired
	PatientMapper patientMapper;
	
	public void execute(HttpSession session,String patientNum, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		if(auth.getGrade().equals("pat")) {
			String patientId=auth.getUserId();
			patientNum=patientMapper.patientNumSelect(patientId);
		}
		
		PatientDTO dto=patientMapper.patientSelectOne(patientNum);
		
		model.addAttribute("dto", dto);
		model.addAttribute("patientCommand", dto);
		
	}

}
