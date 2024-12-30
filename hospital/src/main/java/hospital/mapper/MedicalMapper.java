package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.MedicalDTO;
import hospital.domain.StartEndPageDTO;

@Mapper
public interface MedicalMapper {
	public int medicalInsert(MedicalDTO dto);
	public List<MedicalDTO> medicalSelectList(StartEndPageDTO sepDTO);
	public int medicalCount(String searchWord);
	public MedicalDTO medicalSelectOne(String medicalNum);
	public int medicalUpdate(MedicalDTO dto);
}
