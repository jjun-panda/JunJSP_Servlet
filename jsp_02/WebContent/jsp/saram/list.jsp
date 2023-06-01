<%@ page import="model.SaramDAO"%>
<%@ page import="model.SaramDTO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

	<%!
	// 선언부
	private SaramDAO dao = new SaramDAO();
	%>

	<h1>사람 목록</h1>
	<table >
	<%
	// 스크립트 릿
	List<SaramDTO> list = dao.selectAll();
	if(list != null && list.size() > 0) {
		for(SaramDTO saram : list) {
	%>
			<!-- HTML문법 사용가능 -->
			<tr>
				<td><%=saram.getSeq() %></td>
				<td><%=saram.getId() %></td>
				<td><%=saram.getName() %></td>
				<td><%=saram.getEmail() %></td>
				<td><a href="detail.jsp?seq=<%=saram.getSeq() %>"><input type="button" value="자세히 보기" /></a></td>
			</tr>
	<%
		} // end of for
	} // end of if
	%>
	</table>

	<p>
		<a href="input_form.jsp">입력</a>
	</p>
	
<%@ include file="/inc/tail.jsp" %>
