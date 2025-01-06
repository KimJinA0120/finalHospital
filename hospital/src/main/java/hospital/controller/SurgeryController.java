package hospital.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hospital.command.SurgeryAppointmentCommand;
import hospital.command.SurgeryCommand;
import hospital.service.AutoNumService;
import hospital.service.surgery.OperatingRoomListService;
import hospital.service.surgery.ScheduleService;
import hospital.service.surgery.SurApsDeleteService;
import hospital.service.surgery.SurgeryAppointmentDeleteService;
import hospital.service.surgery.SurgeryAppointmentDetailService;
import hospital.service.surgery.SurgeryAppointmentListService;
import hospital.service.surgery.SurgeryAppointmentService;
import hospital.service.surgery.SurgeryAppointmentUpdateService;
import hospital.service.surgery.SurgeryDetailService;
import hospital.service.surgery.SurgeryListService;
import hospital.service.surgery.SurgerySchedulerService;
import hospital.service.surgery.SurgeryUpdateService;
import hospital.service.surgery.SurgeryWriteService;

@Controller
@RequestMapping("surgery")
public class SurgeryController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	SurgeryAppointmentService surgeryAppointmentService;
	@Autowired
	SurgeryAppointmentListService surgeryAppointmentListService;
	@Autowired
	SurgeryAppointmentDetailService surgeryAppointmentDetailService;
	@Autowired
	SurgeryAppointmentUpdateService surgeryAppointmentUpdateService;
	@Autowired
	SurgeryAppointmentDeleteService surgeryAppointmentDeleteService;
	@Autowired
	SurgeryWriteService surgeryWriteService;
	@Autowired
	SurgeryListService surgeryListService;
	@Autowired
	OperatingRoomListService operatingRoomListService;
	@Autowired
	SurgeryDetailService surgeryDetailService;
	@Autowired
	SurgeryUpdateService surgeryUpdateService;
	@Autowired
	SurApsDeleteService surApsDeleteService;
	@Autowired
	SurgerySchedulerService surgerySchedulerService;
	
	
	// 수술 예약
	@GetMapping("surgeryAppointmentList") // 수술예약 리스트
	public String surgeryAppointmentList(
			@RequestParam(value="page", required = false, defaultValue = "1") int page,
			@RequestParam(value="searchWord", required = false) String searchWord,
			@RequestParam(value="kind", required = false) String kind,
			Model model) {
		surgeryAppointmentListService.execute(page, searchWord, kind, model);
		return "thymeleaf/surgery/surgeryAppointmentList";
	}
	@PostMapping("surApsDelete") // 리스트에서 수술예약 선택 삭제
	public String surApsDelete(
			@RequestParam(value="nums") String surApsDel []) {
		surApsDeleteService.execute(surApsDel);
		return "redirect:surgeryAppointmentList";
	}
	@GetMapping("surgeryAppointment") // 수술예약 화면
	public String surgeryAppointment(Model model) {
		String autoNum = autoNumService.execute("SurgeryAp_", 11, "SURGERY_APPOINTMENT_NUM", "surgery_appointment");
		model.addAttribute("autoNum", autoNum);
		return "thymeleaf/surgery/surgeryAppointment";
	}
	@PostMapping("surgeryAppointment") // 수술예약
	public String surgeryAppointment(SurgeryAppointmentCommand surgeryAppintmentCommand) {
		surgeryAppointmentService.execute(surgeryAppintmentCommand);
		return "redirect:surgeryScheduler";
	}
	@GetMapping("surgeryAppointmentDetail") // 수술예약 상세
	public String surgeryAppointmentDetail(String surgeryAppointmentNum, Model model) {
		surgeryAppointmentDetailService.execute(surgeryAppointmentNum, model);
		return "thymeleaf/surgery/surgeryAppointmentDetail";
	}
	@GetMapping("surgeryAppointmentModify") // 수술예약 수정화면
	public String surgeryAppointmentModify(String surgeryAppointmentNum, Model model) {
		surgeryAppointmentDetailService.execute(surgeryAppointmentNum, model);
		return "thymeleaf/surgery/surgeryAppointmentModify";
	}
	@PostMapping("surgeryAppointmentModify") // 수술예약 수정
	public String surgeryAppointmentModify(SurgeryAppointmentCommand surgeryAppointmentCommand) {
		surgeryAppointmentUpdateService.execute(surgeryAppointmentCommand);
		return "redirect:surgeryAppointmentDetail?surgeryAppointmentNum="+surgeryAppointmentCommand.getSurgeryAppointmentNum();
	}
	@GetMapping("surgeryAppointmentDelete") // 수술예약 삭제
	public String surgeryAppointmentDelete(String surgeryAppointmentNum) {
		surgeryAppointmentDeleteService.execute(surgeryAppointmentNum);
		return "redirect:surgeryAppointmentList";
	}
	
	
	// 수술결과 기록
	@GetMapping("surgeryList") // 수술기록 리스트
	public String surgeryList(Model model) {
		surgeryListService.execute(model);
		return "thymeleaf/surgery/surgeryList";
	}
	@GetMapping("surgeryWrite") // 수술기록 화면
	public String surgeryWrite(String surgeryAppointmentNum, Model model) {
		String autoNum = autoNumService.execute("Surgery_", 9, "SURGERY_NUM", "surgery");
		model.addAttribute("autoNum", autoNum);
		if(surgeryAppointmentNum != null) {
			model.addAttribute("surgeryAppointmentNum", surgeryAppointmentNum);
		}
		return "thymeleaf/surgery/surgeryWrite";
	}
	@PostMapping("surgeryWrite") // 수술 기록하기
	public String surgeryWrite(SurgeryCommand surgeryCommand) {
		surgeryWriteService.execute(surgeryCommand);
		return "200";
	}
	@GetMapping("surgeryDetail") // 수술 상세보기
	public String surgeryDetail(String surgeryNum, Model model) {
		surgeryDetailService.execute(surgeryNum, model);
		return "thymeleaf/surgery/surgeryDetail";
	}
	@GetMapping("surgeryModify")  // 수술내용 수정화면
	public String surgeryModify(String surgeryNum, Model model) {
		surgeryDetailService.execute(surgeryNum, model);
		return "thymeleaf/surgery/surgeryModify";
	}
	@PostMapping("surgeryUpdate")
	public String surgeryUpdate(SurgeryCommand surgeryCommand) {
		surgeryUpdateService.execute(surgeryCommand);
		return "redirect:surgeryDetail?surgeryNum="+surgeryCommand.getSurgeryNum();
	}
	
	// 수술실 찾기
	@GetMapping("operatingRoomList")
	public String operatingRoomList(Model model) {
		operatingRoomListService.execute(model);
		return "thymeleaf/surgery/operatingRoomList";
	}
	//수술예약 찾기
	@GetMapping("surApList")
	public String surApList(
			@RequestParam(value="page", required= false, defaultValue = "1") int page, 
			@RequestParam(value="searchWord", required= false) String searchWord, 
			@RequestParam(value="kind", required=false) String kind,
			Model model) {
		surgeryAppointmentListService.execute(page, searchWord, kind, model);
		return "thymeleaf/surgery/surApList";
	}
	
	//수술스케쥴러 이동
	@GetMapping("surgeryScheduler")
	public String surgeryScheduler() {
		return "thymeleaf/surgery/surgeryScheduler";
	}
	
	
	//DB데이터 스케쥴러에 불러오기
	private static final Logger log = LoggerFactory.getLogger(SurgeryController.class);
	
	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping("surScheduler")
	@ResponseBody
	public List<Map<String, Object>> surScheduler(){
		List jsonArr = new ArrayList();
		jsonArr = surgerySchedulerService.execute();
		log.info("jsonArrCheck: {}", jsonArr);
		return jsonArr;
	}
	
	//스케쥴러정보 받아와서 db수정하기
	@PostMapping("surScheduleUpdate")
	@ResponseBody
	public String surScheduleUpdate(@RequestBody List<Map<String, Object>> events, SurgeryAppointmentCommand surgeryAppointmentCommand) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		
		for(int i = 0; i < events.size(); i++) {
			surgeryAppointmentCommand.setAempNum((String) events.get(i).get("aempNum"));
			surgeryAppointmentCommand.setOperatingRoomNum((String) events.get(i).get("operatingRoomNum"));
			surgeryAppointmentCommand.setSempNum((String) events.get(i).get("sempNum"));
			surgeryAppointmentCommand.setSurgeryAppointmentNum((String) events.get(i).get("surgeryAppointmentNum"));
			surgeryAppointmentCommand.setSurgeryName((String) events.get(i).get("title"));
			surgeryAppointmentCommand.setWardprescriptNum((String) events.get(i).get("wardprescriptNum"));
			
			// 스케쥴날짜(Object) -> string으로 변화 -> date로 변환 후 command에 삽입
			String surgeryDateString = (String) events.get(i).get("start");
			String surgeryEndDateString = (String) events.get(i).get("end");
			try {
				LocalDateTime surgeryDate = LocalDateTime.parse(surgeryDateString);
				surgeryAppointmentCommand.setSurgeryDate(surgeryDate);
				
				LocalDateTime surgeryEndDate = LocalDateTime.parse(surgeryEndDateString);
				surgeryAppointmentCommand.setSurgeryEndDate(surgeryEndDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			surgeryAppointmentUpdateService.execute(surgeryAppointmentCommand);
		}
		return "thymeleaf/surgery/surgeryScheduler";
	}
	
	
}
