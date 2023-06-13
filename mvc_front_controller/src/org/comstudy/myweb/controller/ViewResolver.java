package org.comstudy.myweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	String viewName;
	String prefix = "/WEB-INF/views/";
	String suffix = ".jsp";
	
	public void action(ModelAndView mav, HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		viewName = prefix + mav.getViewName() + suffix;
		
		System.out.println("viewName => " + viewName);
		
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
	
}
