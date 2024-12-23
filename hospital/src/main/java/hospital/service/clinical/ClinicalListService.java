package hospital.service.clinical;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.ClinicalInspectionDTO;
import hospital.mapper.ClinicalMapper;

@Service
public class ClinicalListService {
	@Autowired
	ClinicalMapper clinicalMapper;
	public void execute(Model model) {
		List<ClinicalInspectionDTO> list = clinicalMapper.clinicalAllSelect();
		model.addAttribute("list", list);
	}
}
