package org.comstudy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.member.model.MemberDAO;
import org.comstudy.member.model.MemberDTO;

public class HelloServlet extends HttpServlet {
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      MemberDAO dao = new MemberDAO();
      
      List<MemberDTO> list = dao.selectAll();
      System.out.println(list);
      
      resp.setContentType("text/html; charset=UTF-8");
      resp.setCharacterEncoding("UTF-8");
      
      PrintWriter out = resp.getWriter();
      out.print("<!DOCTYPE html>");
      out.print("<html>");
      out.print("<body>");
      out.print("<p>"+ list +"</p>");
      out.print("</body>");
      out.print("</html>");
      out.close();
   }

   
   protected void doGetTest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // 한글 나오게 하는 설정
      resp.setContentType("text/html; charset=UTF-8");
      resp.setCharacterEncoding("UTF-8");
      
      PrintWriter out = resp.getWriter();
      out.print("<!DOCTYPE html>");
      out.print("<html>");
      out.print("<body>");
      out.print("<h1>안녕 세계</h1>");
      out.print("</body>");
      out.print("</html>");
      out.close();
   }
   
}