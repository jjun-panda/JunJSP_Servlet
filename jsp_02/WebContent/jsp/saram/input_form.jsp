<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <h1>사람 정보 입력</h1>
    <form action="input_ok.do" method="post">
        <table>
            <tr>
                <th>아이디</th>
                <td><input name="id" value="test02" /></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input name="name" value="테스트02" /></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input name="email" value="test02@saram.com" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="저장" /></td>
            </tr>
        </table>
    </form>
    
<%@ include file="/inc/tail.jsp" %>