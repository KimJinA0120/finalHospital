package hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	PasswordEncoder passwordEncoder;
	
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
		/*
		 * dto.setPatientPw(patientCommand.getPatientPw());
		 * dto.setPatientPwCon(patientCommand.getPatientPwCon());
		 */
		dto.setPatientAddr(patientCommand.getPatientAddr());
		dto.setPatientAddrDetail(patientCommand.getPatientAddrDetail());
		dto.setPatientPost(patientCommand.getPatientPost());
		dto.setPatientEmail(patientCommand.getPatientEmail());
		dto.setPatientPhone(patientCommand.getPatientPhone());
		
		patientMapper.patientUpdate(dto);
		
		
	}

	public void patientPwUpdate(HttpSession session, PatientCommand patientCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String patientId=auth.getUserId();
		String patientNum=patientMapper.patientNumSelect(patientId);
		
		PatientDTO dto=new PatientDTO();
		dto.setPatientNum(patientNum);
		dto.setPatientPw(passwordEncoder.encode(patientCommand.getPatientPw()));
		dto.setPatientPwCon(patientCommand.getPatientPwCon()); //비밀번호 일치여부를 확인하고 업데이트하자.
		
		patientMapper.patientPwUpdate(dto);
	}

	public int patientPwCon(HttpSession session, PatientCommand patientCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		
		System.out.println(patientCommand.getPatientPwCon());
		
		String patientPw=auth.getUserPw();
		if(passwordEncoder.matches(patientCommand.getPatientPwCon(), auth.getUserPw())) {
			return 1;
		}else return 0;
		
	}

}
