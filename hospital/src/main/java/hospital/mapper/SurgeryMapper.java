package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.SurgeryAppointmentDTO;

@Mapper
public interface SurgeryMapper {
	public int SurgeryAppointment(SurgeryAppointmentDTO dto);
	public List<SurgeryAppointmentDTO> surgeryAppointmentList();
}
