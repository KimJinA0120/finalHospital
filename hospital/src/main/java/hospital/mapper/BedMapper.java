package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.BedDTO;
import hospital.domain.EmergencyDTO;
import hospital.domain.RoomDTO;
import hospital.domain.WardDTO;

@Mapper
public interface BedMapper {
	public List<BedDTO> bedList();
	public List<RoomDTO> roomList(String wardNum);
	public List<EmergencyDTO> emerBedList();
	public List<WardDTO> wardList(String wardNum);
	public void wardInsert(WardDTO dto);
	public void roomInsert(RoomDTO dto);
	public void bedInsert(BedDTO dto);
}
