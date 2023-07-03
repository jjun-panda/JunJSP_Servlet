package org.com.model.service;

import javax.servlet.http.HttpServletRequest;

import org.com.model.DesignCommand;
import org.com.model.DesignDTO;

public class EditCommand implements DesignCommand {
    @Override
    public void execute(HttpServletRequest req) {
        
        if("GET".equals(req.getMethod())) {
			int num = Integer.parseInt(req.getParameter("num"));
			DesignDTO design = designDAO.selectOne(new DesignDTO(num));
			req.setAttribute("design", design);
			req.setAttribute("viewName", "design/edit");
		} else if("POST".equals(req.getMethod())) {
			int num = Integer.parseInt(req.getParameter("num"));
			String typename = req.getParameter("typename");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			DesignDTO design = new DesignDTO(num, typename, title, content); 
			designDAO.update(design);
//	        req.setAttribute("redirectUrl", "list.do");
	        req.setAttribute("viewName", "redirect:list.do");
		}	
    }
}