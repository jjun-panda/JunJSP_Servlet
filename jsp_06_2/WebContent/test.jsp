<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>홈페이지</h1>
        </div>
        
        <div class="content_layout">
            <%
            String user = application.getInitParameter("user");
            %>
            <p>user : <%=user %></p>
            <%
            String realPath = application.getRealPath("./");
            %>
            <p>realPath : <%=realPath %></p>
        </div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>