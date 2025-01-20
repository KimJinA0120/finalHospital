package hospital.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("callDel")
@Data
public class CallPsDeleteDTO {
	String delCallNum;
	String delPsNum;
	String delCause;
	Date callDate;
}
