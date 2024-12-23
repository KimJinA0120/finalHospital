package hospital.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.SectionDTO;
import hospital.domain.StartEndPageDTO;
import hospital.mapper.EmployeeMapper;
import hospital.service.StartEndPageService;

@Service
public class SectionListService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	StartEndPageService startEndPageService;

	public void execute(String searchWord, Integer page, Model model) {
		int limit=5;
		
		StartEndPageDTO sepDTO=startEndPageService.execute(limit, page, searchWord);
		List<SectionDTO> list=employeeMapper.sectionSearch(sepDTO);
		
		Integer count=employeeMapper.sectionCount();
		startEndPageService.execute(page,limit,count,searchWord,list, model);
		
	}
	
}
