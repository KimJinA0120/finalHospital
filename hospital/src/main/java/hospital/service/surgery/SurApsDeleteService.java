package hospital.service.surgery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.mapper.SurgeryMapper;

@Service
public class SurApsDeleteService {
	@Autowired
	SurgeryMapper surgeryMapper;
	public void execute(String surApsDel []) {
		surgeryMapper.surApsDelete(surApsDel);
	}
}
