package hospital.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PatientCommand {
	String patientNum ;
    String patientName ;
    
    @Pattern(regexp = "^(?=.*?[0-9]).{6}$", 
			 message = "주민등록번호 앞자리 숫자 6자")
    String patientJuminF;
    @Pattern(regexp = "^(?=.*?[0-9]).{7}$", 
			 message = "주민등록번호 뒷자리 숫자 7자")
    String patientJuminB;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date patientBirth ;
    String patientGender;
    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[0-9]).{6,}$", 
			 message = "소문자,숫자 포함하여 6글자 이상")
    String patientId ;
    @Pattern(regexp = "^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-+]).{8,}$", 
			 message = "대소문자, 숫자, 특수문자 모두 포함하여 8자 이상")
    String patientPw ;
    String patientPwCon;
    String patientAddr ;
    String patientAddrDetail ;
    Integer patientPost;
    String patientEmail ;
    @Pattern(regexp = "^(?=.*?[0-9]).{9,11}$", 
			 message = "'-' 제외 숫자 9~11자")
    String patientPhone ;
}
