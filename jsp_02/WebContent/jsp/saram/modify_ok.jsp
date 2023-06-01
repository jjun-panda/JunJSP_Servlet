<%@ page import="model.SaramDAO"%>
<%@ page import="model.SaramDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/header.jsp" %>

<%
request.setCharacterEncoding("UTF-8");

SaramDAO dao = new SaramDAO();
SaramDTO saram = null;

if(request.getParameter("seq") != null) {
   int seq = Integer.parseInt(request.getParameter("seq"));
   String id = request.getParameter("id"); 
   String name = request.getParameter("name"); 
   String email = request.getParameter("email"); 
   saram = new SaramDTO(seq, id, name, email);
   
   dao.update(saram);
}

response.sendRedirect("list.jsp");
%>

<%@ include file="/inc/tail.jsp" %>