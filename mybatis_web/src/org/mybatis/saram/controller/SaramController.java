package org.mybatis.saram.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.saram.model.Saram;
import org.mybatis.saram.model.SaramDAO;

public class SaramController extends HttpServlet {
	SaramDAO dao = new SaramDAO();
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		int beginIndex  = ctxPath.length();
		String path = reqUri.substring(beginIndex);
		
		System.out.println("process() - SaramController >> " + path);
		
		String viewName = "/WEB-INF/views/saram/saram_list.jsp";
		
		if("/saram/list.sa".equals(path)) {
			List<Saram> list = dao.selectAll();
			req.setAttribute("list", list);
		} 
		
		else if("/saram/detail.sa".equals(path)) {
			int seq = Integer.parseInt(req.getParameter("seq"));
			Saram saram = dao.selectOne(seq);
			req.setAttribute("saram", saram);
			viewName = "/WEB-INF/views/saram/saram_detail.jsp";
		} 
		
		else if("/saram/input.sa".equals(path)) {
			if("GET".equals(req.getMethod()) ) {
				viewName = "/WEB-INF/views/saram/saram_input.jsp";
			} else if("POST".equals(req.getMethod()) ) {
				String id = req.getParameter("id");
				String name = req.getParameter("name");
				String email = req.getParameter("email");
				dao.insert(new Saram(0, id, name, email));
				viewName = "redirect:list.sa";
			}
		} 
		
		else if ("/saram/modify.sa".equals(path)) {
			if ("GET".equals(req.getMethod())) {
				int seq = Integer.parseInt(req.getParameter("seq"));
				req.setAttribute("saram", dao.selectOne(seq));
				viewName = "/WEB-INF/views/saram/saram_modify.jsp";
			} else if ("POST".equals(req.getMethod())) {
				int seq = Integer.parseInt(req.getParameter("seq"));
				String id = req.getParameter("id");
				String name = req.getParameter("name");
				String email = req.getParameter("email");
				dao.update(new Saram(seq, id, name, email));
				viewName = "redirect:list.sa";
			}
		}

		
		else if("/saram/delete.sa".equals(path)) {
			int seq = Integer.parseInt(req.getParameter("seq"));
			dao.delete(new Saram(seq));
			viewName = "redirect:list.sa";
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