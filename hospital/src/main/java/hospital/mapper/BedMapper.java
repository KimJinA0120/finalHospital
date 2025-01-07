package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hospital.domain.BedDTO;
import hospital.domain.EmergencyDTO;
import hospital.domain.RoomDTO;
import hospital.domain.WardDTO;

@Mapper
public interface BedMapper {
	public List<BedDTO> bedList();
	public List<RoomDTO> roomList(String wardNum);
	public List<EmergencyDTO> emerBedList();
	public List<WardDTO> wardList();
	public void wardInsert(WardDTO dto);
	public void roomInsert(RoomDTO dto);
	public void bedInsert(BedDTO dto);
	public void emerBedInsert(EmergencyDTO dto);
	public List<RoomDTO> allRoomList();
	public int wardsDelete(@Param("wards") String wards[]);
	public int roomsDelete(@Param("rooms") String rooms[]);
	public int bedsDelete(@Param("beds") String beds[]);
	public int emerBedsDelete(@Param("emerBeds") String emerBeds[]);
}
