package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbcp.JdbcUtil;

public class PersonDAO {
	final String SELECT_ALL = "SELECT * FROM PERSON";
	final String SELECT_ONE = "SELECT * FROM PERSON WHERE SEQ=?";
	final String INSERT = "INSERT INTO PERSON(SEQ, ID, NAME, AGE) VALUES(?,?,?,?)";
	final String UPDATE = "UPDATE PERSON SET ID=?, NAME=?, AGE=? WHERE SEQ=?";
	final String DELETE = "DELETE FROM PERSON WHERE SEQ=?";
	
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	
	// CRUD가 되도록 한다.
	
	public List<PersonDTO> selectAll() {
		List<PersonDTO> list = new ArrayList();
		conn = JdbcUtil.getConnection();
		try {
		stmt = conn.prepareStatement(SELECT_ALL);
		rs  = stmt.executeQuery();
		while(rs.next()) {
			int seq = rs.getInt("seq");
			String name = rs.getString("name");
			String id = rs.getString("id");
			int age = rs.getInt("age");
			list.add(new PersonDTO(seq, id, name, age));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(conn, stmt, rs);
	}
		return list;
	}
	
	public PersonDTO selectOne(PersonDTO dto) {
		PersonDTO personal = null;

		 conn = JdbcUtil.getConnection();
		 try {
			stmt = conn.prepareStatement(SELECT_ONE);
			stmt.setInt(1, dto.getSeq());
			rs = stmt.executeQuery();
			while(rs.next()) {
					int seq = rs.getInt("seq");
					String name = rs.getString("name");
					String id = rs.getString("id");
					int age = rs.getInt("age");
					personal = new PersonDTO(seq, id, name, age);
			 }
		 } catch (SQLException e) {
			e.printStackTrace();
		 } finally {
			JdbcUtil.close(conn, stmt, rs);
		 }
		 return personal;
	}
	
	public void insert(PersonDTO dto) {
		conn = JdbcUtil.getConnection();
		 try {
			stmt = conn.prepareStatement(INSERT);
			stmt.setInt(1, dto.getSeq());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getId());
			stmt.setInt(4, dto.getAge());
			int cnt = stmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("입력 성공!");
			} else {
				System.out.println("입력 실패!");
			}
		 } catch (SQLException e) {
			e.printStackTrace();
		 } finally {
			JdbcUtil.close(conn, stmt, rs);
		 }
	}
	
	public void update(PersonDTO dto) {
		conn = JdbcUtil.getConnection();
		 try {
			stmt = conn.prepareStatement(UPDATE);
			stmt.setInt(1, dto.getSeq());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getId());
			stmt.setInt(4, dto.getAge());
			int cnt = stmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패!");
			}
		 } catch (SQLException e) {
			e.printStackTrace();
		 } finally {
			JdbcUtil.close(conn, stmt, rs);
		 }
	}
	
	public void delete(PersonDTO dto) {
		conn = JdbcUtil.getConnection();
		 try {
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, dto.getSeq());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getId());
			stmt.setInt(4, dto.getAge());
			int cnt = stmt.executeUpdate();
			if (cnt > 0) {
			System.out.println("삭제 성공!");
			} else {
			System.out.println("삭제 실패!");
			}
		 } catch (SQLException e) {
			e.printStackTrace();
		 } finally {
			JdbcUtil.close(conn, stmt, rs);
		 }
	}
	/////////////////////////////////////// ----- test
	
	public static void testSelectOne() {
		// selectOne 테스트 하기
		PersonDAO dao = new PersonDAO();
		PersonDTO person = dao.selectOne(new PersonDTO(3, null, null, 0));
		System.out.println(person);
	}
	
	// JNDI를 사용하지 않은 어플리케이션은 main에서 테스트 가능.
	public static void testSelectAll() {
		// JDBC를 사용하기때문에 Oracle이 반드시 실행 되어야 한다.
		PersonDAO dao = new PersonDAO();
		
		List<PersonDTO> list = dao.selectAll();
		for(PersonDTO dto : list) {
			System.out.println(dto);
		}
	}
}