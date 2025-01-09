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
	
	public void execute(String patientNum, Model model) {
		
		PatientDTO dto=patientMapper.patientSelectOne(patientNum);
		
		model.addAttribute("dto", dto);
		model.addAttribute("patientCommand", dto);
		
	}
	
	public void patientMy(HttpSession session, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String patientId=auth.getUserId();
		String patientNum=patientMapper.patientNumSelect(patientId);
		
		PatientDTO dto=patientMapper.patientSelectOne(patientNum);
		
		model.addAttribute("dto", dto);
		model.addAttribute("patientCommand", dto);
		
	}

}
