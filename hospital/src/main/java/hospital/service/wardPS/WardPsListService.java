package hospital.service.wardPS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hospital.domain.WardPsDTO;
import hospital.mapper.WardPsMapper;

@Service
public class WardPsListService {
   
   @Autowired
   WardPsMapper wardPsMapper;
   public void execute(Model model) {
      List<WardPsDTO> list = wardPsMapper.selectList();
      model.addAttribute("list", list);
   }

}

