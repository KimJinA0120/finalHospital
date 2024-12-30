package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.NursingDTO;
import hospital.domain.StartEndPageDTO;

@Mapper
public interface NursingMapper {

	public void write(NursingDTO dto);

	public List<NursingDTO> selectList(StartEndPageDTO sepDTO);

	public NursingDTO selectOne(String num);

	public void update(NursingDTO dto);

	public void delete(String num);

	public Integer count();

}
