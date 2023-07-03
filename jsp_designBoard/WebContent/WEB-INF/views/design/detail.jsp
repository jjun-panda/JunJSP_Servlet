<%@page import="org.com.model.DesignDTO"%>
<%@page import="org.com.model.DesignDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="/inc/header.jsp" %>
<div>
	
</div>
<div class="body_layout">
        <div class="tit_bg">
            <h1>글 정보</h1>
        </div>
        <%
        String numParam = request.getParameter("num");
		String action = request.getParameter("action");
		
		if (numParam != null && action != null && action.equals("updateReadCnt")) {
		int num = Integer.parseInt(numParam);
			
		DesignDTO dto = new DesignDTO();
		dto.setNum(num);
			
		DesignDAO designDAO = new DesignDAO();
		designDAO.updateReadCnt(dto);
		}
		%>
        <div class="content_layout">
			<p>번호:${design.num}</p>
			<p>제목:[${design.typename}] ${design.title}</p>
			<p>작성자:${design.author}</p>
			<p>내용:${design.content}</p>
			<p>작성일:${fn:substring(design.writedate, 0, 16)}</p>
			<p>조회수:${design.readcnt}</p>
			
            <a href="edit.do?num=${design.num}"><input type="button" value="수정" /></a>
			<a href="delete.do?num=${design.num}"><input type="button" value="삭제" onclick="return confirm('정말로 삭제하시겠습니까?')" /></a>
			<a href="list.do"><input type="button" value="목록" /></a>
        </div>
    </div>


<%@ include file="/inc/footer.jsp" %>