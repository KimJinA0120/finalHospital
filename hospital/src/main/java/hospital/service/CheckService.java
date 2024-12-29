package hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.mapper.CheckMapper;

@Service

public class CheckService {
	@Autowired
	CheckMapper checkMapper;

	public Integer idCheck(String userId) {
		// TODO Auto-generated method stub
		return checkMapper.checkId(userId);
	}

	public Integer emailCheck(String userEmail) {
		// TODO Auto-generated method stub
		return checkMapper.checkEmail(userEmail);
	}

}
