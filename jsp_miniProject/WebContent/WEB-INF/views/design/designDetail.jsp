<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.design.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="dao" class="com.design.DesignDAO"/>

<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	DesignDTO dto = dao.selectOne(seq);
	pageContext.setAttribute("dto", dto);
%>

<%@ include file="/inc/header.jsp" %>
<div class="body_layout">
        <div class="tit_bg">
            <h1>글 정보</h1>
        </div>
        
        <div class="content_layout">
			<p>번호:${dto.seq}</p>
			<p>제목:${dto.name}</p>
			<p>작성자:${desing.author}</p>
			<p>내용:${dto.content}</p>
			<p>등록일자:${dto.regdate}</p>
			<p>조회수:${dto.cnt}</p>
			
            <a href="<c:url value="/WEB-INF/views/design/editForm.jsp?num=${dto.seq}"/>"><button>수정</button></a>
			<a href="<c:url value="/WEB-INF/views/design/deleteForm.jsp?num=${dto.seq}"/>"><button>삭제</button></a>
			<a href="<c:url value="/WEB-INF/views/design/list.jsp"/>"><button>목록</button></a>
        </div>
    </div>


<%@ include file="/inc/footer.jsp" %>