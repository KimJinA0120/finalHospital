package hospital.command;

import java.util.Date;

import lombok.Data;

@Data
public class CallPsDeleteCommand {
	String delCallNum;
	String delPsNum;
	String delCaller;
	String delCause;
	Date callDate;
}
