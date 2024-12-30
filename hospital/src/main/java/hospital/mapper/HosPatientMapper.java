package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hospital.domain.HosPatientDTO;
import hospital.domain.RoomDTO;
import hospital.domain.SEPhosPatientDTO;
import hospital.domain.StartEndPageDTO;

@Mapper
public interface HosPatientMapper {

	public List<HosPatientDTO> searchList(SEPhosPatientDTO hpSEP);

	public Integer searchCount();

	public List<HosPatientDTO> searchWardPs(StartEndPageDTO sepDTO);

	public List<RoomDTO> selectDropDown(String location);

}
