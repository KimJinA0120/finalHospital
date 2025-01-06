package hospital.service.surgery;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.SurgeryAppointmentCommand;
import hospital.domain.SurgeryAppointmentDTO;
import hospital.mapper.SurgeryMapper;

@Service
public class SurgeryAppointmentUpdateService {
	@Autowired
	SurgeryMapper surgeryMapper;
	
	public void execute(SurgeryAppointmentCommand surgeryAppointmentCommnad) {
		SurgeryAppointmentDTO dto = new SurgeryAppointmentDTO();
		BeanUtils.copyProperties(surgeryAppointmentCommnad, dto);
		
		surgeryMapper.surgeryAppointmentUpdate(dto);
	}
}
