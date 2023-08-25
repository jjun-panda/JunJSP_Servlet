<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>코딩이의 홈페이지</h1>
        </div>
        
        <div class="content_layout">
            <ul>
                <li><a href="member/list.do">멤버 목록</a></li>
                <li><a href="member/input.do">멤버 등록</a></li>
                <li><a href="member/search.do">멤버 조회</a></li>
            </ul>
            <hr/>
            <ul>
                <li><a href="hello.do">Hello Servlet</a></li>
                <li><a href="hello2.do">Hello Forward</a></li>
            </ul>
        </div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>