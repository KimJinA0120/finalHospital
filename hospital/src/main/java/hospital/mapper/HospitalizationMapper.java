package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.HospitalizationDTO;

@Mapper
public interface HospitalizationMapper {
	public void hospitalizationInsert(HospitalizationDTO dto);
	public List<HospitalizationDTO> hospitalizationSelectList();
	public HospitalizationDTO hospitalizationSelectOne(String hospitalizationNum);
	public void hospitalizationUpdate(HospitalizationDTO dto);
	public String hospitalizationDelete(String hospitalizationNum);
}
