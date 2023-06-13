<%@page import="org.mybatis.member.model.Member"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>
<%
Member member = (Member)request.getAttribute("member");
%>
    <div class="body_layout">
        <div class="tit_bg">
            <h1>수정하기</h1>
        </div>
        <div class="content_layout">
            <form action="input.me" method="POST">
                <div>
                    <p>성명</p>
                    <input type="text" name="name" value="<%= member.getName() %>" required />
                </div>
                <div>
                    <p>키</p>
                    <input type="text" name="height" value="<%= member.getHeight() %>" required />
                </div>
                <div>
                    <p>몸무게</p>
                    <input type="text" name="weight" value="<%= member.getWeight() %>" required />
                </div>
                <div>
                    <p>나이</p>
                    <input type="text" name="age" value="<%= member.getAge() %>" required />
                </div>
                <div>
                    <p>성별</p>
                    <% String memberGender = member.getGender();%>
                    <label><input class="checkboxGender" type="radio" name="gender" value="남자" <%= memberGender.equals("남자") ? "checked" : "" %> /><em></em><span>남자</span></label>
                    <label><input class="checkboxGender" type="radio" name="gender" value="여자" <%= memberGender.equals("여자") ? "checked" : "" %> /><em></em><span>여자</span></label>           
                </div>
                <hr />
                <input type="hidden" name="seq" value="<%= member.getSeq() %>" required />
                <input type="submit" value="수정" />
            </form>
        </div>
    </div>

<%@ include file="/inc/footer.jsp" %>