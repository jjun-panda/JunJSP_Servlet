<%@page import="org.mybatis.saram.model.Saram"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

	<div class="body_layout">
		<div class="tit_bg">
			<h1>사람 추가</h1>
		</div>
		
		<div class="content_layout">
			<form action="input.sa" method="POST">
                <div>
                    <p>이름</p>
                    <input type="text" name="name" placeholder="이름을 입력해주세요" required />
                </div>
				<div>
                    <p>계정</p>
                    <input type="text" name="id" placeholder="계정을 입력해주세요" required />
                </div>
                <div>
                    <p>이메일 주소</p>
                    <input type="email" name="email" placeholder="이메일 주소를 입력해주세요" required />
                </div>
				<hr />
				<input type="submit" value="저장" />
			</form>
		</div>
	</div>

<%@ include file="/inc/footer.jsp" %>