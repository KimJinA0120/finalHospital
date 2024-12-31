package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hospital.domain.InspectionDTO;
import hospital.domain.StartEndPageDTO;

@Mapper
public interface InspectionMapper {
	public int inspectionInsert(InspectionDTO dto);
	public int inspectionStatusUpdate(String inspectionNum);
	public List<InspectionDTO> inspectionAllSelect(StartEndPageDTO sepDTO);
	public InspectionDTO inspectionOneSelect(String inspectionNum);
	public int inspectionUpdate(InspectionDTO dto);
	public int inspectionDelete(String inspectionNum);
	public int inspectionCount(
			@Param("searchWord")String searchWord,
			@Param("kind")String kind);
}
