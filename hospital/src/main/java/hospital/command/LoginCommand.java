package hospital.command;


import lombok.Data;

@Data
public class LoginCommand {
	//@NotEmpty(message="아이디를 입력하여주세요")
	String userId;
	//@NotEmpty(message="비밀번호를 입력하여주세요")
	String userPw;
}
