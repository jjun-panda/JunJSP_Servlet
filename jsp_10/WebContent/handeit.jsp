<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>앗! 로그인이 필요해요</h1>
        </div>
        <div class="content_layout">
            <form action="hello.jsp" method="get">
                <div>
                    <p>사용자명</p>
                    <input type="text" name="userName" placeholder="사용자명을 입력해주세요" required />
                    <%
                    request.setCharacterEncoding("UTF-8");
                    String msg = request.getParameter("msg");
                    if(msg != null) {
                    %>
                    <p>경고 : <%=URLDecoder.decode(msg, "UTF-8") %></p>
                    <%
                    }
                    %>
                </div>
                <div>
                    <p>비밀번호</p>
                    <input type="password" name="password" placeholder="비밀번호를 입력해주세요" minlength="4" required />
                </div>  
                <input type="submit" value="로그인" />
            </form>
        </div>
    </div>
    
<%@ include file="/inc/footer.jsp" %>