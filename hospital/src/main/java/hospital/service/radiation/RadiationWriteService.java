package hospital.service.radiation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.RadiationCommand;
import hospital.domain.RadiationDTO;
import hospital.mapper.InspectionMapper;
import hospital.mapper.RadiationMapper;

@Service
public class RadiationWriteService {
	@Autowired
	RadiationMapper radiationMapper;
	@Autowired
	InspectionMapper inspectionMapper;
	public void execute(RadiationCommand radiationCommand) {
		RadiationDTO dto = new RadiationDTO();
		BeanUtils.copyProperties(radiationCommand, dto);
		
		radiationMapper.radiationInsert(dto);
		inspectionMapper.inspectionStatusUpdate(dto.getInspectionNum());
	}
}
