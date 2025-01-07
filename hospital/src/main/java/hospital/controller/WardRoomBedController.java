package hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hospital.command.BedCommand;
import hospital.command.EmergencyCommand;
import hospital.command.RoomCommand;
import hospital.command.WardCommand;
import hospital.service.WardRoomBed.AllBedListService;
import hospital.service.WardRoomBed.AllRoomListService;
import hospital.service.WardRoomBed.BedListService;
import hospital.service.WardRoomBed.BedWriteService;
import hospital.service.WardRoomBed.BedsDeleteService;
import hospital.service.WardRoomBed.EmerBedListService;
import hospital.service.WardRoomBed.EmerBedWriteService;
import hospital.service.WardRoomBed.EmerBedsDeleteService;
import hospital.service.WardRoomBed.RoomListService;
import hospital.service.WardRoomBed.RoomWriteService;
import hospital.service.WardRoomBed.RoomsDeleteService;
import hospital.service.WardRoomBed.WardListService;
import hospital.service.WardRoomBed.WardWriteService;
import hospital.service.WardRoomBed.WardsDeleteService;

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
	@Autowired
	AllRoomListService allRoomListService;
	@Autowired
	AllBedListService allBedListService;
	@Autowired
	WardsDeleteService wardsDeleteService;
	@Autowired
	RoomsDeleteService roomsDeleteService;
	@Autowired
	BedsDeleteService bedsDeleteService;
	@Autowired
	EmerBedsDeleteService emerBedsDeleteService;
	@Autowired
	EmerBedWriteService emerBedWriteService;
	
	@PostMapping("emerbedsDelete")
	public String emerbedsDelete(@RequestParam(value="nums") String emerBedDels[]) {
		emerBedsDeleteService.execute(emerBedDels);
		return "redirect:allBedList";
	}
	
	@PostMapping("bedsDelete")
	public String bedsDelete(@RequestParam(value="nums") String bedDels[]) {
		bedsDeleteService.execute(bedDels);
		return "redirect:allBedList";
	}
	
	@PostMapping("roomsDelete")
	public String roomsDelete(@RequestParam(value="nums") String roomDels[]) {
		roomsDeleteService.execute(roomDels);
		return "redirect:WardList";
	}
	
	@PostMapping("wardsDelete")
	public String wardsDelete(@RequestParam(value="nums") String wardDels[]) {
		wardsDeleteService.execute(wardDels);
		return "redirect:WardList";
	}
	
	@PostMapping("emerBedRegist")
	public String emerBedRegist(EmergencyCommand emergencyCommand) {
		emerBedWriteService.execute(emergencyCommand);
		return "redirect:allBedList";
	}
	@RequestMapping("emerBedForm")
	public String emerBedForm() {
		return "thymeleaf/wardRoomBed/emerBedForm";
	}
	
	@PostMapping("bedRegist")
	public String bedRegist(BedCommand bedCommand) {
		bedWriteService.execute(bedCommand);
		return "redirect:allBedList";
	}
	@RequestMapping("bedForm")
	public String bedForm() {
		return "thymeleaf/wardRoomBed/bedForm";
	}
	@PostMapping("roomRegist")
	public String roomRegist(RoomCommand roomCommand) {
		roomWriteService.execute(roomCommand);
		return "redirect:WardList";
	}
	@RequestMapping("roomForm")
	public String roomForm() {
		return "thymeleaf/wardRoomBed/roomForm";
	}
	@PostMapping("wardRegist")
	public String wardRegist(WardCommand wardCommand) {
		wardWriteService.execute(wardCommand);
		return "redirect:WardList";
	}
	@GetMapping("wardForm")
	public String wardForm(Model model) {
		return "thymeleaf/wardRoomBed/wardForm";
	}
	@GetMapping("WardList")
	public String wardList(Model model) {
		wardListService.execute(model);
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
	@GetMapping("roomsearch")
	public String roomsearch(Model model) {
		allRoomListService.execute(model);
		return "thymeleaf/wardRoomBed/roomsearch";
	}
	@GetMapping("wardsearch")
	public String wardsearch(Model model) {
		wardListService.execute(model);
		return "thymeleaf/wardRoomBed/wardsearch";
	}
	@GetMapping("allBedList")
	public String allBedList(Model model) {
		allBedListService.execute(model);
		return "thymeleaf/wardRoomBed/allBedList";
	}

}
