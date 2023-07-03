package org.com.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcUtil {
	public static Connection getConnection() {
		Connection conn = null;
		// JNDI를 이용한 DataSource 생성(Tomcat 도움말 참조)
		// https://tomcat.apache.org/tomcat-9.0-doc/jndi-resources-howto.html#JDBC_Data_Sources
		// 1. META-INF에 context.xml 준비(Servers의 context.xml 복사)
		// 2. web.xml에 Name 등록
		// 3. DataSource 생성
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/DesignDB");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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