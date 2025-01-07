package hospital.service.hosPatient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.HosPatientDTO;
import hospital.mapper.HosPatientMapper;

@Service
public class MyPatientListService {
	
	@Autowired
	HosPatientMapper hosPatientMapper;
	public void execute(String colNm, String empNum, Model model) {
		
		String empName = hosPatientMapper.empName(empNum);
		List<HosPatientDTO> list = hosPatientMapper.myWardPatient(colNm, empNum);
		model.addAttribute("empName", empName);
		model.addAttribute("list", list);
	}

}
