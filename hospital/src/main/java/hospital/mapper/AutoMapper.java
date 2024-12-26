package hospital.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AutoMapper {

	public String selectNum(@Param("sep") String sep
							, @Param("len") int len
							, @Param("col_name") String col_name
							, @Param("table_name") String table_name);

	public String userNum(String userId);

}
