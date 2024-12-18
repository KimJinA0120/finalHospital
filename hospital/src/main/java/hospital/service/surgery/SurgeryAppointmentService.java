package hospital.service.surgery;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.SurgeryAppointmentCommand;
import hospital.domain.SurgeryAppointmentDTO;
import hospital.mapper.SurgeryMapper;

@Service
public class SurgeryAppointmentService {
	@Autowired
	SurgeryMapper surgeryMapper;
	public void execute(SurgeryAppointmentCommand surgeryAppointmentCommand) {
		SurgeryAppointmentDTO dto = new SurgeryAppointmentDTO();
		
		BeanUtils.copyProperties(surgeryAppointmentCommand, dto);
		
		surgeryMapper.SurgeryAppointment(dto);
	}
}
