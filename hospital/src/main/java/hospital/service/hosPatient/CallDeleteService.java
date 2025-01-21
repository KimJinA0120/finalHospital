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
	public Integer execute(CallPsDeleteCommand callPsDeleteCommand) {
		String cause = "삭제 요청자 : " + callPsDeleteCommand.getDelCaller()
						+ "/n" + callPsDeleteCommand.getDelCause();
		
		String psNum = callPsDeleteCommand.getDelPsNum().trim();
		
		CallPsDeleteDTO dto = new CallPsDeleteDTO();
		dto.setDelCallNum(callPsDeleteCommand.getDelCallNum());
		dto.setDelPsNum(psNum);
		dto.setDelCause(cause);
		
		if (psNum.startsWith("WPS_")) {
			hosPatientMapper.WPSupdate(dto);
			
		}else {
			String stopN = "삭제접수 : " + callPsDeleteCommand.getDelCallNum();
			hosPatientMapper.nursingUpdate(psNum, stopN);
			
		}
		return hosPatientMapper.delete(dto);
		
	}

}
