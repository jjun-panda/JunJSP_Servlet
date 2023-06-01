package dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
   // 프로토콜:서브프로토콜:thin:@호스트네임:포트:SID
   static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; 
   static final String user = "jjun"; 
   static final String password = "1234";

   // 글자를 머리에 넣는게 아니다. 
   // 일하는 방식을 익히는 것이다.
   // 작업 순서를 숙지한다.(테스트 - 구현 - 테스트)
   public static Connection getConnection() {
      Connection conn = null;
      try {
         // 1. 드라이버 검색 테스트 - 검색 성공 하면 자동으로 인스턴스 생성 됨.
         // Build Path에 라이브러리를 등록 하면 Referenced Libraries가 생성
         // OracleDriver의 위치를 찾아서 Copy Qualified Name으로 전체 경로 복사.
         Class.forName("oracle.jdbc.OracleDriver");
         // System.out.println("드라이버 검색 성공!");
         // 2. Connection객체 받아 오기
         conn = DriverManager.getConnection(url, user, password);
         // System.out.println(conn);
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버 검색 실패!");
         e.printStackTrace();
      } catch (SQLException e) {
         System.out.println("DB 연결 실패!");
         e.printStackTrace();
      }
      return conn;
   }
   
   public static void close(Connection obj) throws SQLException {
      if (obj != null) obj.close();
   }
   
   public static void close(Statement obj) throws SQLException {
      if (obj != null) obj.close();
   }
   
   public static void close(ResultSet obj) throws SQLException {
      if (obj != null) obj.close();
   }
   
   public static void close(Connection conn, Statement stmt, ResultSet rs) {
      try {
         close(conn);
         close(stmt);
         close(rs);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}