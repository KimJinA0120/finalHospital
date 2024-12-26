package hospital.service.nursing;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.NursCommand;
import hospital.domain.NursingDTO;
import hospital.mapper.NursingMapper;

@Service
public class NursingWriteService {
	
	@Autowired
	NursingMapper nursingMapper;
	public void execute(NursCommand nursCommand) {
		NursingDTO dto = new NursingDTO();
		BeanUtils.copyProperties(nursCommand, dto);
		dto.setPresDate(Timestamp.valueOf(nursCommand.getPresDate()));
		
		nursingMapper.write(dto);
	}

}
