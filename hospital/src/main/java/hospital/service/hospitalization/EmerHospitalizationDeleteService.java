package hospital.service.hospitalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.mapper.HospitalizationMapper;

@Service
public class EmerHospitalizationDeleteService {
	@Autowired
	HospitalizationMapper hospitalizationMapper;
	
	public void execute(String emerPatientNum) {
		hospitalizationMapper.emerDelete(emerPatientNum);
	}

}
