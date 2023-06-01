<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="index.css" type="text/css">
</head>
<body>
<h1>상세 정보 페이지</h1>
<%
// 파라미터 전달 받기
// 기본 제공되는 내장 객체들
// out, request, response, session, application 
String name = request.getParameter("name");
String addr = request.getParameter("addr");
String strAge = request.getParameter("age");
int age = Integer.parseInt(strAge!=null?strAge:"0");
String job = request.getParameter("job");
%>
<ui>
<li>Name : <%=name %></li>
<li>Address : <%=addr %></li>
<li>Age : <%=age %></li>
<li>Job : <%=job %></li>
</ui>
</body>
</html>