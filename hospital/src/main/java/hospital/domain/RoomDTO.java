package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("RoomDTO")
public class RoomDTO {
	String roomNum;
	String wardNum;
	Integer roomLocation;

}
