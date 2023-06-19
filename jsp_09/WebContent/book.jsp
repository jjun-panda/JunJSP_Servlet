<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP World!</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index.css" type="text/css">
</head>
<body>
    <%
    String no = request.getParameter("main");
    if (no == null)no = "1";
    String centerFile = "/main/main"+no+".jsp";
    %>

    <div id="root">
        <!-- haeder -->
        <%@ include file="/inc/top.jsp" %>
        
        <!-- body -->
        <div class="body_layout">
            <div class="bodybg">
                <%@ include file="/inc/left.jsp" %>
                <jsp:include page="<%=centerFile %>"></jsp:include>
            </div>
        </div>

        <!-- footer -->
        <%@ include file="/inc/bottom.jsp" %>
    </div>

</body>
</html>
