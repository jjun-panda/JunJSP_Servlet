<%@page import="org.comstudy.model.SaramDTO"%>
<%@page import="org.comstudy.model.SaramDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>

<h1>수정 페이지</h1>
<%
SaramDAO dao = new SaramDAO();
SaramDTO saram = null;

if(request.getParameter("seq") != null) {
   int seq = Integer.parseInt(request.getParameter("seq"));
   saram = dao.findBySeq(seq);
}
%>
<form action="modify_ok.jsp" method="post">
   <input type="hidden" value="<%=saram.getSeq() %>" />
   <table>
      <tr>
         <th>SEQ</th><td><%=saram.getSeq() %></td>
      </tr>
      <tr>
         <th>아이디</th><td><input name="id" value="<%=saram.getId() %>" /></td>
      </tr>
      <tr>
         <th>성명</th><td><input name="name" value="<%=saram.getName() %>" /></td>
      </tr>
      <tr>
         <th>이메일</th><td><input name="email" value="<%=saram.getEmail() %>" /></td>
      </tr>
      <tr>
         <td><input type="submit" value="저장" /></td>
      </tr>
   </table>
</form>

<%@ include file="/inc/tail.jsp" %>