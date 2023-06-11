<%@ page import="org.comstudy.member.model.MemberDAO"%>
<%@ page import="org.comstudy.member.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/inc/header.jsp" %>

<div class="body_layout">
    <div class="tit_bg">
        <h1>멤버 상세 보기</h1>
    </div>
    <%
    MemberDTO member = (MemberDTO)request.getAttribute("member");
    %>
    <div class="content_layout">
	    <p class="drtail_tit">[ <span><%=member.getName() %></span> ]님의 나이는 [ <span><%=member.getAge() %>세</span> ].<br />[ <span><%=member.getGender() %></span> ] 그리고, <br /> 키는 [ <span><%=member.getHeight() %>cm</span> ]이고, <br />몸무게는 [ <span><%=member.getWeight() %>kg</span> ]입니다.</p>
        <hr />
        <div>
            <a href="modify.do?seq=<%=member.getSeq() %>">수정하기</a>
            <a href="delete.do?seq=<%=member.getSeq() %>">삭제하기</a>
        </div>
    </div>
</div>

<%@ include file="/inc/footer.jsp" %>