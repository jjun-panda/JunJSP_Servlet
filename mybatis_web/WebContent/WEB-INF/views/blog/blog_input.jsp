<%@page import="org.mybatis.example.model.Blog"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>새글 작성</h1>
        </div>
        
        <div class="content_layout">
            <form action="input.do" method="POST">
                <div>
                    <p>작성자</p>
                    <input type="text" name="author" placeholder="작성자를 입력해주세요" required />
                </div>
                <div>
                    <p>제목</p>
                    <input type="text" name="title" placeholder="제목을 입력해주세요" required />
                </div>
                <div>
                    <p>내용</p>
                    <textarea type="text" name="content" placeholder="내용을 입력해주세요" rows="5" required ></textarea>
                </div>  
                <hr />
                <input type="submit" value="저장" />
            </form>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>