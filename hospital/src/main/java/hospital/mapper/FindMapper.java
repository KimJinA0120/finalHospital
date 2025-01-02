package hospital.mapper;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.FindDTO;
import hospital.domain.PatientDTO;

@Mapper
public interface FindMapper {

	public String findPatientId(FindDTO dto);

	public String findEmpId(FindDTO dto);

	public Integer findPatient(FindDTO dto);
	
	public Integer findEmployee(FindDTO dto);

	public void patientTemPoraryPw(FindDTO dto);

	public void empTemPoraryPw(FindDTO dto);

	public String findPatientNum(PatientDTO dto);

}
