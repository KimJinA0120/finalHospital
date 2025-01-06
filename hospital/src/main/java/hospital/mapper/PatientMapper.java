package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.PatientDTO;
import hospital.domain.StartEndPageDTO;

@Mapper
public interface PatientMapper {

	public void patientInsert(PatientDTO dto);

	public List<PatientDTO> patientSelectAll(StartEndPageDTO sepDTO);

	public String patientNumSelect(String patientId);

	public PatientDTO patientSelectOne(String patientNum);

	public void patientUpdate(PatientDTO dto);

	public void patientDelete(String patientNum);

	public Integer patientCount();

	public void patientPwUpdate(PatientDTO dto);

	//public String patientJuminCon(String patientJumin);

}
