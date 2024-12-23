package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.InspectionCommand;
import hospital.service.AutoNumService;
import hospital.service.inspection.InsepctionListService;
import hospital.service.inspection.InspectionDeleteService;
import hospital.service.inspection.InspectionDetailService;
import hospital.service.inspection.InspectionUpdateService;
import hospital.service.inspection.InspectionWriteService;

@Controller
@RequestMapping("inspection")
public class InspectionController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	InspectionWriteService inspectionWriteService;
	@Autowired
	InsepctionListService insepctionListService;
	@Autowired
	InspectionDetailService inspectionDetailService;
	@Autowired
	InspectionUpdateService inspectionUpdateService;
	@Autowired
	InspectionDeleteService inspectionDeleteService;
	
	@GetMapping("inspectionList") // 검사예약 리스트
	public String inspectionList(Model model) {
		insepctionListService.execute(model);
		return "thymeleaf/inspection/inspectionList";
	}
	@GetMapping("inspectionWrite") // 검사예약 화면
	public String inspectionWrite(Model model) {
		String autoNum = autoNumService.execute("Inspect_", 9, "INSPECTION_NUM", "inspection");
		model.addAttribute("autoNum", autoNum);
		return "thymeleaf/inspection/inspectionWrite";
	}
	@PostMapping("inspectionWrite") // 검사예약하기
	public String inspectionWrite(InspectionCommand inspectionCommand) {
		inspectionWriteService.execute(inspectionCommand);
		return "redirect:inspectionList";
	}
	@GetMapping("inspectionDetail") // 검사예약 상세보기
	public String inspectionDetail(String inspectionNum, Model model) {
		inspectionDetailService.execute(inspectionNum, model);
		return "thymeleaf/inspection/inspectionDetail";
	}
	@GetMapping("inspectionModify") // 검사예약 수정페이지
	public String inspectionModify(String inspectionNum, Model model) {
		inspectionDetailService.execute(inspectionNum, model);
		return "thymeleaf/inspection/inspectionModify";
	}
	@PostMapping("inspectionUpdate") // 검사예약 수정
	public String inspectionUpdate(InspectionCommand inspectionCommand) {
		inspectionUpdateService.execute(inspectionCommand);
		return "redirect:inspectionDetail?inspectionNum="+inspectionCommand.getInspectionNum();
	}
	@GetMapping("inspectionDelete")
	public String inspectionDelete(String inspectionNum) {
		inspectionDeleteService.execute(inspectionNum);
		return "redirect:inspectionList";
	}
}
