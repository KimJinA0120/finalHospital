package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.NursingDTO;

@Mapper
public interface NursingMapper {

	public void write(NursingDTO dto);

	public List<NursingDTO> selectList();

	public NursingDTO selectOne(String num);

	public void update(NursingDTO dto);

	public void delete(String num);

}
