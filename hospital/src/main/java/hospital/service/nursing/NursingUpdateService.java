package hospital.service.nursing;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.NursCommand;
import hospital.domain.NursingDTO;
import hospital.mapper.NursingMapper;

@Service
public class NursingUpdateService {
	
	@Autowired
	NursingMapper nursingMapper;
	public void execute(NursCommand nursCommand) {
		NursingDTO dto = new NursingDTO();
		BeanUtils.copyProperties(nursCommand, dto);
		nursingMapper.update(dto);
	}

}
