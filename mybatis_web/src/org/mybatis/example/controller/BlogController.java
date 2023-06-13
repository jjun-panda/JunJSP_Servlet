package org.mybatis.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.example.model.Blog;
import org.mybatis.example.model.BlogDAO;

public class BlogController extends HttpServlet {
	BlogDAO dao = new BlogDAO();
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		int beginIndex  = ctxPath.length();
		String path = reqUri.substring(beginIndex);
		
		System.out.println("process() - BlogController >> " + path);
		
		String viewName = "/WEB-INF/views/blog/blog_list.jsp";
		
		if("/blog/list.do".equals(path)) {
			List<Blog> list = dao.selectAll();
			req.setAttribute("list", list);
		} 
		
		else if("/blog/detail.do".equals(path)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Blog blog = dao.selectOne(id);
			req.setAttribute("blog", blog);
			viewName = "/WEB-INF/views/blog/blog_detail.jsp";
		} 
		
		else if("/blog/input.do".equals(path)) {
			if("GET".equals(req.getMethod()) ) {
				viewName = "/WEB-INF/views/blog/blog_input.jsp";
			} else if("POST".equals(req.getMethod()) ) {
				String author = req.getParameter("author");
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				dao.insert(new Blog(0, author, title, content));
				viewName = "redirect:list.do";
			}
		} 
		
		else if("/blog/modify.do".equals(path)) {
			if("GET".equals(req.getMethod()) ) {
				int id = Integer.parseInt(req.getParameter("id"));
				req.setAttribute("blog", dao.selectOne(id));
				viewName = "/WEB-INF/views/blog/blog_modify.jsp";
			} else if("POST".equals(req.getMethod()) ) {
				int id = Integer.parseInt(req.getParameter("id"));
				String author = req.getParameter("author");
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				dao.update(new Blog(id, author, title, content));
				viewName = "redirect:list.do";
			}
		} 
		
		else if("/blog/delete.do".equals(path)) {
			int id = Integer.parseInt(req.getParameter("id"));
			dao.delete(new Blog(id));
			viewName = "redirect:list.do";
		} 
		
    if (viewName.indexOf("redirect:") == -1) {
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		} else {
			// 목록이 새로 고침되어 새로운 데이터로 갱신 됨.
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