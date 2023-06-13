package org.comstudy.myweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// FrontController 역할
public class DispatcherServlet extends HttpServlet {
	HandlerMapping handlerMapping = new HandlerMapping();
	Controller ctrl;
	ModelAndView mav;
	ViewResolver viewResolver = new ViewResolver();
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		int beginIndex = ctxPath.length();
		String path = reqUri.substring(beginIndex);
		
		int end = path.lastIndexOf("/");
		String ctrlPath = path.substring(0, end);
		String filePath = path.substring(end);
		req.setAttribute("ctrlPath", ctrlPath);
		req.setAttribute("filePath", filePath);
		
		ctrl = handlerMapping.getController(ctrlPath);
		mav = ctrl.execute(req, resp);
		viewResolver.action(mav, req, resp); // forward 또는 redirect 해줌.
		
		System.out.println("process() - DispatcherServlet");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
}
