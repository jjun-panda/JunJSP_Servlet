<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="m" class="test.web.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="m" />
<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>회원정보</h1>
        </div>
        <div class="content_layout">
            <%
            out.println(m);
            %>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>