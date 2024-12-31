package hospital.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PatientCommand {
	String patientNum ;
    String patientName ;
    String patientJuminF;
    String patientJuminB;
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
