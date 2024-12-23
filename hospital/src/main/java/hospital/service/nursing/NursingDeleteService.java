package hospital.service.nursing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.mapper.NursingMapper;

@Service
public class NursingDeleteService {
	
	@Autowired
	NursingMapper nursingMapper;
	public void execute(String num) {
		nursingMapper.delete(num);
	}

}
