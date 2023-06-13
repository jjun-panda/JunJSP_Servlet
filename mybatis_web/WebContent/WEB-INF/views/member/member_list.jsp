<%@page import="org.mybatis.member.model.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>멤버 리스트</h1>
        </div>
        
        <div class="content_layout">
            <table>
                <tr class="tab">
                    <th>번호</th>
                    <th>성명</th>
                    <th>키</th>
                    <th>몸무게</th>
                    <th>나이</th>
                    <th>성별</th>
                    <th></th>
                </tr>

                <%
                    List<Member> list = (List<Member>) request.getAttribute("list");
                    for (int i = 0; i < list.size(); i++) {
                        Member member = list.get(i);
                %>
                <tr>
					<td><%=member.getSeq() %></td>
					<td><%=member.getName() %></td>
					<td><%=member.getHeight() %>cm</td>
					<td><%=member.getWeight() %>kg</td>
					<td><%=member.getAge() %>세</td>
					<td><%=member.getGender() %></td>
					<td><a href="detail.me?seq=<%=member.getSeq() %>"><input type="button" value="자세히 보기" /></a></td>
                </tr>
                <%
                    }
                %>
            </table>
            <a href="input.me">멤버 추가</a>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>
