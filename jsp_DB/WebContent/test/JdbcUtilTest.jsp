<%@page import="org.comstudy.dbcp.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/header.jsp" %>

    <%
    Connection conn = JdbcUtil.getConnection();
    out.println(conn);
    %>

<%@ include file="/inc/footer.jsp" %>