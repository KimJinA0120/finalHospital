package hospital.service.wardPS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.WardPsCommand;
import hospital.mapper.WardPsMapper;

@Service
public class WardPsUpdateService {
	
	@Autowired
	WardPsMapper wardPsMapper;
	public int execute(WardPsCommand wardPsCommand) {
		String cause = "처방 중지 요청자 : "+ wardPsCommand.getStopDoc() 
						+"/n"+ wardPsCommand.getStopCause();
		String wardPsNum = wardPsCommand.getWardPsNum();
		
		return wardPsMapper.wardPsUpdate(cause, wardPsNum);
	}

}
