package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.RadiatInspectionDTO;
import hospital.domain.RadiationDTO;

@Mapper
public interface RadiationMapper {
	public int radiationInsert(RadiationDTO dto);
	public List<RadiatInspectionDTO> radiationAllSelect();
	public RadiationDTO radiationOneSelect(String radiationNum);
}
