package hospital.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hospital.domain.StockDTO;

@Repository
public class StockRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "stockMapperSql";
	String statement;
	
	public Integer stockInsert(StockDTO dto) {
		statement = namespace + ".stockInsert";
		return sqlSession.insert(statement, dto);
	}
	  
}
