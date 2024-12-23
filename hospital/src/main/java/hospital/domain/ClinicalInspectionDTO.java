package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("clinicalInspect")
public class ClinicalInspectionDTO {
	ClinicalDTO clinicalDTO;
	InspectionDTO inspectionDTO;
}
