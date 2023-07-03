package org.com.model.service;

import javax.servlet.http.HttpServletRequest;

import org.com.model.DesignCommand;
import org.com.model.DesignDTO;

public class DeleteCommand implements DesignCommand {
    @Override
    public void execute(HttpServletRequest req) {
        int num = Integer.parseInt(req.getParameter("num"));
        designDAO.delete(new DesignDTO(num));
        req.setAttribute("viewName", "design/delete");
        // req.setAttribute("redirectUrl", "list.do");
    }
}
