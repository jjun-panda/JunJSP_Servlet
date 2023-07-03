<%@page import="org.com.model.DesignDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/inc/header.jsp" %>

    <div class="layoutBody">
        <div class="bodyBg">
            <div class="container">
                <div class="titBg">
                    <p>게시판목록</p>
                </div>
                <div class="content_layout">
                    <table>
                        <tr>
                            <th class="seqTable"></th>
                            <th class="titTable">제목</th>
                            <th class="authTable">작성자</th>
                            <th class="dayTable">작성일</th>
                            <th class="readTable">조회수</th>
                        </tr>
                        <c:forEach var="design" items="${list}">
                            <tr>
                                <td>${design.num}</td>
                                <td class="titContent"><span>${design.typename}</span><a href="detail.do?num=${design.num}&action=updateReadCnt">${design.title}</a></td>
                                <td>${design.author}</td>
                                <td>${fn:substring(design.writedate, 0, 10)}</td>
                                <td>${design.readcnt}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="btns">
                        <a href="write.do" class="write">글등록</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>
