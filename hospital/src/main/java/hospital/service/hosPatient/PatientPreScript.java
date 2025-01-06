package hospital.service.hosPatient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.PatPsDTO;
import hospital.mapper.HosPatientMapper;

@Service
public class PatientPreScript {
	
	@Autowired
	HosPatientMapper hosPatientMapper;
	public void execute(String hospNum, String room, String bed
						, String name, Model model) {
		
		String patientNum = hosPatientMapper.selectPatientNum(hospNum);	
		List<PatPsDTO> list = hosPatientMapper.selectPatPs(hospNum);
		
		model.addAttribute("patNum", patientNum);
		model.addAttribute("hospNum", hospNum);
		model.addAttribute("room", room);
		model.addAttribute("bed", bed);
		model.addAttribute("name", name);
		model.addAttribute("list", list);
		
	}

}
