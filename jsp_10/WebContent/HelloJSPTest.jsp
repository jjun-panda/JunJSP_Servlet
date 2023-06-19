<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
private String name = "홍길동";
public String getName() {
    return name;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Name : <%=getName() %>
<br/>
<%=getServletContext().getRealPath("/") %>
</body>
</html>