package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import hospital.service.hosPatient.MyPatientListService;
import hospital.service.hosPatient.PatientPreScript;
import hospital.service.hosPatient.SearchHospService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HosPatientController {

	@Autowired
	SearchHospService searchHospService;

	@GetMapping("{baseId}/hosPatList")
	public String hosPatInfoList(@PathVariable("baseId") String baseId,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "searchWord", required = false) String searchWord,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "roomN", required = false) String roomN, Model model) {
		searchHospService.execute(page, searchWord, location, roomN, model);
		return "thymeleaf/hosPatient/hosPatInfoList";
	}

	/// 내 담당환자 목록
	@Autowired
	MyPatientListService myPatientListService;

	@GetMapping("{baseId}/myPatientList")
	public String myPatientList(HttpServletRequest request, String empNum, Model model) {

		String cont = request.getRequestURI().split("/")[1];
		if (cont.equals("nursing")) {
			myPatientListService.execute("nur_num", empNum, model);
		} else if (cont.equals("wardPS")) {
			myPatientListService.execute("doc_num", empNum, model);
		}

		return "thymeleaf/hosPatient/myPatientList";
	}

	@Autowired
	PatientPreScript patientPreScript;
	@GetMapping("{baseId}/patientwardPsList")
	public String patientwardPsList(String hospNum, Model model) {
		patientPreScript.execute(hospNum, model);
		return "thymeleaf/hosPatient/hosPatientPSinfo";
	}

}
