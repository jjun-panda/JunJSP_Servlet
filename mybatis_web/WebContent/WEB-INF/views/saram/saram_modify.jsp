<%@page import="org.mybatis.saram.model.Saram"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>
<%
Saram saram = (Saram)request.getAttribute("saram");
%>
    <div class="body_layout">
        <div class="tit_bg">
            <h1>수정하기</h1>
        </div>
        <div class="content_layout">
            <form action="input.sa" method="POST">
                <div>
                    <p>이름</p>
                    <input type="text" name="name" value="<%= saram.getName() %>" required />
                </div>
                <div>
                    <p>계정</p>
                    <input type="text" name="id" value="<%= saram.getId() %>" required />
                </div>
                <div>
                    <p>이메일 주소</p>
                    <input type="email" name="email" placeholder="<%= saram.getEmail() %>" required />
                </div>
                <hr />
                <input type="hidden" name="seq" value="<%= saram.getSeq() %>" required />
                <input type="submit" value="수정" />
            </form>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>