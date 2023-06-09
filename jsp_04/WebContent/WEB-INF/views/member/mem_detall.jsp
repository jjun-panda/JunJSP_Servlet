<%@page import="org.comstudy.member.model.MemberDAO"%>
<%@page import="org.comstudy.member.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>

<div class="body_layout">
    <h1>멤버 상세 보기</h1>
    <%
    MemberDTO member = (MemberDTO)request.getAttribute("member");
    %>
    <div class="content_layout">
        <p><%=member.toString() %></p>
        <hr />
        <p>수정 | 삭제</p>
    </div>
</div>

<%@ include file="/inc/footer.jsp" %>