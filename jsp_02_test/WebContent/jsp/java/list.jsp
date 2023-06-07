<%@ page import="model.SaramDAO"%>
<%@ page import="model.SaramDTO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>

<%!
private SaramDAO dao = new SaramDAO();
%>

<p class="title32x">Java List</p>
<table>
    <%
    List<SaramDTO> list = dao.selectAll();
    if(list != null && list.size() > 0) {
        for(SaramDTO saram : list) {
    %>
    <tr>
        <td><%=saram.getSeq() %></td>
        <td><%=saram.getId() %></td>
        <td><%=saram.getName() %></td>
        <td><%=saram.getEmail() %></td>
        <td><a href="detail.jsp?seq=<%=saram.getSeq() %>"><input type="button" value="자세히보기" /></a></td>
    </tr>
    <%
        }
    }
    %>
</table>

<p>
    <a href="input_form.jsp"><input type="button" value="추가하기" /></a>
</p>

<%@ include file="/inc/tail.jsp" %>
