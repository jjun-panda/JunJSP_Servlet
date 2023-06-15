package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/toHello")
public class ToHello extends HttpServlet{

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
        String name = (String)req.getAttribute("name");

		HttpSession session = req.getSession();
        String name2 = (String)session.getAttribute("name_session");
        
        ServletContext application = req.getServletContext();
        String name3 = (String)application.getAttribute("name_app");

		PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<p>Hello World!</p>");
        out.println("<p>name: " + name + "</p>");
        out.println("<p>name: " + name2 + "</p>");
        out.println("<p>name: " + name3 + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
