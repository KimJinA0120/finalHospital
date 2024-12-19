package hospital.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("patientDTO")
public class PatientDTO {
	String patientNum ;
    String patientName ;
    String patientJumin;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date patientBirth ;
    String patientGender;
    String patientId ;
    String patientPw ;
    String patientPwCon;
    String patientAddr ;
    String patientAddrDetail ;
    Integer patientPost;
    String patientEmail ;
    String patientPhone ;
}
