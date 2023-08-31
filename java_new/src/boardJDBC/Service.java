package boardJDBC;

import java.util.List;

public interface Service {

	int register(BoardVO p);

	List<BoardVO> list();

	BoardVO detail(int bno);

	int update(BoardVO bovo);

	int delete(int bno);

}
