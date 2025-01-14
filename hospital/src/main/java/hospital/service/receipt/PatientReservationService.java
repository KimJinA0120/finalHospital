package hospital.service.receipt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.AuthInfoDTO;
import hospital.domain.ReceiptDTO;
import hospital.mapper.PatientMapper;
import hospital.mapper.ReceiptMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class PatientReservationService {
	@Autowired
	PatientMapper patientMapper;
	@Autowired
	ReceiptMapper receiptMapper;
	
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String patientNum = patientMapper.patientNumSelect(auth.getUserId());
		List<ReceiptDTO> list = receiptMapper.reservationSelectList(patientNum);
		model.addAttribute("list", list);
	}

}
