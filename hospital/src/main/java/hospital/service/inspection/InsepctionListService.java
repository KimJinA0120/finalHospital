package hospital.service.inspection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.InspectionDTO;
import hospital.domain.StartEndPageDTO;
import hospital.mapper.InspectionMapper;
import hospital.service.StartEndPageService;

@Service
public class InsepctionListService {
	@Autowired
	InspectionMapper inspectionMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(int page, String searchWord, String kind, Model model) {
		int limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord, kind);
		
		List<InspectionDTO> list = inspectionMapper.inspectionAllSelect(sepDTO);
		
		int count = inspectionMapper.inspectionCount(searchWord, kind);
		startEndPageService.execute(page, limit, count, searchWord, list, model, kind);
	}
}
