package hospital.service.clinical;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.ClinicalCommand;
import hospital.domain.ClinicalDTO;
import hospital.mapper.ClinicalMapper;
import hospital.mapper.InspectionMapper;

@Service
public class ClinicalWriteService {
	@Autowired
	ClinicalMapper clinicalMapper;
	@Autowired
	InspectionMapper inspectionMapper;
	public void execute(ClinicalCommand clinicalCommand) {
		ClinicalDTO dto = new ClinicalDTO();
		BeanUtils.copyProperties(clinicalCommand, dto);
		
		clinicalMapper.clinicalInsert(dto);
		inspectionMapper.inspectionStatusUpdate(dto.getInspectionNum());
	}
}
