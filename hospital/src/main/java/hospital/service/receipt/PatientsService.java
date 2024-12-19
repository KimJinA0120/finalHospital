package hospital.service.receipt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.domain.ReceiptDTO;
import hospital.mapper.ReceiptMapper;
import hospital.service.StartEndPageService;

@Service
public class PatientsService {
	@Autowired
	ReceiptMapper receiptMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	public Map<String, Object> execute(int page, String searchWord) {
		if(searchWord == null) searchWord = ""; 
		int limit = 3;
		int startRow = ((page - 1) * limit) + 1; 
		int endRow = startRow + limit - 1;
		List<ReceiptDTO> list = receiptMapper.patSelectList(startRow, endRow, searchWord);
		int count = receiptMapper.patSelectListCount(searchWord);
		int limitPage = 10; 
		int startPageNum = (int)((double) page / limitPage + 0.95 - 1) * limitPage + 1;
		int endPageNum = startPageNum + limitPage - 1;
		int maxPage = (int)((double)count / limit + 0.95);
		if(endPageNum > maxPage) endPageNum = maxPage;
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("searchWord", searchWord);
		map.put("list", list);
		map.put("page", page);
		map.put("startPageNum", startPageNum);
		map.put("endPageNum", endPageNum);
		map.put("count", count);
		map.put("maxPage", maxPage);
		return map;
	}
}
