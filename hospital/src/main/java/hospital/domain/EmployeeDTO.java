package hospital.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Alias("employeeDTO")
public class EmployeeDTO {
 	String empNum ;
    String empName ;
    String empId ;
    String empPw ;
    String empPhone ;
    String empJumin ;
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
}
