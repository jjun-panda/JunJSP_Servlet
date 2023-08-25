package org.comstudy.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.member.model.MemberDAO;
import org.comstudy.member.model.MemberDTO;

public class MemberController extends HttpServlet {
    private MemberDAO dao = new MemberDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String reqUri = req.getRequestURI();
        String ctxPath = req.getContextPath() + "member/";
        int beginIndex = ctxPath.length();
        String path = reqUri.substring(beginIndex);
        
        System.out.println("reqUri => " + reqUri);
        System.out.println("ctxPath => " + ctxPath);
        System.out.println("path => " + path);
		
        String prefix = "/WEB-INF/views/member/";
        String viewName = prefix + "mem_list.jsp";
        if("/list.do".equals(path)) {
            List<MemberDTO> memList = dao.selectAll();
            req.setAttribute("memList", memList);
        } 
        
        else if("/input.do".equals(path)) {
            viewName = prefix + "mem_input.jsp";
        } 
        
        else if("/search.do".equals(path)) {
            viewName = prefix + "mem_search.jsp";
        } 
        
        else if("/detail.do".equals(path)) {
            int seq = Integer.parseInt(req.getParameter("seq"));
            MemberDTO member = dao.selectOne(new MemberDTO(seq, ""));
            req.setAttribute("member", member);
            viewName = prefix + "mem_detail.jsp";
		} 
        
        else if ("/modify.do".equals(path)) {
			viewName = prefix + "mem_modify.jsp";
		} 
        
        else if ("/delete.do".equals(path)) {
			viewName = prefix + "mem_delete.jsp";
		}
        
        RequestDispatcher view = req.getRequestDispatcher(viewName);
        view.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String reqUri = req.getRequestURI();
        String ctxPath = req.getContextPath() + "member/";
        int beginIndex = ctxPath.length();
        String path = reqUri.substring(beginIndex);
        //System.out.println("path ==> " + path);

        String prefix = "/WEB-INF/views/member/";
        String viewName = prefix + "mem_list.jsp";
                
        if ("/search_list.do".equals(path)) {
            String searchName = req.getParameter("searchName");
            List<MemberDTO> memList = dao.findByName(searchName);
            req.setAttribute("memList", memList);
            viewName = prefix + "mem_search_list.jsp";
        }
        
        else if ("/input_ok.do".equals(path)) {
            String name = req.getParameter("name");
            int height = Integer.parseInt(req.getParameter("height"));
            int weight = Integer.parseInt(req.getParameter("weight"));
            int age = Integer.parseInt(req.getParameter("age"));
            String gender = req.getParameter("gender");
            MemberDTO member = new MemberDTO(0, name, height, weight, age, gender);
            dao.insert(member);
            
            List<MemberDTO> memList = dao.selectAll();
            req.setAttribute("memList", memList);
            viewName = prefix + "mem_send.jsp";
        } 
        
        else if ("/modify_ok.do".equals(path)) {
            String name = req.getParameter("name");
            int height = Integer.parseInt(req.getParameter("height"));
            int weight = Integer.parseInt(req.getParameter("weight"));
            int age = Integer.parseInt(req.getParameter("age"));
            String gender = req.getParameter("gender");
            String seqParam = req.getParameter("seq");
            int seq = (seqParam != null && !seqParam.isEmpty()) ? Integer.parseInt(seqParam) : 0;
            MemberDTO member = new MemberDTO(seq, name, height, weight, age, gender);
            dao.update(member);
            
            List<MemberDTO> memList = dao.selectAll();
			req.setAttribute("member", memList);
			viewName = prefix + "mem_send.jsp";
		}


        RequestDispatcher view = req.getRequestDispatcher(viewName);
        view.forward(req, resp);
    }
}
