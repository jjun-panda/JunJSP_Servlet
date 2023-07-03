<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/inc/header.jsp" %>

<%
request.setAttribute("user", "김코딩");
%>

<div class="body_layout">
    <div class="tit_bg">
        <h1>회원정보</h1>
    </div>
    <div class="content_layout">
        <p>
            User: <c:out value="${user }"></c:out>
        </p>
    </div>
</div>

<%@ include file="/inc/footer.jsp" %>