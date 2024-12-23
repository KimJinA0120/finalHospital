package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.InspectionDTO;

@Mapper
public interface InspectionMapper {
	public int inspectionInsert(InspectionDTO dto);
	public List<InspectionDTO> inspectionAllSelect();
	public InspectionDTO inspectionOneSelect(String inspectionNum);
	public int inspectionUpdate(InspectionDTO dto);
	public int inspectionDelete(String inspectionNum);
}
