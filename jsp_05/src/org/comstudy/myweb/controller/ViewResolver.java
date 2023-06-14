package org.comstudy.myweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	private String viewName;
	private String prefix = "/WEB-INF/views/";
	private String suffix = ".jsp";
	
	public void action(ModelAndView mav, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("viewName => " + viewName);
		
		viewName = mav.getViewName();
		if(viewName.indexOf("redirect:") == 0) {
			resp.sendRedirect(viewName);
		} else {
			viewName = prefix + mav.getViewName() + suffix;			
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}
	}
	
}
