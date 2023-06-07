<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/header.jsp" %>

<div>
    <p>개발 작업 리스트</p>
    <ul>
        <li><a href="<%=request.getContextPath() %>/jsp/java/list.jsp">Java List</a></li>
        <li><a href="<%=request.getContextPath() %>/jsp/python/list.jsp">Python List</a></li>
    </ul>
</div>
    
<%@ include file="/inc/tail.jsp" %>