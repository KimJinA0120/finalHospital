package hospital.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.DoctorDTO;
import hospital.domain.EmployeeDTO;
import hospital.domain.StartEndPageDTO;
import hospital.mapper.DoctorMapper;
import hospital.mapper.EmployeeMapper;
import hospital.service.StartEndPageService;

@Service
public class EmployeeListService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	DoctorMapper doctorMapper;
	@Autowired
	StartEndPageService startEndPageService;

	public void execute(String searchWord, Integer page, Model model) {
		int limit=10;
		
		StartEndPageDTO sepDTO=startEndPageService.execute(page, limit, searchWord);
		List<EmployeeDTO> list=employeeMapper.employeeSelectAll(sepDTO);
		
		Integer count=employeeMapper.employeeCount();
		startEndPageService.execute(page,limit,count,searchWord,list, model);
		//model.addAttribute("list", list);
		
	}

	public void employeeSearch(String searchWord, Integer page, Model model) {
		int limit=3;
		
		StartEndPageDTO sepDTO=startEndPageService.execute(page, limit, searchWord);
		List<EmployeeDTO> list=employeeMapper.employeeSelectAll(sepDTO);
		
		Integer count=employeeMapper.employeeCount();
		startEndPageService.execute(page,limit,count,searchWord,list, model);
		
	}

	public void doctorSearch(String searchWord, Integer page, Model model) {
		int limit=5;
		
		StartEndPageDTO sepDTO=startEndPageService.execute(page, limit, searchWord);
		List<DoctorDTO> list=doctorMapper.doctorSelectAll(sepDTO);
		
		Integer count=doctorMapper.doctorCount();
		startEndPageService.execute(page,limit,count,searchWord,list, model);
		
	}

}
