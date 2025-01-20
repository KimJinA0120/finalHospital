package hospital.service.hosPatient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.CallPsDeleteCommand;
import hospital.domain.CallPsDeleteDTO;
import hospital.mapper.HosPatientMapper;

@Service
public class CallDeleteService {
	
	@Autowired
	HosPatientMapper hosPatientMapper;
	public void execute(CallPsDeleteCommand callPsDeleteCommand) {
		String cause = "삭제 요청자 : " + callPsDeleteCommand.getDelCaller()
						+ "/n" + callPsDeleteCommand.getDelCause();
		
		CallPsDeleteDTO dto = new CallPsDeleteDTO();
		dto.setDelCallNum(callPsDeleteCommand.getDelCallNum());
		dto.setDelPsNum(callPsDeleteCommand.getDelPsNum());
		dto.setDelCause(cause);
		
		hosPatientMapper.delete(dto);
		
		if (callPsDeleteCommand.getDelPsNum().contains("WPS")) {
			hosPatientMapper.WPSupdate(dto);
		}
	}

}
