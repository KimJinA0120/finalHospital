package hospital.service.clinical;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.ClinicalCommand;
import hospital.domain.ClinicalDTO;
import hospital.mapper.ClinicalMapper;

@Service
public class ClinicalWriteService {
	@Autowired
	ClinicalMapper clinicalMapper;
	public void execute(ClinicalCommand clinicalCommand) {
		ClinicalDTO dto = new ClinicalDTO();
		BeanUtils.copyProperties(clinicalCommand, dto);
		
		clinicalMapper.clinicalInsert(dto);
	}
}
