package hospital.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.PatientDTO;
import hospital.mapper.PatientMapper;

@Service
public class EmployeeListService {
	@Autowired
	PatientMapper patientMapper;

	public void execute(Model model) {
		List<PatientDTO> list=patientMapper.patientSelectAll();
		model.addAttribute("list", list);
		
	}

}
