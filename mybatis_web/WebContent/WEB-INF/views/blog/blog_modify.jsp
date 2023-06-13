<%@page import="org.mybatis.example.model.Blog"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>
<%
Blog blog = (Blog)request.getAttribute("blog");
%>
    <div class="body_layout">
        <div class="tit_bg">
            <h1>수정하기</h1>
        </div>
        <div class="content_layout">
            <form action="input.do" method="POST">
                <div>
                    <p>작성자</p>
                    <input type="text" name="author" value="<%=blog.getAuthor()%>" required />
                </div>
                <div>
                    <p>제목</p>
                    <input type="text" name="title" value="<%=blog.getTitle()%>" required />
                </div>
                <div>
                    <p>내용</p>
                    <textarea type="text" name="content" rows="5" required ><%=blog.getContent()%></textarea>
                </div>
                <hr />
                <input type="hidden" name="id" value="<%=blog.getId()%>" />
                <input type="submit" value="수정" />
            </form>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>