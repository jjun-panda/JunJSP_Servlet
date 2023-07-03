<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/inc/header.jsp" %>

<div class="body_layout">
    <div class="tit_bg">
        <h1>회원목록</h1>
    </div>
    <div class="content_layout">
        <table>
            <tr class="tab">
                <th>성명</th>
                <th>나이</th>
                <th>몸무게</th>
                <th>키</th>
                <th>성별</th>
            </tr>
            <c:forEach var="mem" items="${list }">
                <tr>
                    <td>${mem.name }</td>
                    <td>${mem.age }세</td>
                    <td>${mem.weight }kg</td>
                    <td>${mem.height }cm</td>
                    <td>${mem.gender }</td>
                </tr>
            </c:forEach>
        </table>
        
    </div>
</div>

<%@ include file="/inc/footer.jsp" %>