package hospital.service.inspection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.mapper.InspectionMapper;

@Service
public class InspectionDeleteService {
	@Autowired
	InspectionMapper inspectionMapper;
	public void execute(String inspectionNum) {
		inspectionMapper.inspectionDelete(inspectionNum);
	}
}
