package hospital.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckMapper {

	public Integer checkId(String userId);

	public Integer checkEmail(String userEmail);

}
