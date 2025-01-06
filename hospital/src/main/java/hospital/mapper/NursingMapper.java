package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.HosPatientDTO;
import hospital.domain.NursingDTO;
import hospital.domain.SEPhosPatientDTO;
import hospital.domain.StartEndPageDTO;

@Mapper
public interface NursingMapper {

	public void write(NursingDTO dto);

	public NursingDTO selectOne(String num);

	public void update(NursingDTO dto);

	public void delete(String num);

	public Integer count();

	public List<NursingDTO> selectList(StartEndPageDTO sepDTO);

	

}
