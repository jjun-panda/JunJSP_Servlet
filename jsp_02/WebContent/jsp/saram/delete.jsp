<%@ page import="model.SaramDAO"%>
<%@ page import="model.SaramDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/header.jsp" %>

<h1>삭제하기</h1>
<%
int seq = Integer.parseInt(request.getParameter("seq"));
SaramDAO dao = new SaramDAO();

dao.delete(new SaramDTO(seq));

response.sendRedirect("list.jsp");

%>

<%@ include file="/inc/tail.jsp" %>