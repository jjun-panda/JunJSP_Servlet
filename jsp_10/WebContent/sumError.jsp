<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
    <div style="text-align: center; height: 100vh; flex-grow: 1; display: flex; flex-direction: column; justify-content: center;">
        <div style="max-width: 640px; margin: 0 auto;">
            <img src="<%=request.getContextPath() %>/img/404_img.png" alt="" style="width: 100%;">
        </div>
        <h1>페이지를 찾을 수 없습니다!</h1>
        <a href="sum.html"><input type="button" value="다시 하기" /></a>
    </div>
</body>
</html>