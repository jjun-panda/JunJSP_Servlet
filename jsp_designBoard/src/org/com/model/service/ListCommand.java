package org.com.model.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.com.model.DesignCommand;
import org.com.model.DesignDTO;

public class ListCommand implements DesignCommand {
    @Override
    public void execute(HttpServletRequest req) {
        List<DesignDTO> list = designDAO.selectAll();
        req.setAttribute("list", list);
        req.setAttribute("viewName", "design/list");
    }
}
