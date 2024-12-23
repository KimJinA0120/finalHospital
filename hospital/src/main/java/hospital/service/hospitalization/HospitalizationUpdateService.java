package hospital.service.hospitalization;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.HospitalizationCommand;
import hospital.domain.HospitalizationDTO;
import hospital.mapper.HospitalizationMapper;

@Service
public class HospitalizationUpdateService {
	@Autowired
	HospitalizationMapper hospitalizationMapper;
	
	public void execute(HospitalizationCommand hospitalizationCommand) {
		HospitalizationDTO dto = new HospitalizationDTO();
		BeanUtils.copyProperties(hospitalizationCommand, dto);
		
		hospitalizationMapper.hospitalizationUpdate(dto);
	}

}
