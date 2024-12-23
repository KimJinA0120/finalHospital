package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("doctorDTO")
@Data
public class DoctorDTO { //만약 등록하는 직원이 의사라면 의사가 자동으로 등록되게 한다.
	String empNum;
	String empName;
	String medicalSubject; //sectionName와 같음
	String medicalRoomLocation;
}
