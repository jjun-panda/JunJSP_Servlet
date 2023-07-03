<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
            <div>
                <p>성명</p>
                <p>${m.name}</p>
            </div>
            <div>
                <p>나이</p>
                <p>${m.age}</p>
            </div>
            <div>
                <p>몸무게</p>
                <p>${m.weight}</p>
            </div>
            <div>
                <p>키</p>
                <p>${m.height}</p>
            </div>
            <div>
                <p>성별</p>
                <p>${m.gender}</p>
            </div>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>