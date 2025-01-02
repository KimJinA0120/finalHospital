package hospital.service.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.PatientDTO;
import hospital.mapper.FindMapper;

@Service
public class FindPatientNumService {
	@Autowired
	FindMapper findMapper;

	public void execute(String patientName, String patientJumin, Model model) {
		PatientDTO dto=new PatientDTO();
		dto.setPatientName(patientName);
		dto.setPatientJumin(patientJumin);
		String patientNum=findMapper.findPatientNum(dto);
		
		model.addAttribute("patientName", patientName);
		model.addAttribute("patientNum", patientNum);
	}

}
