package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("radiation")
public class RadiationDTO {
	String radiationNum;
	String inspectionNum;
	String empNum;
	String decodeContent;
}
