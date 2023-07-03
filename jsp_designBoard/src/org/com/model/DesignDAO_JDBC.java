package org.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.com.common.JdbcUtil;

public class DesignDAO_JDBC {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	final String SELECT_ALL = "select * from design order by NUM desc";
	final String SELECT_ONE = "select * from design where NUM = ?";
	final String INSERT = "insert into design(NUM, AUTHOR, TYPENAME, TITLE, CONTENT, PASSWORD) values (design_num.nextval, ?, ?, ?, ?, ?)";
	final String UPDATE = "update design set TYPENAME = ?, TITLE = ?, CONTENT = ? where NUM = ?";
	final String DELETE = "delete design where NUM = ?";

	public List<DesignDTO> selectAll() {
		List<DesignDTO> list = new ArrayList<DesignDTO>();
		conn = JdbcUtil.getConnection();
		try{
			stmt = conn.prepareStatement(SELECT_ALL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String typename = rs.getString("typename");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String password = rs.getString("password");
				Timestamp writedate = rs.getTimestamp("writedate");
				int readcnt = rs.getInt("readcnt");
				int rep_root = rs.getInt("rep_root");
				int rep_step = rs.getInt("rep_step");
				int rep_indent = rs.getInt("rep_indent");
				list.add(new DesignDTO(num, author, typename, title, content, password, writedate, readcnt, rep_root, rep_step, rep_indent));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return list;
	}
	public DesignDTO selectOne(DesignDTO dto) {
		DesignDTO design = null;
		conn = JdbcUtil.getConnection();
		try{
			stmt = conn.prepareStatement(SELECT_ONE);
			stmt.setInt(1, dto.getNum());
			rs = stmt.executeQuery();
			if(rs.next()) {
				String author = rs.getString("author");
				String typename = rs.getString("typename");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String password = rs.getString("password");
				design = new DesignDTO(author, typename, title, content, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return design;
	}
	
	public void insert(DesignDTO dto) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, dto.getAuthor());
			stmt.setString(2, dto.getTypename());
			stmt.setString(3, dto.getTitle());
			stmt.setString(4, dto.getContent());
			stmt.setString(5, dto.getPassword());
			int cnt = stmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("입력 완료!");
				conn.commit();
			} else {
				System.err.println("입력 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}
	public void update(DesignDTO dto) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, dto.getTypename());
			stmt.setString(2, dto.getTitle());
			stmt.setString(3, dto.getContent());
			stmt.setInt(4, dto.getNum());
			int cnt = stmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("수정 완료!");
				conn.commit();
			} else {
				System.err.println("수정 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}
	public void delete(DesignDTO dto) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, dto.getNum());
			int cnt = stmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("삭제 완료!");
				conn.commit();
			} else {
				System.err.println("삭제 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}
}
