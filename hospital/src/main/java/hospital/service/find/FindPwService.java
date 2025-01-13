package hospital.service.find;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.FindDTO;
import hospital.mapper.FindMapper;

@Service
public class FindPwService {
	@Autowired
	FindMapper findMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	public void findPatientPw(String userName, String userId, String userPhone, Model model) {
		FindDTO dto =new FindDTO();
		dto.setUserId(userId);
		dto.setUserName(userName);
		dto.setUserPhone(userPhone);
		Integer i=findMapper.findPatient(dto); //환자가 있는지 찾기
		String message;
		String message2;
		if(i  != null) {
				String newPw=UUID.randomUUID().toString().substring(0,8); //8자리 새 비밀번호 생성
				dto.setUserPw(passwordEncoder.encode(newPw));
				findMapper.patientTemPoraryPw(dto); //비밀번호 변경
				System.out.println("임시비밀번호 생성 완료");
				message="고객님의 새 비밀번호는" +newPw+ "입니다. ";
				message2= "로그인 후 비밀번호를 변경해주세요.";
		}else {
			System.out.println("일치하는 회원이 없음");
			message="입력하신 정보와 일치하는 회원이 없습니다. ";
					message2= "확인 후 다시 시도하여주세요.";
		}
		model.addAttribute("message", message);
		model.addAttribute("message2", message2);
		
	}
	public void findEmpPw(String userName, String userId, String userPhone, Model model) {
		FindDTO dto =new FindDTO();
		dto.setUserId(userId);
		dto.setUserName(userName);
		dto.setUserPhone(userPhone);
		Integer i=findMapper.findEmployee(dto); //환자가 있는지 찾기
		String message;
		String message2;
		if(i!=null) { //환자가 있다면
			String newPw=UUID.randomUUID().toString().substring(0,8); //8자리 새 비밀번호 생성
			dto.setUserPw(passwordEncoder.encode(newPw));
			findMapper.empTemPoraryPw(dto); //비밀번호 변경
			System.out.println("임시비밀번호 생성 완료");
			message="고객님의 새 비밀번호는" +newPw+ "입니다. ";
					message2= "로그인 후 비밀번호를 변경해주세요. ";
			
		}else {
			System.out.println("일치하는 회원이 없음");
			message="입력하신 정보와 일치하는 회원이 없습니다. ";
					message2= "확인 후 다시 시도하여주세요.";
		}
		model.addAttribute("message", message);
		model.addAttribute("message2", message2);
		
	}
}
