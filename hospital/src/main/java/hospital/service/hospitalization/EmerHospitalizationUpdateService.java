package hospital.service.hospitalization;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.EmergencyPatientCommand;
import hospital.domain.EmergencyPatientDTO;
import hospital.mapper.HospitalizationMapper;

@Service
public class EmerHospitalizationUpdateService {
	@Autowired
	HospitalizationMapper hospitalizationMapper; 
	
	public void execute(EmergencyPatientCommand emergencyPatientCommand) {
		EmergencyPatientDTO dto = new EmergencyPatientDTO();
		BeanUtils.copyProperties(emergencyPatientCommand, dto);
		
		hospitalizationMapper.emerUpdate(dto);
		hospitalizationMapper.emerBedStatusUpdate(dto);
		hospitalizationMapper.emerBedStatusNew(dto);
	}

}
