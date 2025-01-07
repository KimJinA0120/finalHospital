package hospital.service.WardRoomBed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.mapper.BedMapper;

@Service
public class BedsDeleteService {
	@Autowired
	BedMapper bedMapper;
	public void execute(String beds[]) {
		bedMapper.bedsDelete(beds);
	}

}
