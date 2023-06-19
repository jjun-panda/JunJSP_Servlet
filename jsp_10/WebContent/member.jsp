<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

<%!
private String name;
private String age;
private String weight;
private String height;
private String gender;
%>
<%
request.setCharacterEncoding("UTF-8");
name = request.getParameter("name");
age = request.getParameter("age");
weight = request.getParameter("weight");
height = request.getParameter("height");
gender = request.getParameter("gender");
%>
    <div class="body_layout">
        <div class="tit_bg">
            <h1>회원정보</h1>
        </div>
        <div class="content_layout">
            <p>name | <span><%=name%></span></p>
            <p>age | <span><%=age%></span></p>
            <p>weight | <span><%=weight%></span></p>
            <p>height | <span><%=height%></span></p>
            <p>gender | <span><%=gender%></span></p>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>