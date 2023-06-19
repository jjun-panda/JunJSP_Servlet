<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="content_layout">
            <%
            String name = request.getParameter("userName");
            if(name==null || name.length()==0) {
            %>
            <jsp:forward page="handeit.jsp">
                <jsp:param value='<%=URLEncoder.encode("다시 입력하세요!", "UTF-8") %>' name="msg" />
            </jsp:forward>
            <%
            } // end of if
            %>
            <p class="drtail_tit">Welcome to my page <br />Hello! <span><%=name %></span>!</p>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>