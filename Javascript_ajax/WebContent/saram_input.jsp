<%@page import="com.ajax.SaramData"%>
<%@page import="com.ajax.SaramDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age") );

SaramDAO dao = new SaramDAO();
dao.insert(new SaramData(0, id, name, age));

response.sendRedirect("saram_data.jsp");
%>