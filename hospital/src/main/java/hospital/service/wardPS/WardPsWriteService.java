package hospital.service.wardPS;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.command.WardPsCommand;
import hospital.domain.WardPsDTO;
import hospital.mapper.WardPsMapper;

@Service
public class WardPsWriteService {
   
   @Autowired
   WardPsMapper wardPsMapper;
   public void execute(WardPsCommand wardPsCommand) {
      WardPsDTO dto = new WardPsDTO();
      BeanUtils.copyProperties(wardPsCommand, dto);
      wardPsMapper.wardPsWrite(dto);
   }

}
