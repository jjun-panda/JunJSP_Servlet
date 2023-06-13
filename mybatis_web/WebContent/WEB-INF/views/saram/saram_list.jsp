<%@page import="org.mybatis.saram.model.Saram"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>사람 리스트</h1>
        </div>
        
        <div class="content_layout">
            <table>
                <tr class="tab">
                    <th>번호</th>
                    <th>이름</th>
                    <th>계정</th>
                    <th>이메일 주소</th>
                    <th></th>
                </tr>

                <%
                    List<Saram> list = (List<Saram>) request.getAttribute("list");
                    for (int i = 0; i < list.size(); i++) {
                        Saram saram = list.get(i);
                %>
                <tr>
					<td><%=saram.getSeq() %></td>
                    <td><%=saram.getName() %></td>
					<td><%=saram.getId() %></td>
					<td><%=saram.getEmail() %></td>
					<td><a href="detail.sa?seq=<%=saram.getSeq() %>"><input type="button" value="자세히 보기" /></a></td>
                </tr>
                <%
                    }
                %>
            </table>
            <a href="input.sa">사람 추가</a>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>
