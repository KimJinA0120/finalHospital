package hospital.command;

import lombok.Data;

@Data
public class RoomCommand {
	String roomNum;
	String wardNum;
	Integer roomLocation;
}
