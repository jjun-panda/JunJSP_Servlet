<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>

    <div class="body_layout">
        <div class="tit_bg">
            <h1>Blog</h1>
        </div>
        
        <div class="content_layout">
            <input type="text" name="" placeholder="검색어를 입력해주세요" />
            <table>
                <tr class="tab">
                    <th>NO</th>
                    <th>TITLE</th>
                    <th>AUTHOR</th>
                    <th></th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>딸기우유는 어디가 맛있는가?</td>
                    <td>서울우유</td>
                    <td><input type="button" value="자세히 보기" required /></td>
                </tr>
            </table>
            <a href="input.do">새글 작성하기</a>
        </div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>