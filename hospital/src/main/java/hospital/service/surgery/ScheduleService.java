package hospital.service.surgery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.domain.SurgeryAppointmentDTO;
import hospital.mapper.SurgeryMapper;

@Service
public class ScheduleService {
	@Autowired
	SurgeryMapper surgeryMapper;
	public List<SurgeryAppointmentDTO> execute(){
		return surgeryMapper.surgeryAppointmentAllSelect();
	}
}
