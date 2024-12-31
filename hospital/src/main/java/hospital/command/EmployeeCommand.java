package hospital.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeeCommand {
 	String empNum ;
    String empName ;
    String empId ;
    String empPw ;
    String empPwCon;
    String empPhone ;
    String empJuminF ;
    String empJuminB ;
    String empGender ;
    String empAddr ;
    String empAddrDetail ;
    Integer empPost ;
    String position ;
    String empEmail ;
    String sectionNum ;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date empHiredate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date empBirth;
    
    String jobCategory;
    //String departmentName;
}
