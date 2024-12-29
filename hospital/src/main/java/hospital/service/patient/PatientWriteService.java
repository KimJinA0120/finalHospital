package hospital.service.patient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
		dto.setPatientNum(patientCommand.getPatientNum());
		dto.setPatientName(patientCommand.getPatientName());
		dto.setPatientJumin(patientCommand.getPatientJumin());
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
	}
}
