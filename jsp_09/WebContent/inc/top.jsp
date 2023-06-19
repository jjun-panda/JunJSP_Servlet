<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="header_layout">
        <div class="hearderbg" >
            <div class="menuL">
                <a href="<%=request.getContextPath() %>"><img class="logoimg" src="<%=request.getContextPath() %>/img/booklogo.png" alt="Book24"></a>
                <ul class="menu">
                    <li><a href="?main=1">도서목록</a></li>
                    <li><a href="?main=2">베스트셀러</a></li>
                    <li><a href="?main=3">신간도서</a></li>
                    <li><a href="?main=4">회원리뷰</a></li>
                    <li><a href="?main=5">독자추천게시판</a></li>
                </ul>
            </div>
            <form action="">
                <!-- <div class="menuR_1">
                    <select name="" id="">
                        <option>전체</option>
                        <option>문학</option>
                        <option>사회</option>
                    </select>
                    <select name="" id="">
                        <option>제목</option>
                        <option>저자</option>
                        <option>출판사</option>
                    </select>
                </div> -->
                <div class="menuR_2">
                    <input type="text" name="" id="/">
                    <input type="button" value="검색">
                </div>
            </form>
        </div>
    </div>
