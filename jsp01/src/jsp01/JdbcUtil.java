package jsp01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 기본적으로 web에서는 WEB-INF>lib의 라이브러리를 사용한다.
// 그러나 .java파일에서 자동완성 하기 위해 빌드패스에도 등록한다. 
public class JdbcUtil {
	public static Connection getConnection() {
		// 무슨 라이브러리가 필요한가? ojdbc6.jar가 필요하다.
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "jjun";
		String password = "1234";
		try {
			// 차후에 Tomcat에서 제공되는 JNDI로 변경 될 예정.
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 검색 성공!");
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (ClassNotFoundException e) {
			System.err.println("오류 : 드라이버 검색 실패!");
		} catch (SQLException e) {
			System.err.println("오류 : DB 접속 실패!");
		}
		return null;
	}
	
	public static void close(Connection obj) {
		if(obj != null) {
			try {
				obj.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement obj) {
		if(obj != null) {
			try {
				obj.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet obj) {
		if(obj != null) {
			try {
				obj.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		close(conn);
		close(stmt);
		close(rs);
	}
}