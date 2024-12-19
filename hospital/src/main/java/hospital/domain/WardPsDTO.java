package hospital.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Alias("wardPS")
@Data
public class WardPsDTO {
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
