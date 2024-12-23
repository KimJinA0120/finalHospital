package hospital.service.inspection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.InspectionDTO;
import hospital.mapper.InspectionMapper;

@Service
public class InsepctionListService {
	@Autowired
	InspectionMapper inspectionMapper;
	public void execute(Model model) {
		List<InspectionDTO> list = inspectionMapper.inspectionAllSelect();
		model.addAttribute("list", list);
	}
}
