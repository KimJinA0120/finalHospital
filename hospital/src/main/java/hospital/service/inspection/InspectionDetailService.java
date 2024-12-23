package hospital.service.inspection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.InspectionDTO;
import hospital.mapper.InspectionMapper;

@Service
public class InspectionDetailService {
	@Autowired
	InspectionMapper inspectionMapper;
	public void execute(String inspectionNum, Model model) {
		InspectionDTO dto = inspectionMapper.inspectionOneSelect(inspectionNum);
		model.addAttribute("dto", dto);
	}
}
