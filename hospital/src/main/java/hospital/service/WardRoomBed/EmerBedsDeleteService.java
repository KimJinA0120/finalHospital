package hospital.service.WardRoomBed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.mapper.BedMapper;

@Service
public class EmerBedsDeleteService {
	@Autowired
	BedMapper bedMapper;
	public void execute(String emerBeds[]) {
		bedMapper.emerBedsDelete(emerBeds);
	}

}
