package com.design;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.common.JdbcUtil;

public class DesignDAO {
	private JdbcUtil JdbcUtil;
	
	public DesignDAO() {
		JdbcUtil = JdbcUtil.getInstance();
	}
	//삽입(C)
	public int insert(DesignDTO dto) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String query = "INSERT INTO DESIGN(SEQ, NAME, TYPE, AUTHOR, CONTENT, REGDATE, CNT) VALUES(design_seq.nextval,?,?,?,?,new(),0)";
		int ret = -1;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getType());
			stmt.setString(3, dto.getAuthor());
			stmt.setString(3, dto.getContent());;
			ret = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}	
		}
		return ret;
	}
	//조회(R)
	public List<DesignDTO> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM DESIGN ORDER BY SEQ DESC";
		ArrayList<DesignDTO> ls = new ArrayList<DesignDTO>();
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				DesignDTO dto = new DesignDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						new Date(rs.getDate(6).getTime()),
						rs.getInt(7));
				ls.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}	
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}	
		}
		return ls;
	}
	public DesignDTO selectOne(int seq) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM DESIGN WHERE SEQ=?";
		DesignDTO dto = null;
		ArrayList<DesignDTO> ls = new ArrayList<DesignDTO>();
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				updateCnt(seq); //조회수 증가
				dto = new DesignDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						new Date(rs.getDate(6).getTime()),
						rs.getInt(7)+1);
				ls.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}	
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}	
		}
		return dto;
	}
	//수정(U)
	public int update(DesignDTO dto) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String query = "UPDATE DESIGN SET NAME=?, TYPE=?, CONTENT=? WHERE SEQ=?";

		int ret = -1;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getType());
			stmt.setString(3, dto.getContent());
			stmt.setInt(4, dto.getSeq());
			ret = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}	
		}
		return ret;
	}
	public int updateCnt(int seq) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String query = "UPDATE DESIGN SET CNT=CNT+1 WHERE SEQ=?";

		int ret = -1;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, seq);
			ret = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}	
		}
		return ret;
	}
	
	//삭제(D)
	public int delete(int seq) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String query = "DELETE FROM DESIGN WHERE SEQ=?";
		int ret = -1;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, seq);
			ret = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}	
		}
		return ret;
	}
}