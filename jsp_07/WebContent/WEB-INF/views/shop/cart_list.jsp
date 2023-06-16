<%@page import="org.comstudy.myweb.shop.Product"%>
<%@page import="java.util.List"%>
<%@ page import="java.text.DecimalFormat" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>장바구니 목록</h1>
        </div>
        
        <div class="content_layout">
			<%
			int totalPrice = 0;
			List<Product> pList = (List<Product>) request.getAttribute("cartList");
			// 1,000 단위로 변환하는 DecimalFormat 객체 생성
			DecimalFormat decimalFormat = new DecimalFormat("#,##0");
			if (pList != null && !pList.isEmpty()) {
			%>
			<table>
				<tr class="tab">
					<th>번호</th>
					<th>상품명</th>
					<th>단가</th>
					<th>수량</th>
					<th>합계</th>
					<th></th>
				</tr>
					<%
					for (int i = 0; i < pList.size(); i++) {
					Product product = pList.get(i);
					int total = product.getPrice() * product.getEa();
					totalPrice += total;
					%>
					<tr>
						<td><%=product.getSeq() %></td>
						<td><%=product.getpName() %></td>
						<td><%= decimalFormat.format(product.getPrice()) %></td>
						<td><%= product.getEa() %></td>
						<td><%= decimalFormat.format(total) %> 만원</td>
						<td>
							<a href="cart_delete.do?seq=<%=product.getSeq() %>" onclick="return confirm('정말로 삭제하시겠습니까?')"><input type="button" value="삭제" /></a>
						</td>
					</tr>
					<%
					}
					%>
			</table>
			<p class="cartTotal">총 합계 &nbsp;<span><%= decimalFormat.format(totalPrice) %> 만원</span></p>
			<%
			} else {
			%>
				<p class="drtail_tit">장바구니에 상품이 없습니다.</p>
			<% } %>
            <hr/>
            <a href="product_list.do"><input id="sebButton" type="button" value="상품 목록"></a>
		</div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>
