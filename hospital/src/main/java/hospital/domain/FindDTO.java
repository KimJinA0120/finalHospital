package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("findDTO")
public class FindDTO {
	String userId;
	String userPhone;
	String userName;
	String userEmail;
	String userPw;
	
}
