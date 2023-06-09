<%@page import="org.comstudy.member.model.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>

    <h1>Hello view page</h1>

    <%
    List<MemberDTO> memList = (List<MemberDTO>)request.getAttribute("memList");
        for(MemberDTO member : memList) {
    %>
            <p><%=member.toString() %></p>
    <%
        }
    %>
<%@ include file="/inc/footer.jsp" %>