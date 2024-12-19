package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.SurgeryAppointmentDTO;
import hospital.domain.SurgeryDTO;

@Mapper
public interface SurgeryMapper {
	public int SurgeryAppointment(SurgeryAppointmentDTO dto);
	public List<SurgeryAppointmentDTO> surgeryAppointmentList();
	public SurgeryAppointmentDTO surgeryAppointmentOneSelect(String surgeryAppointmentNum);
	public int surgeryAppointmentUpdate(SurgeryAppointmentDTO dto);
	public int surgeryAppointmentDelete(String surgeryAppointmentNum);
	
	public int surgeryWrite(SurgeryDTO dto);
	public List<SurgeryDTO> surgeryList();
}
