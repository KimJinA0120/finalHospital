package hospital.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class WardPsCommand {
   
   String wardPsNum;
   String hospNum;
   String empNum;
   String diagName;
   String diagCont;
   String medicPres;
   String examPres;
   String hanPres;
   
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   Date inputDate;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   Date updateDate;
}
