<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String user="사용자명: " + "<span>"+request.getParameter("user")+"</span>";
String msg="메시지: " + "<span>"+request.getParameter("msg")+"</span>";
%>
{"user":"<%=user %>", "msg":"<%=msg %>"}