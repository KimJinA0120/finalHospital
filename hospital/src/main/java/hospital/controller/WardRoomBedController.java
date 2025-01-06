package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hospital.command.BedCommand;
import hospital.command.RoomCommand;
import hospital.command.WardCommand;
import hospital.service.WardRoomBed.BedListService;
import hospital.service.WardRoomBed.BedWriteService;
import hospital.service.WardRoomBed.EmerBedListService;
import hospital.service.WardRoomBed.RoomListService;
import hospital.service.WardRoomBed.RoomWriteService;
import hospital.service.WardRoomBed.WardListService;
import hospital.service.WardRoomBed.WardWriteService;

@Controller
@RequestMapping("WardRoomBed")
public class WardRoomBedController {
	@Autowired
	BedListService bedListService;
	@Autowired
	RoomListService roomListService;
	@Autowired
	EmerBedListService emerBedListService;
	@Autowired
	WardListService wardListService;
	@Autowired
	WardWriteService wardWriteService;
	@Autowired
	RoomWriteService roomWriteService;
	@Autowired
	BedWriteService bedWriteService;
	
	@PostMapping("bedRegist")
	public String bedRegist(BedCommand bedCommand) {
		bedWriteService.execute(bedCommand);
		return "thymeleaf/wardRoomBed/bedList";
	}
	@RequestMapping("bedForm")
	public String bedForm() {
		return "thymeleaf/wardRoomBed/bedForm";
	}
	
	@PostMapping("roomRegist")
	public String roomRegist(RoomCommand roomCommand) {
		roomWriteService.execute(roomCommand);
		return "thymeleaf/wardRoomBed/roomList";
	}
	@RequestMapping("roomForm")
	public String roomForm() {
		return "thymeleaf/wardRoomBed/roomForm";
	}
	@PostMapping("wardRegist")
	public String wardRegist(WardCommand wardCommand) {
		wardWriteService.execute(wardCommand);
		return "thymeleaf/wardRoomBed/wardList";
	}
	@RequestMapping("wardForm")
	public String wardForm() {
		return "thymeleaf/wardRoomBed/wardForm";
	}
	@GetMapping("WardList")
	public String wardList(String wardNum, Model model) {
		wardListService.execute(wardNum, model);
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
