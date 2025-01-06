package hospital.service.WardRoomBed;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.BedCommand;
import hospital.domain.BedDTO;
import hospital.mapper.BedMapper;

@Service
public class BedWriteService {
	@Autowired
	BedMapper bedMapper;
	
	public void execute(BedCommand bedCommand) {
		BedDTO dto = new BedDTO();
		BeanUtils.copyProperties(bedCommand, dto);
		bedMapper.bedInsert(dto);
	}

}
