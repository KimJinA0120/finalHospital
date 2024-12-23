package hospital.service.wardPS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.mapper.WardPsMapper;

@Service
public class WardPsDeleteService {
	
	@Autowired
	WardPsMapper wardPsMapper;
	public void execute(String num) {
		wardPsMapper.delete(num);
	}

}
