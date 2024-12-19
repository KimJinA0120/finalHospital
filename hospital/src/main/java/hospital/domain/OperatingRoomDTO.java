package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("operatingRoom")
public class OperatingRoomDTO {
	String operatingRoomNum;
	String operatingRoomLocation;
}
