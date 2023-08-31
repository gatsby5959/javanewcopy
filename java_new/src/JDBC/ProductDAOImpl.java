package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDAOImpl implements DAO {

	//DB연결
	private Connection conn;
	//sql 구문을 실행시키는 기능을 갖는 객체
	private PreparedStatement pst;
	private String query=""; //쿼리 구문 저장
	
	public ProductDAOImpl(){
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}
	
	//SQL 구문 처리
	
	@Override
	public int insert(Product p) {
		// TODO Auto-generated method stub
		System.out.println("insert DAO sucess!!");
		query ="insert into product(pname, price,madeby) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			
			//insert, update, delete => executeUpdate() return int   //0개 1개 2개 이런 느낌
			return pst.executeUpdate();
			//
			
		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Product> selectList() {
		System.out.println("list DAO sucess!!");
		query = "SELECT * FROM product ORDER BY pno DESC";
		List<Product> list = new ArrayList<>(); // 리스트가 인터페이스라서 생성해줘야함
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {//다음 값이 있나영?  있으면 뺴옴
				list.add(//pno, pname,price
						new Product(			
									rs.getInt("pno"),
									rs.getString("pname"),
									rs.getInt("price"),
									rs.getString("regdate"), //230831추가
									rs.getString("madeby")//230831추가
									)
						);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("selectList error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product selectOne(int pno) {
		// TODO Auto-generated method stub
		System.out.println("detail_DAO sucess!!");
		query="select * from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery(); //1개만 나올것임
			if(rs.next()) {
				return new Product(rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("selectOne error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Product p) {
		// TODO Auto-generated method stub
		System.out.println("update_DAO success!!");

		query  = "UPDATE product SET pname=?, price=?, madeby=?, regdate=now()"
				+ " WHERE pno = ?";
		try { //디비연결을 위해 try catch 만듬
			pst = conn.prepareStatement(query);
	
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			pst.setInt(4, p.getPno());
			return pst.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Conn연결 오류 SQL구문 에러");
			System.out.println("update Error!!");
			e.printStackTrace();
		}
			return 0;
		
	}

	@Override
	public int delete(int pno) {
		// TODO Auto-generated method stub

		System.out.println("delete_DAO success!!");
		query = "DELETE FROM product WHERE pno = ?";
		try {
			pst=conn.prepareStatement(query); //쿼리 받아오기 
			pst.setInt(1, pno);
			return pst.executeUpdate(); //아마도 키값이니 1개만 나올것임

		} catch(SQLException e) {
			System.out.println("delete Error!!");
			e.printStackTrace();
		} 
		return 0;
	}

} //class





















