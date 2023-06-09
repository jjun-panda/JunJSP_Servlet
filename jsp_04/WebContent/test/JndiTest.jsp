<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

<%
// https://tomcat.apache.org/tomcat-9.0-doc/jndi-resources-howto.html#JDBC_Data_Sources
Context initCtx = new InitialContext();
Context envCtx = (Context) initCtx.lookup("java:comp/env");
DataSource ds = (DataSource)
  envCtx.lookup("jdbc/MemberDB");

Connection conn = ds.getConnection();

out.println(conn);

conn.close();
%>

<%@ include file="/inc/footer.jsp" %>