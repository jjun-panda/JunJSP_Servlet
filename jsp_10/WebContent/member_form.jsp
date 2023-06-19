<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

<div class="body_layout">
    <div class="tit_bg">
        <h1>회원정보</h1>
    </div>
    <div class="content_layout">
        <form action="member.jsp" method="POST">
            <div>
                <p>성명</p>
                <input type="text" name="name" placeholder="이름을 입력해주세요" required />
            </div>
            <div>
                <p>나이</p>
                <input type="text" name="age" placeholder="나이를 입력해주세요" min="1" max="120" required />
            </div>
            <div>
                <p>몸무게</p>
                <input type="text" name="weight" placeholder="몸무게를 입력해주세요" min="5" max="150" required />
            </div>
            <div>
                <p>키</p>
                <input type="text" name="height" placeholder="키를 입력해주세요" min="100" max="250" required />
            </div>
            <div>
                <p>성별</p>
                <label><input class="checkboxGender" type="radio" name="gender" value="남자" checked="checked" /><em></em><span>남자</span></label>
                <label><input class="checkboxGender" type="radio" name="gender" value="여자" /><em></em><span>여자</span></label>
            </div>
            <input type="submit" value="보내기" />
        </form>
    </div>
</div>

<%@ include file="/inc/footer.jsp" %>