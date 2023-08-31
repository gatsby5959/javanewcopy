package JDBC;

import java.util.List;

public class ProductServiceImpl implements Service {

	
	private DAO dao; //인터페이스
	public ProductServiceImpl() {
		dao = new ProductDAOImpl(); //구현체
	}
	
	@Override
	public int register(Product p) {
		// 실제 구현 영역
		System.out.println("register_service success!!");
		//dao에서 사용되는 메서드명은 DB구문와 비슷하게 하는것이일반적
		return dao.insert(p);
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		System.out.println("list_service success!!");
		return dao.selectList();
	}

	@Override
	public Product detail(int pno) {
		// TODO Auto-generated method stub
		System.out.println("detail success!!");
		return dao.selectOne(pno);
	}

	@Override
	public int update(Product p) {
		// TODO Auto-generated method stub
		System.out.println("update_service success!!");
		return dao.update(p);
	}

	@Override
	public int delete(int pno) {
		// TODO Auto-generated method stub
		System.out.println("delete_service success!!");
		return dao.delete(pno);
	}

}
