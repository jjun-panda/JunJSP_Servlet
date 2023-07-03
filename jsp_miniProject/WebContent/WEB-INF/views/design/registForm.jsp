<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>게시판목록</h1>
        </div>
        
        <div class="content_layout">
            <form action="regist.jsp" method="POST">
                <div>
                    <p>작성자</p>
                    <input type="text" name="author" placeholder="작성자를 입력해주세요" minlength="1" maxlength="10" required />
                </div>
                <div>
                    <p>유형</p>
                    <input type="text" name="type" placeholder="유형을 입력해주세요" required />
                </div>
                <div>
                    <p>제목</p>
                    <input type="text" name="name" placeholder="제목을 입력해주세요" minlength="1" maxlength="100" required />
                </div>
                <div>
                    <p>내용</p>
                    <textarea name="content" id="" cols="30" rows="10" placeholder="내용을 입력해주세요"></textarea>
                </div>
                <input type="submit" value="추가" />
            </form>
        </div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>