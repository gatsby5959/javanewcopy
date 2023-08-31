package boardJDBC;

import java.util.List;

public interface DAO {

	int insert(BoardVO p);

	List<BoardVO> selectList();

	BoardVO selectOne(int bno);

	int readCount(int bno);

	int update(BoardVO bovo);

	int delete(int bno);

}
