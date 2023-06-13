<%@page import="org.mybatis.saram.model.Saram"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
			<h1>상세 보기</h1>
        </div>
        
        <div class="content_layout">
            <%
                Saram saram = (Saram)request.getAttribute("saram");
            %>
            <p class="detailtit">[ <span><%=saram.getName() %></span> ]님의 계정은 [ <span><%=saram.getId() %></span> ].<br />이메일 주소는 <br />[ <span><%=saram.getEmail() %></span> ] 입니다.</p>
			<hr />
            <a href="modify.sa?seq=<%=saram.getSeq()%>">수정</a>
            <a href="delete.sa?seq=<%=saram.getSeq()%>">삭제</a>
            <a href="list.sa">목록</a>
        </div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>