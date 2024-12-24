package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("BedDTO")
public class BedDTO {
	String bedNum;
	String roomNum;
	String bedStatus;

}
