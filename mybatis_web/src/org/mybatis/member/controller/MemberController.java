package org.mybatis.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.member.model.Member;
import org.mybatis.member.model.MemberDAO;

public class MemberController extends HttpServlet {
	MemberDAO dao = new MemberDAO();
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		int beginIndex  = ctxPath.length();
		String path = reqUri.substring(beginIndex);
		
		System.out.println("process() - MemberController >> " + path);
		
		String viewName = "/WEB-INF/views/member/member_list.jsp";
		
		if("/member/list.me".equals(path)) {
			List<Member> list = dao.selectAll();
			req.setAttribute("list", list);
		} 
		
		else if("/member/detail.me".equals(path)) {
			int seq = Integer.parseInt(req.getParameter("seq"));
			Member member = dao.selectOne(seq);
			req.setAttribute("member", member);
			viewName = "/WEB-INF/views/member/member_detail.jsp";
		} 
		
		else if("/member/input.me".equals(path)) {
			if("GET".equals(req.getMethod()) ) {
				viewName = "/WEB-INF/views/member/member_input.jsp";
			} else if("POST".equals(req.getMethod()) ) {
				String name = req.getParameter("name");
				int height = Integer.parseInt(req.getParameter("height"));
				int weight = Integer.parseInt(req.getParameter("weight"));
				int age = Integer.parseInt(req.getParameter("age"));
				String gender = req.getParameter("gender");
				dao.insert(new Member(0, name, height, weight, age, gender));
				viewName = "redirect:list.me";
			}
		} 
		
		else if("/member/modify.me".equals(path)) {
			if("GET".equals(req.getMethod()) ) {
				int seq = Integer.parseInt(req.getParameter("seq"));
				req.setAttribute("member", dao.selectOne(seq));
				viewName = "/WEB-INF/views/member/member_modify.jsp";
			} else if("POST".equals(req.getMethod()) ) {
				int seq = Integer.parseInt(req.getParameter("seq"));
				String name = req.getParameter("name");
				int height = Integer.parseInt(req.getParameter("height"));
				int weight = Integer.parseInt(req.getParameter("weight"));
				int age = Integer.parseInt(req.getParameter("age"));
				String gender = req.getParameter("gender");
				// dao.update(new Member(seq, name, height, weight, age, gender));
				viewName = "redirect:list.me";
			}
		} 
		
		else if("/member/delete.me".equals(path)) {
			int seq = Integer.parseInt(req.getParameter("seq"));
			dao.delete(new Member(seq));
			viewName = "redirect:list.me";
		} 
		
    if (viewName.indexOf("redirect:") == -1) {
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		} else {
			resp.sendRedirect(viewName.substring("redirect:".length()));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
}