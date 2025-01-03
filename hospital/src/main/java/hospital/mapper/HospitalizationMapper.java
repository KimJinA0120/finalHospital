package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.EmergencyPatientDTO;
import hospital.domain.HospitalizationDTO;
import hospital.domain.StartEndPageDTO;

@Mapper
public interface HospitalizationMapper {
	public void hospitalizationInsert(HospitalizationDTO dto);
	public List<HospitalizationDTO> hospitalizationSelectList(StartEndPageDTO sepDTO);
	public HospitalizationDTO hospitalizationSelectOne(String hospitalizationNum);
	public void hospitalizationUpdate(HospitalizationDTO dto);
	public void hospitalizationDelete(String hospitalizationNum);
	
	public List<HospitalizationDTO> emerHospitalizationSelectList(StartEndPageDTO sepDTO);
	public void emerInsert(EmergencyPatientDTO dto);
	public EmergencyPatientDTO emerSelectOne(String emerPatientNum);
	public void emerUpdate(EmergencyPatientDTO dto);
	public void emerDelete(String emerPatientNum);
	
	public int hospitalizatonCount(String searchWord);
	public int emerHospitalizatonCount(String searchWord);
	
	public void bedStatusUpdate(HospitalizationDTO dto);
	public void emerBedStatusUpdate(EmergencyPatientDTO dto);
	
	public void bedStatusNew(HospitalizationDTO dto);
	public void emerBedStatusNew(EmergencyPatientDTO dto);
	
	public void bedStatusDelUpdate(String hospitalizationNum);
	public void emerBedStatusDelUpdate(String emerPatientNum);
}
