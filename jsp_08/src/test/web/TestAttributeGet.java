package test.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class TestAttributeGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		// setAttribute()로 바인딩 한 데이터를 gwtAttribute()로 가져오기
		String ctxMsg = (String) application.getAttribute("context");
		String sesMsg = (String) session.getAttribute("session");
		String reqMsg = (String) request.getAttribute("request");

		response.getWriter()
		.append("ctxMsg: " + ctxMsg)
		.append("sesMsg: " + sesMsg)
		.append("reqMsg: " + reqMsg);
	}

}
