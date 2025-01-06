package hospital.command;

import lombok.Data;

@Data
public class BedCommand {
	String bedNum;
	String roomNum;
	String bedStatus;

}
