package hospital.command;

import lombok.Data;

@Data
public class EmergencyCommand {
	String emerBedNum;
	String wardNum;
	String emerBedStatus;
}
