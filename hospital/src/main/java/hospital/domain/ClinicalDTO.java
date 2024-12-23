package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("clinical")
public class ClinicalDTO {
	String inspectionNum;
	String clinicalNum;
	String clinicalContent;
	String empNum;
}
