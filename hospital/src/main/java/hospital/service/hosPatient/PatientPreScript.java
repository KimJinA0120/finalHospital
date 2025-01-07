package hospital.service.hosPatient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.HosPatientDTO;
import hospital.mapper.HosPatientMapper;

@Service
public class PatientPreScript {
	
	@Autowired
	HosPatientMapper hosPatientMapper;
	public void execute(String hospNum, Model model) {
		
		List<HosPatientDTO> list = hosPatientMapper.selectPatPs(hospNum);
		HosPatientDTO dto1 = hosPatientMapper.wardPatInfo(hospNum);
		
		model.addAttribute("dto1", dto1);
		model.addAttribute("list", list);
		
	}

}
