<%@page import="org.mybatis.example.model.Blog"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>블로그 상세페이지</h1>
        </div>
        
        <div class="content_layout">
            <%
                Blog blog = (Blog)request.getAttribute("blog");
            %>
            <div class="blogContents">
                <p class="title"><%=blog.getTitle() %></p>
                <p class="author">작성자: <%=blog.getAuthor() %></p>
                <p class="content"><%=blog.getContent() %></p>
            </div>

            <a href="modify.do?id=<%=blog.getId()%>">수정</a>
            <a href="delete.do?id=<%=blog.getId()%>">삭제</a>
            <a href="list.do">목록</a>
        </div>
    </div>


<%@ include file="/inc/footer.jsp" %>