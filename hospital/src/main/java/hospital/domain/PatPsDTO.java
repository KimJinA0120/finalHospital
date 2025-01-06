package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("patPS")
@Data
public class PatPsDTO {
	String wardPsNum;
	String diagName;
	String nursingNum;
}
