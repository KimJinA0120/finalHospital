package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("hosPatient") // 입원환자정보
@Data
public class HosPatientDTO {
	String patientName; // 환자이름
	Integer roomLoc; // 병실위치=호수
	String roomNum; // 병실번호
	String wardNum;
	HospitalizationDTO hospitalizationDTO; // 입원정보
	WardPsDTO wardPsDTO;
	NursingDTO nursingDTO;
}
