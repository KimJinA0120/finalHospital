package hospital.service.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.FindDTO;
import hospital.mapper.FindMapper;

@Service
public class FindIdService {
	@Autowired
	FindMapper findMapper;

	public void findPatientId(String userName, String userPhone, String userEmail, Model model) {
		FindDTO dto=new FindDTO();
		dto.setUserEmail(userEmail);
		dto.setUserName(userName);
		dto.setUserPhone(userPhone);
		String userId=findMapper.findPatientId(dto);
		String message;
		if(userId !=null) {
			message="고객님의 아이디는 "+userId+"입니다.";
		}else message="일치하는 정보가 없습니다. "
				+ "확인 후 다시 시도하여주십시오.";
		model.addAttribute("message", message);
		//model.addAttribute("<br/>", "/n");
	}

	public void findEmpId(String userName, String userPhone, String userEmail, Model model) {
		FindDTO dto=new FindDTO();
		dto.setUserEmail(userEmail);
		dto.setUserName(userName);
		dto.setUserPhone(userPhone);
		String userId=findMapper.findEmpId(dto);
		String message;
		if(userId !=null) {
			message="아이디는 "+userId+"입니다.";
		}else message="일치하는 정보가 없습니다. "
				+ "확인 후 다시 시도하여주십시오.";
		model.addAttribute("message", message);
		model.addAttribute("userId", userId);
		
		
	}
	
}
