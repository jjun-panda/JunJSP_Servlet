<%@page import="org.comstudy.myweb.shop.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>삭제 페이지</h1>
        </div>
        
        <div class="content_layout">
            <p class="drtail_tit">해당 상품 삭제했습니다.</p>
            <hr/>
            <a href="cart_list.do"><input id="sebButton" type="button" value="장바구니"></a>
            <a href="product_list.do"><input id="sebButton" type="button" value="상품 목록"></a>
		</div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>
