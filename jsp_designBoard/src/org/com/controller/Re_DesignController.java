package org.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.model.DesignDAO_JDBC;
import org.com.model.DesignDTO;

public class Re_DesignController extends HttpServlet {
    private DesignDAO_JDBC dao = new DesignDAO_JDBC();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String reqUri = req.getRequestURI();
        String ctxPath = req.getContextPath() + "design/";
        int beginIndex = ctxPath.length();
        String path = reqUri.substring(beginIndex);
        
        System.out.println("reqUri => " + reqUri);
        System.out.println("ctxPath => " + ctxPath);
        System.out.println("path => " + path);
		
        String prefix = "/WEB-INF/views/design/";
        String viewName = prefix + "list.jsp";
        
        if("/list.do".equals(path)) {
            List<DesignDTO> memList = dao.selectAll();
            req.setAttribute("memList", memList);
        } 
        
        else if("/input.do".equals(path)) {
            viewName = prefix + "registForm.jsp";
        } 
        
        else if("/search.do".equals(path)) {
            viewName = prefix + "mem_search.jsp";
        } 
        
        else if("/detail.do".equals(path)) {
            viewName = prefix + "designDetail.jsp";
		} 
        
        else if ("/modify.do".equals(path)) {
			viewName = prefix + "editForm.jsp";
		} 
        
        else if ("/delete.do".equals(path)) {
			viewName = prefix + "delete.jsp";
		}
        
        RequestDispatcher view = req.getRequestDispatcher(viewName);
        view.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String reqUri = req.getRequestURI();
        String ctxPath = req.getContextPath() + "design/";
        int beginIndex = ctxPath.length();
        String path = reqUri.substring(beginIndex);
        //System.out.println("path ==> " + path);

        String prefix = "/WEB-INF/views/design/";
        String viewName = prefix + "list.jsp";
                
//        if ("/search_list.do".equals(path)) {
//            String searchName = req.getParameter("searchName");
//            List<DesignDTO> memList = dao.selectOne(searchName);
//            req.setAttribute("memList", memList);
//            viewName = prefix + "mem_search_list.jsp";
//        } else if
        
        if ("/regist.do".equals(path)) {
            String author = req.getParameter("author");
            String typename = req.getParameter("typename");
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String password = req.getParameter("password");
            DesignDTO design = new DesignDTO(author, typename, title, content, password);
            dao.insert(design);
            
            List<DesignDTO> memList = dao.selectAll();
            req.setAttribute("memList", memList);
            viewName = prefix + "regist.jsp";
        } 
        
        else if ("/modify_ok.do".equals(path)) {
            String author = req.getParameter("author");
            String typename = req.getParameter("typename");
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String password = req.getParameter("password");
            String numParam = req.getParameter("num");
            int num = (numParam != null && !numParam.isEmpty()) ? Integer.parseInt(numParam) : 0;
            DesignDTO design = new DesignDTO(author, typename, title, content, password);
            dao.update(design);
            
            List<DesignDTO> memList = dao.selectAll();
			req.setAttribute("design", memList);
			viewName = prefix + "edit.jsp";
		}


        RequestDispatcher view = req.getRequestDispatcher(viewName);
        view.forward(req, resp);
    }
}
