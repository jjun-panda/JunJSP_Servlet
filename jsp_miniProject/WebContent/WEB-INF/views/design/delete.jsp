<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.design.*, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="dao" class="com.design.DesignDAO"/>

<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	dao.delete(seq);
%>
<c:redirect url="${pageContext.request.contextPath}/WEB-INF/views/design/list.jsp"></c:redirect> 
