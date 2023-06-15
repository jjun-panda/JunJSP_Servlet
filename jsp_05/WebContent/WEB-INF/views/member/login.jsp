<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>
<script>
    function formatLoginTime(loginTime) {
        var year = loginTime.getFullYear();
        var month = (loginTime.getMonth() + 1).toString().padStart(2, '0');
        var day = loginTime.getDate().toString().padStart(2, '0');
        var hours = loginTime.getHours().toString().padStart(2, '0');
        var minutes = loginTime.getMinutes().toString().padStart(2, '0');
        var seconds = loginTime.getSeconds().toString().padStart(2, '0');

        var formattedTime = year + "." + month + "." + day + "  " + hours + ":" + minutes + ":" + seconds;
        return formattedTime;
    }

    function displayLoginTime() {
        var loginTimeElement = document.getElementById("login-time");
        if (loginTimeElement) {
            var loginTime = new Date();
            loginTimeElement.innerHTML = formatLoginTime(loginTime);
        }
    }

    window.onload = function () {
        displayLoginTime();
    };
</script>


    <div class="body_layout">
        <div class="tit_bg">
            <h1>Member</h1>
        </div>
        
        <div class="content_layout">
            <%
            String userId = (String)session.getAttribute("user_id");
            String userName = (String)session.getAttribute("user_name");
            Date now = new Date();
            
            if(userId != null) {
            %>
            <p class="detailtit">[ <span><%=userName %></span> ] 님 환영합니다.</p>
            <!-- <p><strong>로그인한 계정:</strong> <%=userId %></p>
            <p><strong>로그인한 시간:</strong> <span id="login-time"></span></p> -->
            <br /><br />
            <p><a href="logout.do">로그아웃</a></p>
            <%
            } else {
                out.println("로그인 전입니다.");
            %>
            <form method="post">
                <div>
                    <p>이메일주소</p>
                    <input type="email" name="id" placeholder="이메일주소를 입력해주세요" required />
                </div>
                <div>
                    <p>비밀번호</p>
                    <input type="password" name="password" placeholder="비밀번호를 입력해주세요" minlength="4" required />
                </div>
                <div>
                    <p>분야</p>
                    <div class="checkOp">
                        <label><input class="checkboxBox" type="checkbox" name="checkbox" value="UX" /><em></em><span>UX Design</span></label>
                        <label><input class="checkboxBox" type="checkbox" name="checkbox" value="UI" /><em></em><span>UI Design</span></label>
                        <label><input class="checkboxBox" type="checkbox" name="checkbox" value="BX" /><em></em><span>BX Design</span></label>
                        <label><input class="checkboxBox" type="checkbox" name="checkbox" value="AI" /><em></em><span>AI Design</span></label>
                    </div>
                </div>     
                <hr />
                <input type="submit" value="로그인" />
            </form>
            <%
            }
            %>
        </div>
    </div>
    

<%@ include file="/inc/footer.jsp" %>