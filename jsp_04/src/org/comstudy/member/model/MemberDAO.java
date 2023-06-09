package org.comstudy.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy.dbcp.JdbcUtil;

public class MemberDAO {
	private String SELECT_ALL = "SELECT * FROM MEMBER ORDER BY SEQ DESC";
	private String SELECT_ONE = "SELECT * FROM MEMBER WHERE SEQ=?";
	private String FIND_BY_NAME = "SELECT * FROM MEMBER WHERE NAME LIKE ?";
	private String INSERT = "INSERT INTO MEMBER(SEQ, NAME, HEIGHT, WEIGHT, AGE, GENDER) VALUES(mem_seq.nextval, ?, ?, ?, ?, ?)";
	private String UPDATE = "UPDATE MEMBER SET name = ?, height = ?, weight = ?, age = ?, gender = ? WHERE SEQ = ?";
	private String DELETE = "DELETE FROM MEMBER WHERE SEQ = ?";

	private Connection conn;
		private PreparedStatement stmt;
		private ResultSet rs;

		public List<MemberDTO> selectAll() {
			List<MemberDTO> list = new ArrayList<MemberDTO>();
			conn = JdbcUtil.getConnection();
			try {
				stmt = conn.prepareStatement(SELECT_ALL);
				rs = stmt.executeQuery();
				while(rs.next()) {
					int seq = rs.getInt(1);
					String name = rs.getString(2);
					int height = rs.getInt(3);
					int weight = rs.getInt(4);
					int age = rs.getInt(5);
					String gender = rs.getString(6);
					list.add(new MemberDTO(seq, name, height, weight, age, gender));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, stmt, rs);
			}
			return list;
		}

		public MemberDTO selectOne(MemberDTO dto) {
			MemberDTO member = null;
			conn = JdbcUtil.getConnection();
			try {
				stmt = conn.prepareStatement(SELECT_ONE);
				stmt.setInt(1, dto.getSeq());
				rs = stmt.executeQuery();
				if(rs.next()) {
					int seq = rs.getInt(1);
					String name = rs.getString(2);
					int height = rs.getInt(3);
					int weight = rs.getInt(4);
					int age = rs.getInt(5);
					String gender = rs.getString(6);
					member = new MemberDTO(seq, name, height, weight, age, gender);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, stmt, rs);
			}
			return member;
		}

		public List<MemberDTO> findByName(String searchName) {
			List<MemberDTO> list = new ArrayList<MemberDTO>();
			conn = JdbcUtil.getConnection();
			try {
				stmt = conn.prepareStatement(FIND_BY_NAME);
				stmt.setString(1,  "%"+searchName+"%");
				rs = stmt.executeQuery();
				while(rs.next()) {
					int seq = rs.getInt(1);
					String name = rs.getString(2);
					int height = rs.getInt(3);
					int weight = rs.getInt(4);
					int age = rs.getInt(5);
					String gender = rs.getString(6);
					list.add(new MemberDTO(seq, name, height, weight, age, gender));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, stmt, rs);
			}
			return list;
		}

		public void insert(MemberDTO dto) {
			conn = JdbcUtil.getConnection();
			try {
				stmt = conn.prepareStatement(INSERT);
				stmt.setString(1, dto.getName());
				stmt.setInt(2, dto.getHeight());
				stmt.setInt(3, dto.getWeight());
				stmt.setInt(4, dto.getAge());
				stmt.setString(5, dto.getGender());
				int cnt = stmt.executeUpdate();
				if(cnt > 0) {
					System.out.println("입력 완료!");
					conn.commit();
				} else {
					System.out.println("입력 실패!");
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, stmt, rs);
			}
		}

		public void update(MemberDTO dto) {
			conn = JdbcUtil.getConnection();
			try {
				stmt = conn.prepareStatement(UPDATE);
				stmt.setString(1, dto.getName());
				stmt.setInt(2, dto.getHeight());
				stmt.setInt(3, dto.getWeight());
				stmt.setInt(4, dto.getAge());
				stmt.setString(5, dto.getGender());
				int cnt = stmt.executeUpdate();
				if(cnt > 0) {
					System.out.println("수정 완료!");
					conn.commit();
				} else {
					System.out.println("수정 실패!");
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, stmt, rs);
			}
		}

		public void delete(MemberDTO dto) {
			conn = JdbcUtil.getConnection();
			try {
				stmt = conn.prepareStatement(DELETE);
				stmt.setInt(1, dto.getSeq());
				int cnt = stmt.executeUpdate();
				if(cnt > 0) {
					System.out.println("삭제 완료!");
					conn.commit();
				} else {
					System.out.println("삭제 실패!");
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, stmt, rs);
			}
		}
	}