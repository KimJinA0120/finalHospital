package hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.mapper.AutoMapper;

@Service
public class AutoNumService {
	
	@Autowired
	AutoMapper autoMapper;
	
	public String execute(String sep, int len
						, String col_name, String table_name) {
		/// sep은 번호에 들어갈 단어 ex) emp_000 -> emp
		/// len은 sep의 총글자 수 + 1 ex) emp_ = 4글자 -> len = 4 + 1 = 5
		/// col_name은 컬럼명, table_name은 테이블명
		
		String autoNum
		= autoMapper.selectNum(sep, len, col_name, table_name);
		return autoNum;
	}
}
