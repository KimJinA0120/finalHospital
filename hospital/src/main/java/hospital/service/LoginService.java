package hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import hospital.command.LoginCommand;
import hospital.domain.AuthInfoDTO;
import hospital.mapper.LoginMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired 
	PasswordEncoder passwordEncoder;
	 

	public Integer patientLogin(LoginCommand loginCommand, HttpSession session, BindingResult result) {
		AuthInfoDTO auth = loginMapper.patientLoginSelectOne(loginCommand.getUserId());
		// 아이디가 존재하는 경우 세션 생성, 아이디가 없으면 세션 생성X

		if (auth != null) { // 세션이 있다=아이디가 있다.
			System.out.println("아이디:" + loginCommand.getUserId());
			if (passwordEncoder.matches(loginCommand.getUserPw(), auth.getUserPw())) {
				System.out.println("비밀번호가 일치합니다.");
				session.setAttribute("auth", auth);
				return 1;
			} else {// 비밀번호 불일치
				result.rejectValue("userPw", "loginCommand.userPw", "비밀번호가 틀렸습니다.");
				System.out.println("비밀번호가 일치하지 않습니다.");
				return 0;
			}
		} else {// 유저 아이디가 존재하지 않는 겨우
			result.rejectValue("userId", "loginCommand.userId", "아이디가 존재하지 않습니다.");
			System.out.println("아이디가 존재하지 않습니다.");
			return 0;
		}
	}
		
		public Integer employeeLogin(LoginCommand loginCommand, HttpSession session, BindingResult result) {
			AuthInfoDTO auth = loginMapper.employeeLoginSelectOne(loginCommand.getUserId());
			// 아이디가 존재하는 경우 세션 생성, 아이디가 없으면 세션 생성X

			if (auth != null) { // 세션이 있다=아이디가 있다.
				System.out.println("아이디:" + loginCommand.getUserId());
				if (passwordEncoder.matches(loginCommand.getUserPw(), auth.getUserPw())) { // passwordEncoder.matches(loginCommand.getUserPw(),auth.getUserPw())
					System.out.println("비밀번호가 일치합니다.");
					session.setAttribute("auth", auth);
					return 1;
				} else {// 비밀번호 불일치
					result.rejectValue("userPw", "loginCommand.userPw", "비밀번호가 틀렸습니다.");
					System.out.println("비밀번호가 일치하지 않습니다.");
					return 0;
				}
			} else {// 유저 아이디가 존재하지 않는 겨우
				result.rejectValue("userId", "loginCommand.userId", "아이디가 존재하지 않습니다.");
				System.out.println("아이디가 존재하지 않습니다.");
				return 0;
			}
		}
}


