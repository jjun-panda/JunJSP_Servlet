<%@ page import="model.SaramDTO"%>
<%@ page import="model.SaramDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/header.jsp" %>
<%
SaramDAO dao = new SaramDAO();
SaramDTO saram = null;

if(request.getParameter("seq") != null) {
    int seq = Integer.parseInt(request.getParameter("seq"));
    saram = dao.findBySeq(seq);
}
%>
	<h1>수정하기</h1>
    <form action="modify_ok.jsp" method="post">
        <table>
            <tr>
                <th>아이디</th>
                <td><input name="id" value="<%=saram.getId() %>" /></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input name="name" value="<%=saram.getName() %>" /></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input name="email" value="<%=saram.getEmail() %>" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="수정" /><a></a></td>
            </tr>
        </table>
    </form>

<%@ include file="/inc/tail.jsp" %>