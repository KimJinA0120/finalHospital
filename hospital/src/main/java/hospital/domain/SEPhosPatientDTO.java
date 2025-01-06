package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;

@Alias("hpSEP")
@Data
@AllArgsConstructor
public class SEPhosPatientDTO {
	int startRow;
	int endRow;
	String searchWord;
	
	String location;
	String roomN;
}
