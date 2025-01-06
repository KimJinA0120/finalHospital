package hospital.service.WardRoomBed;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.WardCommand;
import hospital.domain.WardDTO;
import hospital.mapper.BedMapper;

@Service
public class WardWriteService {
	@Autowired
	BedMapper bedMapper;
	
	public void execute(WardCommand wardCommand) {
		WardDTO dto = new WardDTO();
		BeanUtils.copyProperties(wardCommand, dto);
		
		bedMapper.wardInsert(dto);
		
	}

}
