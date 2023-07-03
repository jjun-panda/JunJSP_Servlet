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