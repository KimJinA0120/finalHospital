package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.command.WardPsCommand;
import hospital.domain.SEPhosPatientDTO;
import hospital.domain.WardPsDTO;

@Mapper
public interface WardPsMapper {

	public List<WardPsDTO> selectList(SEPhosPatientDTO hpSEP);

	public void wardPsWrite(WardPsDTO dto);

	public WardPsDTO selectOne(String num);

	public void wardPsUpdate(WardPsCommand wardPsCommand);

	public void delete(String num);

	public Integer count();

}
