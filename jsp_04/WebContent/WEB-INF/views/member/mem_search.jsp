<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>

<div class="body_layout">
    <h1>멤버 검색</h1>
    <div class="content_layout">
        <form action="search_list.do" method="post">
            검색어 : <input type="text" name="SearchName" value="김코딩" />
            <br />
            <input type="submit" value="검색" />
        </form>
    </div>
</div>

<%@ include file="/inc/footer.jsp" %>