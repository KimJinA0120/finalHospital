package hospital.service.WardRoomBed;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.EmergencyCommand;
import hospital.domain.EmergencyDTO;
import hospital.mapper.BedMapper;

@Service
public class EmerBedWriteService {
	@Autowired
	BedMapper bedMapper;
	
	public void execute(EmergencyCommand emergencyCommand) {
		EmergencyDTO dto = new EmergencyDTO();
		BeanUtils.copyProperties(emergencyCommand, dto);
		bedMapper.emerBedInsert(dto);
	}
}
