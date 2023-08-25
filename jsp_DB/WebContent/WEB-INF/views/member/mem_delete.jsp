<%@ page import="org.comstudy.member.model.MemberDAO"%>
<%@ page import="org.comstudy.member.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/header.jsp" %>

<h1>삭제하기</h1>
<%
int seq = Integer.parseInt(request.getParameter("seq"));
MemberDAO dao = new MemberDAO();
MemberDTO member = new MemberDTO(seq, "");
dao.delete(member);

response.sendRedirect("list.do");

%>

<%@ include file="/inc/footer.jsp" %>