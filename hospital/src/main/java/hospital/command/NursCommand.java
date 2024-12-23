package hospital.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class NursCommand {
	String nursingNum;
	String wardPsNum;
	String empNum;
	String handleNurs;
	String nursingCon;
	String hanPres;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date presDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date inputDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date updateDate;
}
