package hospital.service.surgery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.domain.SurgeryAppointmentDTO;
import hospital.mapper.SurgeryMapper;

@Service
public class SurgerySchedulerService {
	@Autowired
	SurgeryMapper surgeryMapper;
	@Autowired
	ScheduleService scheduleService;
	public List<Map<String, Object>> execute() {
		List<SurgeryAppointmentDTO> list = scheduleService.execute();
		
		List jsonArr = new ArrayList<>();
		
		Map<String, Object> hash = new HashMap<String, Object>();
		
		for(int i=0; i < list.size(); i++) {
			hash.put("aempNum", list.get(i).getAempNum());
			hash.put("sempNum", list.get(i).getSempNum());
			hash.put("operatingRoomNum", list.get(i).getOperatingRoomNum());
			hash.put("surgeryAppointmentNum", list.get(i).getSurgeryAppointmentNum());
			hash.put("title", list.get(i).getSurgeryName());
			hash.put("wardprescriptNum", list.get(i).getWardprescriptNum());
			hash.put("start", list.get(i).getSurgeryDate());
			hash.put("end", list.get(i).getSurgeryEndDate());
			hash.put("surgeryStatus", list.get(i).getSurgeryStatus());
			if(list.get(i).getOperatingRoomNum().equals("surroom_1")) {
				hash.put("color", "#BCF5A9");
			}else if(list.get(i).getOperatingRoomNum().equals("surroom_2")) {
				hash.put("color", "#A9F5F2");
			}else if(list.get(i).getOperatingRoomNum().equals("surroom_3")) {
				hash.put("color", "#F5A9E1");
			}else if(list.get(i).getOperatingRoomNum().equals("surroom_4")) {
				hash.put("color", "#E6E6E6");
			}else if(list.get(i).getOperatingRoomNum().equals("surroom_5")) {
				hash.put("color", "#F5D0A9");
			}else {
				hash.put("color", "#F2F5A9");
			}
			
			System.out.println(list.get(i).getSurgeryName());
			jsonArr.add(hash);
			hash = new HashMap<String, Object>();
		}
		return jsonArr;
	}
}
