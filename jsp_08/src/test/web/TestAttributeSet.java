package test.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class TestAttributeSet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter()
		.append("Served at: ")
		.append(request.getContextPath());
		
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		
		application.setAttribute("context", "context 변수");
		session.setAttribute("session", "session 변수");
		request.setAttribute("request", "request 변수");
		
		response.sendRedirect("get");

	}

}
