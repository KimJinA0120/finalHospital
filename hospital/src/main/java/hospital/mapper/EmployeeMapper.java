package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.EmployeeDTO;

@Mapper
public interface EmployeeMapper {

	public void employeeInsert(EmployeeDTO dto);

	public List<EmployeeDTO> employeeSelectAll();

	public String employeeNumSelect(String employeeId);

	public EmployeeDTO employeeSelectOne(String employeeNum);

	public void employeeUpdate(EmployeeDTO dto);

	public void employeeDelete(String employeeNum);

}
