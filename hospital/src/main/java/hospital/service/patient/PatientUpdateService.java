package hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import hospital.command.PatientCommand;
import hospital.domain.AuthInfoDTO;
import hospital.domain.PatientDTO;
import hospital.mapper.PatientMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class PatientUpdateService { //환자가 직접 본인정보를 수정할때, 직원이 환자정보를 수정할때, 환자번호 찾기 후 가입할때
	@Autowired
	PatientMapper patientMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(HttpSession session, String patientNum, PatientCommand patientCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		if(session!=null && auth.getGrade()=="pat") { //환자가 직접 본인정보를 수정할떄
			String patientId=auth.getUserId();
			patientNum=patientMapper.patientNumSelect(patientId);
		}
		
		PatientDTO dto = new PatientDTO();
		dto.setPatientNum(patientNum);
		dto.setPatientName(patientCommand.getPatientName());
		//dto.setPatientJumin(patientCommand.getPatientJumin());
		dto.setPatientBirth(patientCommand.getPatientBirth());
		dto.setPatientGender(patientCommand.getPatientGender());
		dto.setPatientId(patientCommand.getPatientId());
		if(session==null) { //환자번호 찾기 후 가입할때
			dto.setPatientPw(patientCommand.getPatientPw());
			dto.setPatientPwCon(patientCommand.getPatientPwCon());
		}
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
		String newPw=passwordEncoder.encode(patientCommand.getPatientPw());
		
		PatientDTO dto=new PatientDTO();
		dto.setPatientNum(patientNum);
		dto.setPatientPw(newPw);
		dto.setPatientPwCon(patientCommand.getPatientPwCon()); //비밀번호 일치여부를 확인하고 업데이트하자.
		
		patientMapper.patientPwUpdate(dto);
		auth.setUserPw(newPw);
	}

	public void patientPwCon(HttpSession session, PatientCommand patientCommand, BindingResult result) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		
		if(!passwordEncoder.matches(patientCommand.getPatientPwCon(), auth.getUserPw())) {
			result.rejectValue("patientPwCon", "${patientCommand.patientPwCon}", "입력한 비밀번호와 현재 비밀번호가 일치하지 않습니다.");
		}
		
	}

}
