package hospital.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hospital.domain.QnADTO;

@Repository
public class QnARepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "qnaMapperSql";
	String statement;
	
	public Integer qnaInsert(QnADTO dto) {
		statement = namespace + ".qnaInsert";
		return sqlSession.insert(statement, dto);
	}
	
	public List<QnADTO> qnaList(String qnaNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qnaNum", qnaNum);
		statement = namespace + ".qnaList";
		return sqlSession.selectList(statement, map);
	}
	
	public Integer qnaDelete(String qnaNum) {
		statement = namespace + ".qnaDelete";
		return sqlSession.delete(statement, qnaNum);
	}
	public Integer qnaUpdate(QnADTO dto) {
		statement = namespace + ".qnaUpdate";
		return sqlSession.update(statement, dto);
	}
	public Integer qnaAnswerUpdate(QnADTO dto) {
		statement = namespace + ".qnaAnswerUpdate";
		return sqlSession.update(statement, dto);
	}
}
