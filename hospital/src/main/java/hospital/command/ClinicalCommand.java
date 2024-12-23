package hospital.command;

import lombok.Data;

@Data
public class ClinicalCommand {
	String inspectionNum;
	String clinicalNum;
	String clinicalContent;
	String empNum;
}
