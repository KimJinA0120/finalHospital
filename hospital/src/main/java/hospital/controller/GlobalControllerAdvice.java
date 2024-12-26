package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import hospital.domain.AuthInfoDTO;
import hospital.mapper.AutoMapper;
import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	@Autowired
	AutoMapper autoMapper;
	
	@ModelAttribute("userNum")
	public String userNum(HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		
		// userNum = autoMapper.userNum(auth.getUserId());으로 하면
		// 인덱스에서 auth가 없는다고 404? 그런 창이 뜬다.
		
		return auth != null ? autoMapper.userNum(auth.getUserId()) : null;
		
	}
}
