package jsp01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			String name = rs.getNString("name");
			String id = rs.getNString("id");
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
			stmt.setString(1, dto.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
					int seq = rs.getInt("seq");
					String name = rs.getNString("name");
					String id = rs.getNString("id");
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
}