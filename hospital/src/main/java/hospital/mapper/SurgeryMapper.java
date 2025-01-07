package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hospital.domain.OperatingRoomDTO;
import hospital.domain.StartEndPageDTO;
import hospital.domain.SurgeryAppointmentDTO;
import hospital.domain.SurgeryDTO;
import hospital.domain.SurgeryListDTO;

@Mapper
public interface SurgeryMapper {
	public int SurgeryAppointment(SurgeryAppointmentDTO dto);
	public List<SurgeryAppointmentDTO> surgeryAppointmentList(StartEndPageDTO sepDTO);
	public int surApsDelete(@Param("surgeryAppointmentNum") String surApsDel[]);
	public SurgeryAppointmentDTO surgeryAppointmentOneSelect(String surgeryAppointmentNum);
	public int surgeryAppointmentUpdate(SurgeryAppointmentDTO dto);
	public int surgeryAppointmentDelete(String surgeryAppointmentNum);
	public int surgeryAppointmentCount(String searchWord);
	
	public int surgeryWrite(SurgeryDTO dto);
	public List<SurgeryListDTO> surgeryList(StartEndPageDTO sepDTO);
	public SurgeryDTO surgeryOneSelect(
			@Param("surgeryNum")String surgeryNum,
			@Param("surgeryAppointmentNum")String surgeryAppointmentNum);
	public int surgeryUpdate(SurgeryDTO dto);
	public int surgeryStatusUpdate(String surgeryAppointmentNum);
	
	public List<OperatingRoomDTO> operatingRoomList();
	
	public List<SurgeryAppointmentDTO> surgeryAppointmentAllSelect();
}
