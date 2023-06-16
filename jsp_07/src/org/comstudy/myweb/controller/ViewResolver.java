package org.comstudy.myweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	String viewName;
	String prefix;
	String suffix;

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void forward(String viewName, HttpServletRequest req, HttpServletResponse resp) {
		this.viewName = viewName;
		try {
			if (viewName.indexOf("redirect:") != 0) {
				RequestDispatcher view = req.getRequestDispatcher(prefix + viewName + suffix);
				view.forward(req, resp);
			} else {
				resp.sendRedirect(viewName.substring("redirect:".length()));
			}
		} catch (ServletException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace(); }
	}
}
