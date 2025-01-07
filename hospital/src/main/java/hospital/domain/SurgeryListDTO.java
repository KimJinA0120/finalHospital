package hospital.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("surgeryList")
public class SurgeryListDTO {
	SurgeryDTO surgeryDTO;
	SurgeryAppointmentDTO surgeryAppointmentDTO;
}
