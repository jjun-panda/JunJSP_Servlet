<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="sumError.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<%
int max = Integer.parseInt(request.getParameter("max"));
int sum = 0;
for(int i=1; i<=max; i++) {
    sum += i;
}
%>
    <div class="body_layout">
        <div class="tit_bg">
            <h1>합계 출력</h1>
        </div>
        <div class="content_layout">
            <form>
                <p>1부터 <%=max %>까지의 합은 <%=sum %> 입니다.</p>
                <input type="submit" value="확인" />
            </form>
        </div>
    </div>
</body>
</html>