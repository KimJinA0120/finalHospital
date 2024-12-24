package hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.DoctorCommand;
import hospital.command.EmployeeCommand;
import hospital.domain.AuthInfoDTO;
import hospital.domain.DoctorDTO;
import hospital.domain.EmployeeDTO;
import hospital.mapper.DoctorMapper;
import hospital.mapper.EmployeeMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	DoctorMapper doctorMapper;
	
	public void execute(HttpSession session, EmployeeCommand employeeCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String employeeId=auth.getUserId();
		String employeeNum=employeeMapper.employeeNumSelect(employeeId);
		
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
		
		employeeMapper.employeeUpdate(dto);
		
		
	}
	
	public void doctorUpdate(DoctorCommand doctorCommand) {
		DoctorDTO dto=new DoctorDTO();
		
		dto.setEmpNum(doctorCommand.getEmpNum());
		dto.setMedicalRoomLocation(doctorCommand.getMedicalRoomLocation());
		
		
		/*
		 * EmployeeDTO dto1=employeeMapper.employeeSelectOne(doctorCommand.getEmpNum());
		 * String medicalSubject=doctorMapper.selectSectionName(dto1.getSectionNum());
		 * dto.setMedicalSubject(medicalSubject);
		 */
		
		doctorMapper.doctorUpdate(dto);
		
	}

}
