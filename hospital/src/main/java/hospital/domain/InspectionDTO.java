package hospital.domain;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("inspection")
public class InspectionDTO {
	String inspectionNum;
	String inspectionName;
	LocalDateTime inspectionDate;
	String wardprescriptNum;
	String medicalNum;
	String inspectionStatus;
}
