package hospital.command;

import lombok.Data;

@Data
public class DoctorCommand {
	String empNum;
	String empName;
	String medicalSubject; //sectionName와 같음
	String medicalRoomLocation;
}
