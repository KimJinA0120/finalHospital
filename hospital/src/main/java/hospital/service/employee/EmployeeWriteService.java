package hospital.service.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.EmployeeCommand;
import hospital.controller.EmployeeController;
import hospital.domain.EmployeeDTO;
import hospital.mapper.EmployeeMapper;

@Service
public class EmployeeWriteService {
	@Autowired
	EmployeeMapper employeeMapper;

	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpNum(employeeCommand.getEmpNum());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpJumin(employeeCommand.getEmpJumin());
		dto.setEmpBirth(employeeCommand.getEmpBirth());
		dto.setEmpGender(employeeCommand.getEmpGender());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpPw(employeeCommand.getEmpPw());
		dto.setEmpPwCon(employeeCommand.getEmpPwCon());
		dto.setEmpAddr(employeeCommand.getEmpAddr());
		dto.setEmpAddrDetail(employeeCommand.getEmpAddrDetail());
		dto.setEmpPost(employeeCommand.getEmpPost());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpPhone(employeeCommand.getEmpPhone());
		dto.setSectionNum(employeeCommand.getSectionNum());
		dto.setPosition(employeeCommand.getPosition());
		dto.setEmpHiredate(employeeCommand.getEmpHiredate());
		
		employeeMapper.employeeInsert(dto);
	}
}
