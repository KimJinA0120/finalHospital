package hospital.service.surgery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.SurgeryAppointmentDTO;
import hospital.mapper.SurgeryMapper;

@Service
public class SurgeryAppointmentDetailService {
	@Autowired
	SurgeryMapper surgeryMapper;
	public void execute(String surgeryAppointmentNum, Model model) {
		SurgeryAppointmentDTO dto = surgeryMapper.surgeryAppointmentOneSelect(surgeryAppointmentNum);
		model.addAttribute("dto", dto);
	}
}
