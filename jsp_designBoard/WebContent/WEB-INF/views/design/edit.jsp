<%@page import="org.com.model.DesignDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>수정하기</h1>
        </div>
        
        <div class="content_layout">
            <form action="edit.do" method="POST">
                <div>
                    <input type="hidden" name="num" value="${design.num}" />
                </div>
                <div>
                    <p>작성자</p>
                    <input type="text" name="author" value="${design.author}" required disabled />
                </div>
                <div>
                    <p>유형</p>
                    <!-- <select name="typename"" id="">
                        <option value="">유형을 선택해주세요</option>
                        <option value="디자인이론">디자인 이론</option>
                        <option value="디자인철학">디자인 철학</option>
                        <option value="디자인실습">디자인 실습</option>
                    </select> -->
                    <input type="text" name="typename" value="${design.typename}" required />
                </div>
                <div>
                    <p>제목</p>
                    <input type="text" name="title" value="${design.title}" required />
                </div>
                <div>
                    <p>내용</p>
                    <textarea name="content" id="" cols="30" rows="10" placeholder="내용을 입력해주세요">${design.content}</textarea>
                </div>
                <input type="submit" value="수정" />
            </form>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>