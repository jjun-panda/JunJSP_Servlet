<%@ page import="model.SaramDTO"%>
<%@ page import="model.SaramDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

<h1>상세 정보 보기</h1>
<%
//파라미터는 모두 문자열이다. 
//정수로 형변환 하기 위해 Integer.parseInt() 사용.
int seq = Integer.parseInt(request.getParameter("seq"));
SaramDAO dao = new SaramDAO();
SaramDTO saram = dao.findBySeq(seq);
%>

seq : <%=seq %><br/>
saram : <%=saram %><br/>

<hr>
<table>
    <tr>
        <th>번호</th>
        <td><%=saram.getSeq() %></td>
    </tr>
    <tr>
        <th>아이디</th>
        <td><%=saram.getId() %></td>
    </tr>
    <tr>
        <th>이름</th>
        <td><%=saram.getName() %></td>
    </tr>
    <tr>
        <th>이메일주소</th>
        <td><%=saram.getEmail() %></td>
    </tr>
</table>
<div>
    <a href="modify_form.jsp?seq=<%=saram.getSeq() %>">수정하기</a>
    <a href="delete.jsp?seq=<%=saram.getSeq() %>">삭제하기</a>
</div>


<%@ include file="/inc/tail.jsp" %>

