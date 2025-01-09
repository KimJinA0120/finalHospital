package hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import hospital.command.DoctorCommand;
import hospital.command.EmployeeCommand;
import hospital.command.PatientCommand;
import hospital.domain.AuthInfoDTO;
import hospital.domain.DoctorDTO;
import hospital.domain.EmployeeDTO;
import hospital.domain.PatientDTO;
import hospital.mapper.DoctorMapper;
import hospital.mapper.EmployeeMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	DoctorMapper doctorMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	public void execute(HttpSession session, EmployeeCommand employeeCommand) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String employeeId = auth.getUserId();
		String employeeNum = employeeMapper.employeeNumSelect(employeeId);

		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpNum(employeeCommand.getEmpNum());
		  dto.setEmpName(employeeCommand.getEmpName());
		  //dto.setEmpJumin(employeeCommand.getEmpJumin());
		  dto.setEmpBirth(employeeCommand.getEmpBirth());
		  dto.setEmpGender(employeeCommand.getEmpGender());
		  dto.setEmpId(employeeCommand.getEmpId());
			/*
			 * dto.setEmpPw(employeeCommand.getEmpPw());
			 * dto.setEmpPwCon(employeeCommand.getEmpPwCon());
			 */
		  dto.setEmpAddr(employeeCommand.getEmpAddr());
		  dto.setEmpAddrDetail(employeeCommand.getEmpAddrDetail());
		  dto.setEmpPost(employeeCommand.getEmpPost());
		  dto.setEmpEmail(employeeCommand.getEmpEmail());
		  
		  dto.setEmpPhone(employeeCommand.getEmpPhone());
		  
		  dto.setSectionNum(employeeCommand.getSectionNum());
		  dto.setPosition(employeeCommand.getPosition());
		  dto.setEmpHiredate(employeeCommand.getEmpHiredate());
		  
		 

		String section = employeeCommand.getEmpNum().substring(0, 3);
		System.out.println(section);
		if (section.equals("doc")) { //sectionNum 앞 세자리가 doc일 경우, 의사정보 업데이트
			DoctorDTO doctorDTO = new DoctorDTO();
			String medicalSubject = doctorMapper.selectSectionName(employeeCommand.getSectionNum());
			doctorDTO.setEmpNum(employeeCommand.getEmpNum());
			doctorDTO.setMedicalSubject(medicalSubject);
			doctorMapper.doctorMedicalUpdate(doctorDTO);
			System.out.println(medicalSubject);
			System.out.println(doctorDTO);
		}

		employeeMapper.employeeUpdate(dto);
	}


	public void doctorUpdate(DoctorCommand doctorCommand) { // 진료실 위치만 수정 가능
		DoctorDTO dto = new DoctorDTO();

		dto.setEmpNum(doctorCommand.getEmpNum());
		dto.setMedicalRoomLocation(doctorCommand.getMedicalRoomLocation());

		/*
		 * EmployeeDTO dto1=employeeMapper.employeeSelectOne(doctorCommand.getEmpNum());
		 * String medicalSubject=doctorMapper.selectSectionName(dto1.getSectionNum());
		 * dto.setMedicalSubject(medicalSubject);
		 */

		doctorMapper.doctorUpdate(dto);

	}
	public void employeePwUpdate(HttpSession session, EmployeeCommand employeeCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String empId=auth.getUserId();
		String empNum=employeeMapper.employeeNumSelect(empId);
		String newPw=passwordEncoder.encode(employeeCommand.getEmpPw());
		
		EmployeeDTO dto=new EmployeeDTO();
		dto.setEmpNum(empNum);
		dto.setEmpPw(newPw);
		dto.setEmpPwCon(employeeCommand.getEmpPwCon()); //비밀번호 일치여부를 확인하고 업데이트하자.
		
		employeeMapper.employeePwUpdate(dto);
		auth.setUserPw(newPw);
	}

	public void employeePwCon(HttpSession session, EmployeeCommand employeeCommand, BindingResult result) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		
		if(!passwordEncoder.matches(employeeCommand.getEmpPwCon(), auth.getUserPw())) {
			result.rejectValue("empPwCon", "${employeeCommand.empPwCon}", "입력한 비밀번호와 현재 비밀번호가 일치하지 않습니다.");
		}
	}

	

}
