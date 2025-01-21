package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hospital.domain.SEPhosPatientDTO;
import hospital.domain.WardPsDTO;

@Mapper
public interface WardPsMapper {

	public List<WardPsDTO> selectList(SEPhosPatientDTO hpSEP);

	public void wardPsWrite(WardPsDTO dto);

	public WardPsDTO selectOne(String num);
	
	public int wardPsUpdate(@Param("cause") String cause
							, @Param("wardPsNum") String wardPsNum);

	public Integer count();

	

}
