package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hospital.domain.ReceiptDTO;
import hospital.domain.StartEndPageDTO;

@Mapper
public interface ReceiptMapper {
	public List<ReceiptDTO> receiptSelectList(StartEndPageDTO sepDTO);
	public int receiptCount(String searchWord);
	public int receiptInsert(ReceiptDTO receiptDTO);
	public int reservationInsert(ReceiptDTO receiptDTO);
	public List<ReceiptDTO> patSelectList(
			@Param(value="startRow") int startRow
			,@Param(value="endRow")  int endRow
			,@Param(value="searchWord") String searchWord);
	public int patSelectListCount(String searchWord);
	
}
