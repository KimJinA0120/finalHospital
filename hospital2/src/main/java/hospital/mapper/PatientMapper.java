package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.PatientDTO;

@Mapper
public interface PatientMapper {

	public void patientInsert(PatientDTO dto);

	public List<PatientDTO> patientSelectAll();

	public String patientNumSelect(String patientId);

	public PatientDTO patientSelectOne(String patientNum);

	public void patientUpdate(PatientDTO dto);

	public void patientDelete(String patientNum);

}
