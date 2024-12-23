package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.WardPsDTO;

@Mapper
public interface WardPsMapper {

	public List<WardPsDTO> selectList();

	public void wardPsWrite(WardPsDTO dto);

	public WardPsDTO selectOne(String num);

}
