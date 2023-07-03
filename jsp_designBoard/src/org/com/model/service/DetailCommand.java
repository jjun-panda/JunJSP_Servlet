package org.com.model.service;

import javax.servlet.http.HttpServletRequest;

import org.com.model.DesignCommand;
import org.com.model.DesignDTO;

public class DetailCommand implements DesignCommand {
    @Override
    public void execute(HttpServletRequest req) {
        int num = Integer.parseInt(req.getParameter("num"));
        DesignDTO design = designDAO.selectOne(new DesignDTO(num));
        req.setAttribute("design", design);
        req.setAttribute("viewName", "design/detail");
    }
}
