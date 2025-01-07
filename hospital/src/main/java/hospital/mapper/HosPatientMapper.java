package hospital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hospital.domain.HosPatientDTO;
import hospital.domain.RoomDTO;
import hospital.domain.SEPhosPatientDTO;

@Mapper
public interface HosPatientMapper {

	public List<HosPatientDTO> searchList(SEPhosPatientDTO hpSEP);

	public Integer searchCount();

	public List<HosPatientDTO> searchWardPs(SEPhosPatientDTO hpSEP);

	public List<RoomDTO> selectDropDown(String location);

	public Integer nursingCount();

	public List<HosPatientDTO> selectPatPs(String hospNum);

	public HosPatientDTO wardPatInfo(String hospNum);

	public List<HosPatientDTO> myWardPatient(@Param(value = "colNm") String colNm
											,@Param(value = "empNum") String empNum);

	public String empName(String empNum);


}
