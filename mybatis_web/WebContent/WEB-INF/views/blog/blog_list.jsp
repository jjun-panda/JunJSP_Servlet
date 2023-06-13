<%@page import="org.mybatis.example.model.Blog"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>블로그 목록</h1>
        </div>
        
        <div class="content_layout">
            <table>
                <tr class="tab">
                    <th>NO</th>
                    <th>ID</th>
                    <th>TITLE</th>
                    <th>AUTHOR</th>
                    <th></th>
                </tr>

                <%
                    List<Blog> list = (List<Blog>) request.getAttribute("list");
                    for (int i = 0; i < list.size(); i++) {
                        Blog blog = list.get(i);
                %>
                <tr>
                    <td><%=i %></td>
                    <td><%=blog.getId()%></td>
                    <td><a href="detail.do?id=<%=blog.getId()%>"><%=blog.getTitle()%></a></td>
                    <td><%=blog.getAuthor()%></td>
                </tr>
                <%
                    }
                %>
            </table>
            <a href="input.do">새글 작성하기</a>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>
