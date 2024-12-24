package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.BedDTO;
import hospital.domain.RoomDTO;

@Mapper
public interface BedMapper {
	public List<BedDTO> bedList();
	public List<RoomDTO> roomList(String wardNum);
}
