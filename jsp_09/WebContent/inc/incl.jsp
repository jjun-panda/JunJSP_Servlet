<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>Hello JSP World!</h1>
        </div>
        <div class="content_layout">
            <img src="<%=request.getContextPath() %>/img/img_1.jpg" alt="선풍기">
        </div>
    </div>
