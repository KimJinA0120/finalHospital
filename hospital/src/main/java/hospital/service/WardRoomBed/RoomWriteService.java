package hospital.service.WardRoomBed;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.RoomCommand;
import hospital.domain.RoomDTO;
import hospital.mapper.BedMapper;

@Service
public class RoomWriteService {
	@Autowired
	BedMapper bedMapper;
	
	public void execute(RoomCommand roomCommand) {
		RoomDTO dto = new RoomDTO();
		BeanUtils.copyProperties(roomCommand, dto);
		bedMapper.roomInsert(dto);
	}

}
