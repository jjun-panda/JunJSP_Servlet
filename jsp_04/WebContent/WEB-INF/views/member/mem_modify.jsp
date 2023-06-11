<%@ page import="org.comstudy.member.model.MemberDAO"%>
<%@ page import="org.comstudy.member.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

<%
MemberDAO dao = new MemberDAO();
MemberDTO member = (MemberDTO) request.getAttribute("member");

if (request.getParameter("seq") != null) {
    int seq = Integer.parseInt(request.getParameter("seq"));
    member = dao.findBySeq(seq);
}
%>

<div class="body_layout">
    <div class="tit_bg">
        <h1>수정하기</h1>
    </div>
    <div class="content_layout">
        <form action="modify_ok.do" method="post">
            <div>
                <p>성명</p>
                <input type="text" name="name" value="<%= member.getName() %>" />
            </div>
           
            <div>
                <p>키</p>
                <input type="text" name="height" value="<%= member.getHeight() %>" />
            </div>
            <div>
                <p>몸무게</p>
                <input type="text" name="weight" value="<%= member.getWeight() %>" />
            </div>
            <div>
                <p>나이</p>
                <input type="text" name="age" value="<%= member.getAge() %>" />
            </div>
            <div>
                <p>성별</p>
			    <% String memberGender = member.getGender();%>
                <input class="checkboxGender" type="radio" name="gender" value="남자" <%= memberGender.equals("남자") ? "checked=\"checked\"" : "" %> /><em></em><span>남자</span>
                <input class="checkboxGender" type="radio" name="gender" value="여자" <%= memberGender.equals("남자") ? "checked=\"checked\"" : "" %> /><em></em><span>여자</span>           
            </div>
            <hr />
            <input type="hidden" name="seq" value="<%= member.getSeq() %>" />
            <input type="submit" value="수정" />
        </form>
    </div>
</div>

<%@ include file="/inc/footer.jsp" %>
