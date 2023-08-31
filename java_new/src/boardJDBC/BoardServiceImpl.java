package boardJDBC;

import java.util.List;

public class BoardServiceImpl implements Service {

	private DAO dao;
	
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bovo) {
		// 실제 구현 영역
		System.out.println("register_service success!!");
		//dao에서 사용되는 메서드명은 DB구문와 비슷하게 하는것이일반적
		return dao.insert(bovo);
	}

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		System.out.println("list_service success!!");
		return dao.selectList();
	}

	@Override
	public BoardVO detail(int bno) {
		int isOK = dao.readCount(bno);
		System.out.println("detail success!!");
		return (isOK>0)?dao.selectOne(bno):null;
	}

	@Override
	public int update(BoardVO bovo) {
		System.out.println("update_service success!!");
		return dao.update(bovo);
	}

	@Override
	public int delete(int bno) {
		System.out.println("delete_service success!!");
		return dao.delete(bno);
	}
	
	
}
