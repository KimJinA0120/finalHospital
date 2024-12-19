package hospital.service.hospitalization;

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
		dto.setBedNum(hospitalizationCommand.getBedNum());
		dto.setHospitalizationNum(hospitalizationCommand.getHospitalizationNum());
		dto.setHospitalizationStatus(hospitalizationCommand.getHospitalizationStatus());
		dto.setInDate(hospitalizationCommand.getInDate());
		dto.setOutDate(hospitalizationCommand.getOutDate());
		dto.setPatientNum(hospitalizationCommand.getPatientNum());
		hospitalizationMapper.hospitalizationUpdate(dto);
	}

}
