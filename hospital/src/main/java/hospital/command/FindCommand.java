package hospital.command;

import lombok.Data;

@Data
public class FindCommand {
	String userId;
	String userPhone;
	String userName;
	String userEmail;
}
