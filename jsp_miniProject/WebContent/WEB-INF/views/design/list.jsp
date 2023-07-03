<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.design.*, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/inc/header.jsp" %>
<%
DesignDAO dao = new DesignDAO();
List<DesignDTO> list = dao.selectAll();
%>
    <div class="body_layout">
        <div class="tit_bg">
            <h1>게시판목록</h1>
        </div>
        
        <div class="content_layout">
            <table>
                <tr>
                    <th>번호</th>
                    <th>유형</th>
                    <th>제목</th>
                    <th>작성자</th>
                </tr>
                <c:forEach var="dto" items="${list }">
                    <tr>
                        <td>${dto.seq }</td>
                        <td>${dto.type }</td>
                        <td>${dto.name }</td>
                        <td>${dto.author }</td>
                    </tr>
                </c:forEach>
            </table>
            <a href="<c:url value="/WEB-INF/views/design/registForm.jsp"/>"><button>글등록</button></a>
        </div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>