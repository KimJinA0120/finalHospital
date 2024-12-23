package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("sectionDTO")
public class SectionDTO {
	String sectionNum;
	String departmentNum;
	String sectionName;
	String sectionPhone;
	String sectionLocation;
	String departmentName;
}
