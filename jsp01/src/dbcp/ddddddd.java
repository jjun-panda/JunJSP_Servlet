package org.comstudy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy.dbcp.JdbcUtil;

public class SaramDAO {
   public static final String SELECT_ALL = "SELECT * FROM SARAM";
   public static final String SELECT_ONE = "SELECT * FROM SARAM WHERE SEQ=?";
   public static final String INSERT = "insert into saram(seq,id,name,email) values(seq_saram.nextval,?,?,?)";
   public static final String UPDATE = "UPDATE SARAM SET ID=?, NAME=?, EMAIL=? WHERE SEQ=?";
   public static final String DELETE = "DELETE FROM SARAM WHERE SEQ=?";
   
   private Connection conn;
   private PreparedStatement stmt;
   private ResultSet rs;

   public List<SaramDTO> selectAll() {
      List<SaramDTO> list = new ArrayList<SaramDTO>();
      conn = JdbcUtil.getConnection();
      try {
         stmt = conn.prepareStatement(SELECT_ALL);
         rs = stmt.executeQuery();
         while(rs.next()) {
            int seq = rs.getInt("seq");
            String id = rs.getString("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            list.add(new SaramDTO(seq, id, name, email));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JdbcUtil.close(conn, stmt, rs);
      }
      
      return list;
   }

   public SaramDTO selectOne(SaramDTO dto) {
      SaramDTO saram = null;
      conn = JdbcUtil.getConnection();
      try {
         stmt = conn.prepareStatement(SELECT_ONE);
         stmt.setInt(1, dto.getSeq());
         rs = stmt.executeQuery();
         if(rs.next()) {
            int seq = rs.getInt("seq");
            String id = rs.getString("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            saram = new SaramDTO(seq, id, name, email);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JdbcUtil.close(conn, stmt, rs);
      }
      return saram;
   }

   public SaramDTO findBySeq(int seq) {
      SaramDTO saram = null;
      conn = JdbcUtil.getConnection();
      try {
         stmt = conn.prepareStatement(SELECT_ONE);
         stmt.setInt(1, seq);
         rs = stmt.executeQuery();
         if(rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            saram = new SaramDTO(seq, id, name, email);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JdbcUtil.close(conn, stmt, rs);
      }
      return saram;
   }

   public void insert(SaramDTO dto) {
      conn = JdbcUtil.getConnection();
      try {
         stmt = conn.prepareStatement(INSERT);
         stmt.setString(1, dto.getId());
         stmt.setString(2, dto.getName());
         stmt.setString(3, dto.getEmail());
         int cnt = stmt.executeUpdate();
         if(cnt > 0) {
            System.out.println("입력 완료!");
            conn.commit(); // 트랜젝션 처리
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

   public void update(SaramDTO dto) {
      conn = JdbcUtil.getConnection();
      try {
         stmt = conn.prepareStatement(UPDATE);
         stmt.setString(1, dto.getId());
         stmt.setString(2, dto.getName());
         stmt.setString(3, dto.getEmail());
         stmt.setInt(4, dto.getSeq());
         int cnt = stmt.executeUpdate();
         if(cnt > 0) {
            System.out.println("수정 완료!");
            conn.commit(); // 트랜젝션 처리
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

   public void delete(SaramDTO dto) {
      conn = JdbcUtil.getConnection();
      try {
         stmt = conn.prepareStatement(DELETE);
         stmt.setInt(1, dto.getSeq());
         int cnt = stmt.executeUpdate();
         if(cnt > 0) {
            System.out.println("삭제 완료!");
            conn.commit(); // 트랜젝션 처리
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