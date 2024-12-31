package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("radiatInspect")
public class RadiatInspectionDTO {
	RadiationDTO radiationDTO;
	InspectionDTO inspectionDTO;
}
