package hospital.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hospital.domain.AuthInfoDTO;
import hospital.domain.QnADTO;
import hospital.mapper.EmployeeMapper;
import hospital.mapper.PatientMapper;
import hospital.mapper.QnARepository;
import hospital.service.AutoNumService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("qna")
public class QnAController {
	@Autowired
	PatientMapper patientMapper;
	@Autowired
	QnARepository qnaRepository;
	@Autowired
	AutoNumService autoNumService;
	
	@RequestMapping("qnaList")	
	public String qnaList(Model model) {
		List<QnADTO> list = qnaRepository.qnaList(null);
		model.addAttribute("list", list);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/qna/qnaList";
	}
	
	@GetMapping("qnaForm")
	public String qnaForm(Model model) {
		String autoNum = autoNumService.execute("q_", 3, "qna_num", "qna");
		model.addAttribute("autoNum", autoNum);
		return "thymeleaf/qna/qnaForm";
	}
	@PostMapping("qnaForm")
	public void qnaForm(QnADTO qnaDTO, HttpSession session
						, HttpServletResponse response) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String patientNum = patientMapper.patientNumSelect(auth.getUserId());
		qnaDTO.setPatientNum(patientNum);
		qnaRepository.qnaInsert(qnaDTO);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			String str = "<script>";
			str += "window.self.close()";
			str += "</script>";
			out.print(str);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@RequestMapping("qnaDelete")
	public @ResponseBody void qnaDelte(String qnaNum) {
		qnaRepository.qnaDelete(qnaNum);
	}
	@GetMapping("qnaUpdate")
	public String qnaUpdate(String qnaNum, Model model) {
		List<QnADTO> list = qnaRepository.qnaList(qnaNum);
		model.addAttribute("list", list);
		return "thymeleaf/qna/qnaUpdate";
	}
	@PostMapping("qnaUpdate")
	@ResponseBody
	public void qnaUpdate(QnADTO qnaDTO, HttpServletResponse response) {
		qnaRepository.qnaUpdate(qnaDTO);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out;
		try {
		out = response.getWriter();
		String str = "<script>";
		str += "opener.parent.qna();";
		str += "window.self.close()";
		str += "</script>";
		out.print(str);
		out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("eqnaList")
	public String qnaAnswer(Model model) {
		List<QnADTO> list = qnaRepository.qnaList(null);
		model.addAttribute("list", list);
		return "thymeleaf/qna/eqnaList";
	}
	@GetMapping("qnaAnswer")
	public String qnaAnswer(String qnaNum, Model model) {
		List<QnADTO> list = qnaRepository.qnaList(qnaNum);
		model.addAttribute("list", list);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/qna/qnaAnswer";
	}
	@Autowired
	EmployeeMapper employeeMapper;
	@PostMapping("qnaAnswer")
	public String qnaAnswer(QnADTO qnaDTO, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empNum = employeeMapper.employeeNumSelect(auth.getUserId());
		qnaDTO.setEmpNum(empNum);
		qnaRepository.qnaAnswerUpdate(qnaDTO);
		return "redirect:eqnaList";
		
	}
}
