package hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.PatientCommand;
import hospital.domain.AuthInfoDTO;
import hospital.domain.PatientDTO;
import hospital.mapper.PatientMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class PatientUpdateService {
	@Autowired
	PatientMapper patientMapper;
	
	public void execute(HttpSession session, PatientCommand patientCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String patientId=auth.getUserId();
		String patientNum=patientMapper.patientNumSelect(patientId);
		
		PatientDTO dto = new PatientDTO();
		dto.setPatientNum(patientCommand.getPatientNum());
		dto.setPatientName(patientCommand.getPatientName());
		dto.setPatientJumin(patientCommand.getPatientJumin());
		dto.setPatientBirth(patientCommand.getPatientBirth());
		dto.setPatientGender(patientCommand.getPatientGender());
		dto.setPatientId(patientCommand.getPatientId());
		dto.setPatientPw(patientCommand.getPatientPw());
		dto.setPatientPwCon(patientCommand.getPatientPwCon());
		dto.setPatientAddr(patientCommand.getPatientAddr());
		dto.setPatientAddrDetail(patientCommand.getPatientAddrDetail());
		dto.setPatientPost(patientCommand.getPatientPost());
		dto.setPatientEmail(patientCommand.getPatientEmail());
		dto.setPatientPhone(patientCommand.getPatientPhone());
		
		patientMapper.patientUpdate(dto);
		
		
	}

}
