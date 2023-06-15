package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();

		out.append("Served at: ").append(req.getContextPath());
		out.println("<p>Redriect 된다!!!</p>");

		// 주소가 같은 forward일 때 request 바인된다.
		req.setAttribute("name","홍길동");

		// 주소가 달라질 때는 request가 아닌 session에 바인해야된다.
		HttpSession session = req.getSession();
		session.setAttribute("name_session","김코딩");

		// 브라우저가 달라져도 session에 데이터 남아있다.
		ServletContext application = req.getServletContext();
		application.setAttribute("name_app","이코딩");
			
		//resp.sendRedirect("toHello");
		
		// forward
		RequestDispatcher view = req.getRequestDispatcher("toHello");
		view.forward(req, resp);
		out.close();
	}

}
