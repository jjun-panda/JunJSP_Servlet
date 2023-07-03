<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코딩이의 홈페이지</title>
<link rel="icon" type="image/png" sizes="32x32" href="http://jjuns-c.com//components/favicon-32x32.png">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index.css" type="text/css">
</head>
<body>
    <div id="root">
        <div class="navHeader">
            <div class="container">
                <div class="navContainer">
                    <a href="<%=request.getContextPath() %>" class="logoForm">
                        <img class="logoImg" src="http://jjuns-c.com//components/jjun_logo_f.svg" alt="jjun_logo">
                        <div class="logoName"></div>
                    </a>
                    <ul class="navMenu">
                        <a class="" href="<%=request.getContextPath() %>/design/list.do">
                            <li>게시판</li>
                        </a>
                        <a class="" href="<%=request.getContextPath() %>/design/write.do" onclick="return confirm('준비중입니다')">
                            <li>쇼핑몰</li>
                        </a>
                        <a class="" href="http://www.jjuns-c.com/">
                            <li>개인사이트</li>
                        </a>
                        <a class="" href="http://www.jjuns-c.com/designsystem">
                            <li>디자인시스템</li>
                        </a>
                    </ul>
                    <div class="navIcon">
                        <a href="" class="iconImg"><img src="http://jjuns-c.com//components/icon/ico_shoppingcart.svg" alt="장바구니"></a>
                        <a href="" class="iconImg"><img src="http://jjuns-c.com//components/icon/ico_user.svg" alt="로그인"></a>
                    </div>
                </div>
            </div>
        </div>