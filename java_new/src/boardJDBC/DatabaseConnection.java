package boardJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = null;
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/productdb"; //오라클은8080 씀 mysql은 3306씀
	
	private DatabaseConnection() {
		try {
			Class.forName(jdbcDriver);//중요
			conn = DriverManager.getConnection(jdbcUrl,"mysqluser","mysql");//중요
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("드라이버를 찾을 수 없습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("URL정보다 정확치 않습니다.");
		}
	}
	public static DatabaseConnection getInstance() { //이게 퍼블릭이라서 위 내용들을 외부에서 쓸수 잇음
		return dbc;
	}
	public Connection getConnection() {//이게 퍼블릭이라서 위 내용들을  외부에서 쓸수 잇음
		return conn;
	}
}
