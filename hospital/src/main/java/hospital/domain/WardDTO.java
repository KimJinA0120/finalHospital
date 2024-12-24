package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("WardDTO")
public class WardDTO {
	String wardNum;
	String wardLocation;

}
