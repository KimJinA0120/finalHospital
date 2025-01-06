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
			// surgery start / end 필요할듯?
			hash.put("aempNum", list.get(i).getAempNum());
			hash.put("sempNum", list.get(i).getSempNum());
			hash.put("operatingRoomNum", list.get(i).getOperatingRoomNum());
			hash.put("surgeryAppointmentNum", list.get(i).getSurgeryAppointmentNum());
			hash.put("title", list.get(i).getSurgeryName());
			hash.put("wardprescriptNum", list.get(i).getWardprescriptNum());
			hash.put("start", list.get(i).getSurgeryDate());
			hash.put("end", list.get(i).getSurgeryEndDate());
			
			System.out.println(list.get(i).getSurgeryName());
			jsonArr.add(hash);
			hash = new HashMap<String, Object>();
		}
		return jsonArr;
	}
}
