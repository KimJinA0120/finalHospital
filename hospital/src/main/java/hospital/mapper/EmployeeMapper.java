package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.EmployeeDTO;
import hospital.domain.SectionDTO;
import hospital.domain.StartEndPageDTO;

@Mapper
public interface EmployeeMapper {

	public void employeeInsert(EmployeeDTO dto);

	public List<EmployeeDTO> employeeSelectAll(StartEndPageDTO sepDTO);

	public String employeeNumSelect(String employeeId);

	public EmployeeDTO employeeSelectOne(String employeeNum);

	public void employeeUpdate(EmployeeDTO dto);
	public void employeeDelete(String employeeNum);

	public List<SectionDTO> sectionSearch(StartEndPageDTO sepDTO);

	public Integer employeeCount();

	public Integer sectionCount();

}
