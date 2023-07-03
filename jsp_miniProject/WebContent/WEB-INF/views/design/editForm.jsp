<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.design.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="dao" class="com.design.DesignDAO"/>

<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	DesignDTO dto = dao.selectOne(seq);
	pageContext.setAttribute("dto", dto);
%>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>수정하기</h1>
        </div>
        
        <div class="content_layout">
            <form action="edit.jsp" method="POST">
                <div>
                    <input type="hidden" name="seq" value="${dto.seq}" />
                </div>
                <div>
                    <p>작성자</p>
                    <input type="text" name="author" value="${dto.action}" required disabled />
                </div>
                <div>
                    <p>유형</p>
                    <input type="text" name="type" value="${dto.type}" required />
                </div>
                <div>
                    <p>제목</p>
                    <input type="text" name="name" value="${dto.name}" required />
                </div>
                <div>
                    <p>내용</p>
                    <textarea name="content" id="" cols="30" rows="10" placeholder="내용을 입력해주세요">${dto.content}</textarea>
                </div>
                <input type="submit" value="수정" />
            </form>
        </div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>