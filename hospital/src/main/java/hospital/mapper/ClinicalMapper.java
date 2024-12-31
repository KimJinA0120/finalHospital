package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.ClinicalDTO;
import hospital.domain.ClinicalInspectionDTO;

@Mapper
public interface ClinicalMapper {
	public int clinicalInsert(ClinicalDTO dto);
	public List<ClinicalInspectionDTO> clinicalAllSelect();
	public ClinicalDTO clinicalOneSelect(String clinicalNum);
}
