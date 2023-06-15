<%@page import="org.comstudy.myweb.shop.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

	<div class="body_layout">
		<div class="tit_bg">
			<h1>상품 목록</h1>
		</div>
		
		<div class="content_layout">
			<table>
				<tr class="tab">
					<th>번호</th>
					<th>상품명</th>
					<th>단가</th>
					<th></th>
				</tr>
				<%
				List<Product> pList = (List<Product>)request.getAttribute("productList");
				if(pList != null){
					for(int i=0; i<pList.size(); i++){
						Product product = pList.get(i);
				%>
					<tr>
						<td><%=product.getSeq() %></td>
						<td><%=product.getpName() %></td>
						<td><%=product.getPrice() %></td>
						<td><a href="product_detail.do?seq=<%=product.getSeq() %>"><input type="button" value="상세 보기" /></td>
					</tr>
				<%
					}
				}
				%>
			</table>
		</div>
	</div>
	

<%@ include file="/inc/footer.jsp" %>