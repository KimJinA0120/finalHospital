package hospital.command;

import lombok.Data;

@Data
public class RadiationCommand {
	String radiationNum;
	String inspectionNum;
	String empNum;
	String decodeContent;
}
