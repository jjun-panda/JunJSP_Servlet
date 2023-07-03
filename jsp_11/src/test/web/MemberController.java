package test.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static List<MemberBean> list = new ArrayList<MemberBean>();
	static {
		list.add(new MemberBean("Hong", "23", "85", "180", "M"));
		list.add(new MemberBean("Kim", "22", "65", "160", "F"));
		list.add(new MemberBean("Lee", "21", "75", "170", "M"));
		list.add(new MemberBean("Park", "26", "85", "180", "F"));
		list.add(new MemberBean("Kang", "24", "98", "180", "M"));

	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("list", list);
		
		String path = "/WEB-INF/views/member/list.jsp";
		RequestDispatcher view = request.getRequestDispatcher(path);
		view.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}