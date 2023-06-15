<%@page import="org.comstudy.myweb.shop.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

<div class="body_layout">
    <div class="tit_bg">
        <h1>상품 상세보기</h1>
    </div>
    <%
    Product product = (Product)request.getAttribute("product");
    int totalPrice = product.getPrice() * product.getEa();
    %>
    <div class="content_layout">
        <p class="drtail_tit">
            상품명 [ <span><%=product.getpName() %></span> - <span><%=product.getPrice() %>만원</span> ]
            <br />
            <br />
            <input id="ea" type="number" name="ea" value="1" min="1" onchange="calculateTotal()">
            개 구매할래요!
            <!-- <br />[ <span id="totalPrice"><%=totalPrice %> 만원</span> ] 입니다. -->
        </p>
        <hr />
        <script>
            // function calculateTotal() {
            //     var inputEa = document.getElementById("ea");
            //     var totalPrice = <%=product.getPrice() %> * parseInt(inputEa.value);
            //     document.getElementById("totalPrice").innerHTML = totalPrice.toLocaleString() + " 만원";
            // }

            function addCart() {
                var inputEa = document.getElementById("ea");
                var sendUrl = 'cart_list.do?seq=<%=product.getSeq()%>&ea=' + inputEa.value;
                console.log(sendUrl);
                location.href = sendUrl;
            }
        </script>
        <a href="javascript:addCart()"><input id="sebButton" type="button" value="장바구니 추가"></a>
    </div>
</div>

<%@ include file="/inc/footer.jsp" %>
