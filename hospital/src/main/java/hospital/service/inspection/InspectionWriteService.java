package hospital.service.inspection;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.InspectionCommand;
import hospital.domain.InspectionDTO;
import hospital.mapper.InspectionMapper;

@Service
public class InspectionWriteService {
	@Autowired
	InspectionMapper inspectionMapper;
	public void execute(InspectionCommand inspectionCommand) {
		InspectionDTO dto = new InspectionDTO();
		BeanUtils.copyProperties(inspectionCommand, dto);
		
		inspectionMapper.inspectionInsert(dto);
	}
}
