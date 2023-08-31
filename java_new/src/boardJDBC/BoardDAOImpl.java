package boardJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.Product;
import boardJDBC.BoardVO;


public class BoardDAOImpl implements DAO {

	//DB랑 연결
	private Connection conn;
	private PreparedStatement pst;
	private String query = ""; // 쿠ㅓ리구문 저장용
	
	public BoardDAOImpl() {
		//여기서 디비 연결~ 객체 생성)
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();  //다오 연결은 여기까지?  컨트롤러에 인서트부터 시작하기
		
	}
	
	//메서드 처리
	
	@Override
	public int insert(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("insert DAO sucess!!");
		query ="insert into Board(title, writer, content) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, bvo.getTitle());
			pst.setString(2, bvo.getWriter());
			pst.setString(3, bvo.getContent());
			
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
	public List<BoardVO> selectList() {
		System.out.println("list DAO sucess!!");
		query = "SELECT * FROM board ORDER BY bno DESC";
		List<BoardVO> list = new ArrayList<>(); // 리스트가 인터페이스라서 생성해줘야함
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {//다음 값이 있나영?  있으면 뺴옴
				list.add(//pno, pname,price
						new BoardVO(			
									rs.getInt("bno"),
									rs.getString("title"),
									rs.getString("writer"),
									rs.getString("regdate"),
									rs.getInt("readcount")
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
	public BoardVO selectOne(int bno) {
//		create table board(
//				bno int auto_increment,
//				title varchar(200) not null,
//				writer varchar(100) not null,
//				content text,
//				regdate datetime default now(),
//				moddate datetime default now(),
//				readcount int default 0,
//				primary key(bno)
//				);
		
		
		//상세 페이지용
//		public BoardVO(int bno, String title, String writer, String content, String regdate, String moddate,
//				int readcount) {
//			super();
//			this.bno = bno;
//			this.title = title;
//			this.writer = writer;
//			this.content = content;
//			this.regdate = regdate;
//			this.moddate = moddate;
//			this.readcount = readcount;
//		}
		System.out.println("detail_DAO sucess!!");
		query="select * from board where bno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, bno);
			ResultSet rs = pst.executeQuery(); //1개만 나올것임
			if(rs.next()) {
				return new BoardVO(
							rs.getInt("bno"),
							rs.getString("title"),
							rs.getString("writer"),
							rs.getString("content"),
							rs.getString("regdate"),
							rs.getString("moddate"),
							rs.getInt("readcount")
						);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("selectOne error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int readCount(int bno) {
		// TODO Auto-generated method stub
		System.out.println("count_update_DAO success!!");

		query  = "UPDATE board SET readcount=readcount+1 "
				+ " WHERE bno = ?";
		try { //디비연결을 위해 try catch 만듬
	
			pst = conn.prepareStatement(query);
			pst.setInt(1, bno);
			return pst.executeUpdate();
			
			
		} catch(SQLException e) {
			System.out.println("Conn연결 오류 SQL구문 에러");
			System.out.println("update Error!!");
			e.printStackTrace();
		}
			return 0;
	}

	@Override
	public int update(BoardVO bovo) {
		//글수정용
//		public BoardVO(int bno, String title, String writer, String content) {
//			super();
//			this.bno = bno;
//			this.title = title;
//			this.writer = writer;
//			this.content = content;
//		}
		System.out.println("update_DAO success!!");

		query  = "UPDATE board SET title=?, writer=?, content=?, moddate = now()"
				+ " WHERE bno = ?";
		try { //디비연결을 위해 try catch 만듬
			pst = conn.prepareStatement(query);
	
			pst.setString(1, bovo.getTitle());
			pst.setString(2, bovo.getWriter());
			pst.setString(3, bovo.getContent());
			pst.setInt(4, bovo.getBno());
			return pst.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Conn연결 오류 SQL구문 에러");
			System.out.println("update Error!!");
			e.printStackTrace();
		}
			return 0;
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub

		System.out.println("delete_DAO success!!");
		query = "DELETE FROM board WHERE bno = ?";
		try {
			pst=conn.prepareStatement(query); //쿼리 받아오기 
			pst.setInt(1, bno);
			return pst.executeUpdate(); //아마도 키값이니 1개만 나올것임

		} catch(SQLException e) {
			System.out.println("delete Error!!");
			e.printStackTrace();
		} 
		return 0;
	}


	

	
}
