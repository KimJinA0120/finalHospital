package hospital.service.surgery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.SurgeryAppointmentDTO;
import hospital.mapper.SurgeryMapper;

@Service
public class SurgeryAppointmentListService {
	@Autowired
	SurgeryMapper surgeryMapper;
	public void execute(Model model) {
		List<SurgeryAppointmentDTO> list = surgeryMapper.surgeryAppointmentList();
		
		model.addAttribute("list", list);
	}
}
