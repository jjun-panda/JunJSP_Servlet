<%@page import="org.mybatis.member.model.Member"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
			<h1>멤버 상세 보기</h1>
        </div>
        
        <div class="content_layout">
            <%
                Member member = (Member)request.getAttribute("member");
            %>
            <p class="detailtit">[ <span><%=member.getName() %></span> ]님의 나이는 [ <span><%=member.getAge() %>세</span> ].<br />[ <span><%=member.getGender() %></span> ] 그리고, <br /> 키는 [ <span><%=member.getHeight() %>cm</span> ]이고, <br />몸무게는 [ <span><%=member.getWeight() %>kg</span> ]입니다.</p>
			<hr />
            <a href="modify.me?seq=<%=member.getSeq()%>">수정</a>
            <a href="delete.me?seq=<%=member.getSeq()%>">삭제</a>
            <a href="list.me">목록</a>
        </div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>