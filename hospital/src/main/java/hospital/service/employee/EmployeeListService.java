package hospital.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.AuthInfoDTO;
import hospital.domain.DoctorDTO;
import hospital.domain.EmployeeDTO;
import hospital.domain.StartEndPageDTO;
import hospital.mapper.DoctorMapper;
import hospital.mapper.EmployeeMapper;
import hospital.service.StartEndPageService;
import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeListService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	DoctorMapper doctorMapper;
	@Autowired
	StartEndPageService startEndPageService;

	public void execute(String searchWord, Integer page, Model model) { //cngn null자리에 Kind 추가하기
		int limit=10;
		
		StartEndPageDTO sepDTO=startEndPageService.execute(page, limit, searchWord, null);
		List<EmployeeDTO> list=employeeMapper.employeeSelectAll(sepDTO);
		
		Integer count=employeeMapper.employeeCount(null);
		startEndPageService.execute(page,limit,count,searchWord,list, model, null);
		
	}

	public void employeeSearch(String searchWord, Integer page, Model model,String kind) { //추후 null자리에 kind 추가하기
		int limit=3;
		
		StartEndPageDTO sepDTO=startEndPageService.execute(page, limit, searchWord, kind);
		List<EmployeeDTO> list=employeeMapper.employeeSelectAll(sepDTO);
		
		Integer count=employeeMapper.employeeCount(kind);
		startEndPageService.execute(page,limit,count,searchWord,list, model, kind);
		
	}

	public void doctorSearch(String searchWord, Integer page, Model model, String kind) {
		int limit=5;
		
		StartEndPageDTO sepDTO=startEndPageService.execute(page, limit, searchWord, kind);
		List<DoctorDTO> list=doctorMapper.doctorSelectAll(sepDTO);
		
		Integer count=doctorMapper.doctorCount();
		startEndPageService.execute(page,limit,count,searchWord,list, model, kind);
		
	}

}
