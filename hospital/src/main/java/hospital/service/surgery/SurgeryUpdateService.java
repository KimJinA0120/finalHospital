package hospital.service.surgery;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.SurgeryCommand;
import hospital.domain.SurgeryDTO;
import hospital.mapper.SurgeryMapper;

@Service
public class SurgeryUpdateService {
	@Autowired
	SurgeryMapper surgeryMapper;
	public void execute(SurgeryCommand surgeryCommand) {
		SurgeryDTO dto = new SurgeryDTO();
		BeanUtils.copyProperties(surgeryCommand, dto);
		
		surgeryMapper.surgeryUpdate(dto);
	}
}
