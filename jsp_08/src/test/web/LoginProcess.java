package test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/login")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();

		String dirPath = (String)request.getAttribute("dirPath");
		String filePath = (String)request.getAttribute("filePath");
		
		System.out.println("dirPath : " + dirPath);
		System.out.println("filePath : " + filePath);
		// parameter의 기본 타입은 문자열
		String user = request.getParameter("userName");
		String id = request.getParameter("userID");
		String pass = request.getParameter("password");

		// BindingListener Test
		Login login = new Login(user, id, pass);
		session.setAttribute("login", login);

		response.getWriter()
		.append("Served at: ")
		.append(request.getContextPath())
		.append("<br/>")
		.append("user name : " + user + "<br />")
		.append("user id : " + id + "<br />")
		.append("password : " + pass + "<br />")
		.append("총 접속자 수 : " + Login.getTotal() + "<br />")
		.append("현재 접속된 브라우저 수 : " + SessionListener.activeSession);
	}
}
