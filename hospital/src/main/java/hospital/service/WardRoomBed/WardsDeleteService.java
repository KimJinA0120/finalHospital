package hospital.service.WardRoomBed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.mapper.BedMapper;

@Service
public class WardsDeleteService {
	@Autowired
	BedMapper bedMapper;
	
	public void execute(String wards[]) {
		bedMapper.wardsDelete(wards);
	}

}
