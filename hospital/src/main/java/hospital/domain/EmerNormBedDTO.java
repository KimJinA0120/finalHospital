package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("EmerNormBedDTO")
public class EmerNormBedDTO {
	BedDTO bedDTO;
	EmergencyDTO emergencyDTO;
}
