<%@ page import="model.SaramDAO"%>
<%@ page import="model.SaramDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/header.jsp" %>

<%
// request의 한글 처리
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String name = request.getParameter("name");
String email = request.getParameter("email");

SaramDAO dao = new SaramDAO();
dao.insert(new SaramDTO(0, id, name, email));

// 처리 후 리스트로 페이지 이동
response.sendRedirect("list.jsp");
%>

<p>id : <%= id %></p>
<p>name : <%= name %></p>
<p>email : <%= email %></p>

<%@ include file="/inc/tail.jsp" %>