package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.service.WardRoomBed.BedListService;
import hospital.service.WardRoomBed.EmerBedListService;
import hospital.service.WardRoomBed.RoomListService;

@Controller
@RequestMapping("WardRoomBed")
public class WardRoomBedController {
	@Autowired
	BedListService bedListService;
	@Autowired
	RoomListService roomListService;
	@Autowired
	EmerBedListService emerBedListService;
	
	@RequestMapping("WardList")
	public String wardList() {
		return "thymeleaf/wardRoomBed/wardList";
	}
	
	@GetMapping("bedList")
	public String bedList(Model model) {
		bedListService.execute(model);
		return "thymeleaf/wardRoomBed/bedList";
	}
	
	@GetMapping("roomList")
	public String roomList(String wardNum, Model model) {
		roomListService.execute(model, wardNum);
		return "thymeleaf/wardRoomBed/roomList";
	}
	
	@GetMapping("emerBedList")
	public String emergencyList(Model model) {
		emerBedListService.execute(model);
		return "thymeleaf/wardRoomBed/emerBedList";
	}
	

}
