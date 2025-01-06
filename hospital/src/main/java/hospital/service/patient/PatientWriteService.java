package hospital.service.patient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import hospital.command.PatientCommand;
import hospital.domain.PatientDTO;
import hospital.mapper.PatientMapper;

@Service
public class PatientWriteService {
	@Autowired
	PatientMapper patientMapper;
	@Autowired 
	PasswordEncoder passwordEncoder;
	 

	public void execute(PatientCommand patientCommand) {
		PatientDTO dto = new PatientDTO();
		//주민번호가 겹치는 사람이 있는지 먼저 확인하기
		String patientJumin=patientCommand.getPatientJuminF()+patientCommand.getPatientJuminB();
		//String result1=patientMapper.patientJuminCon(patientJumin);
		/*if(result1=="있음") { //겹치는 사람이 있음
			//회원가입을 하지 않고, "이미 등록된 회원입니다. 환자번호찾기를 먼저 이용해주세요" 를 띄우기
			result.rejectValue("patientJumin","patientCommand.patientJumin"
					,"이미 등록된 회원입니다. 환자번호찾기 후 회원가입해주세요.");
		}else { //주민번호가 겹치는 사람이 없음
*/			dto.setPatientNum(patientCommand.getPatientNum());
			dto.setPatientName(patientCommand.getPatientName());
			dto.setPatientJumin(patientCommand.getPatientJuminF()+patientCommand.getPatientJuminB());
			dto.setPatientBirth(patientCommand.getPatientBirth());
			dto.setPatientGender(patientCommand.getPatientGender());
			dto.setPatientId(patientCommand.getPatientId());
			
			dto.setPatientPw( passwordEncoder.encode( patientCommand.getPatientPw()));
			
			dto.setPatientPwCon(patientCommand.getPatientPwCon());
			dto.setPatientAddr(patientCommand.getPatientAddr());
			dto.setPatientAddrDetail(patientCommand.getPatientAddrDetail());
			dto.setPatientPost(patientCommand.getPatientPost());
			dto.setPatientEmail(patientCommand.getPatientEmail());
			dto.setPatientPhone(patientCommand.getPatientPhone());
			
			patientMapper.patientInsert(dto);
			/* } */
	}
}
