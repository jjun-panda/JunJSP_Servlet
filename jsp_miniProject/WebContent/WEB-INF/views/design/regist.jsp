<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.design.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dto" class="com.design.DesignDTO"/>
<jsp:useBean id="dao" class="com.design.DesignDAO"/>
<jsp:setProperty name="dto" property="*"/>

<%
	dao.insert(dto);

	response.sendRedirect(request.getContextPath() + "/WEB-INF/views/design/list.jsp");
%>
<c:redirect url="${pageContext.request.contextPath}/list.jsp"></c:redirect> 
<!-- 등록 후 리스트로 -->