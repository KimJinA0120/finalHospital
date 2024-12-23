package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.DoctorDTO;
import hospital.domain.StartEndPageDTO;

@Mapper
public interface DoctorMapper {

	public String selectSectionName(String sectionNum);

	public void doctorInsert(DoctorDTO dto);

	public Integer doctorCount();

	public List<DoctorDTO> doctorSelectAll(StartEndPageDTO sepDTO);

	public void doctorUpdate(DoctorDTO dto);

	public void doctorDelete(String empNum);

}
