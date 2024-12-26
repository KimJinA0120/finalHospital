package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("EmergencyDTO")
public class EmergencyDTO {
	String emerBedNum;
	String wardNum;
	String emerBedStatus;
}
