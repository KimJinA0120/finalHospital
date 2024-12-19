package hospital.mapper;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.AuthInfoDTO;

@Mapper
public interface LoginMapper {

	public AuthInfoDTO patientLoginSelectOne(String userId);
	
	public AuthInfoDTO employeeLoginSelectOne(String userId);
}
