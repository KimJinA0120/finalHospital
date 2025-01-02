package hospital.service.receipt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.ReceiptDTO;
import hospital.domain.StartEndPageDTO;
import hospital.mapper.ReceiptMapper;
import hospital.service.StartEndPageService;

@Service
public class ReceiptListService {
	@Autowired
	ReceiptMapper receiptMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	public void execute(Integer page, String searchWord, Model model) {
		Integer limit = 10;
		
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord, null);
		List<ReceiptDTO> list = receiptMapper.receiptSelectList(sepDTO);
		
		Integer count = receiptMapper.receiptCount(searchWord);
		startEndPageService.execute(page, limit, count, searchWord, list, model, null);
		
	}
}
