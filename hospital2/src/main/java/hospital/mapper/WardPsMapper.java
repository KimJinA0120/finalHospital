package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.WardPsDTO;

@Mapper
public interface WardPsMapper {

	public void wardPsWrite(WardPsDTO dto);

	public List<WardPsDTO> selectList();

}
