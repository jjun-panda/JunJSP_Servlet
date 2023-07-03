package org.com.model.service;

import javax.servlet.http.HttpServletRequest;

import org.com.model.DesignCommand;
import org.com.model.DesignDTO;

public class WriteCommand implements DesignCommand {
    @Override
    public void execute(HttpServletRequest req) {
    	if("GET".equals(req.getMethod())) {
			req.setAttribute("viewName", "design/write");
		} else if("POST".equals(req.getMethod())) {			
			DesignDTO design = new DesignDTO(
					req.getParameter("author"),
					req.getParameter("typename"),
					req.getParameter("title"),
					req.getParameter("content"),
					req.getParameter("password")
					);
			designDAO.insert(design);
//	        req.setAttribute("redirectUrl", "list.do");
	        req.setAttribute("viewName", "redirect:list.do");
		}
    }
}