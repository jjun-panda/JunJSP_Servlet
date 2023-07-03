package org.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	private String viewName;
	private boolean isRedirect;
	private RequestDispatcher view;
	private String prefix;
	private String suffix;
	
	public void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		viewName = (String) req.getAttribute("viewName");
		isRedirect = false;
		if(viewName.indexOf("redirect:") == 0) {
			isRedirect = true;
		}
		
		if(isRedirect == false) {
			view = req.getRequestDispatcher(prefix + viewName + suffix);
			view.forward(req, resp);
		} else {
			resp.sendRedirect(viewName.substring("redirect:".length()));
		}
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;		
	}
}
