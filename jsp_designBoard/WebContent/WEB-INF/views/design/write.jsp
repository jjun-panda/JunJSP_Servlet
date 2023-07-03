<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ include file="/inc/header.jsp" %>

<div class="layoutBody">
    <div class="bodyBg">
        <div class="container">
            <div class="titBg">
                <p>글 작성</p>
            </div>
            <div class="content_layout">
                <form action="write.do" method="POST">
                    <div>
                        <p>작성자</p>
                        <input type="text" name="author" placeholder="작성자를 입력해주세요" minlength="1" maxlength="10" required />
                    </div>
                    <div>
                        <p>유형</p>
                        <select name="typename"" id="">
                            <option value="">유형을 선택해주세요</option>
                            <option value="디자인이론">디자인 이론</option>
                            <option value="디자인철학">디자인 철학</option>
                            <option value="디자인실습">디자인 실습</option>
                        </select>
                        <!-- <input type="text" name="typename" placeholder="유형을 입력해주세요" required /> -->
                    </div>
                    <div>
                        <p>제목</p>
                        <input type="text" name="title" placeholder="제목을 입력해주세요" minlength="1" maxlength="100" required />
                    </div>
                    <div>
                        <p>내용</p>
                        <textarea name="content" id="" cols="30" rows="10" placeholder="내용을 입력해주세요"></textarea>
                    </div>
                    <div>
                        <p>비밀번호</p>
                        <input type="password" name="password" placeholder="비밀번호를 입력해주세요" minlength="1" maxlength="100" required />
                    </div>
                    <div class="btns">
                        <input type="submit" value="추가" class="write" />
                        <a href="list.do" class="write">취소</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>