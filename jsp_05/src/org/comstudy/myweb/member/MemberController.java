package org.comstudy.myweb.member;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.comstudy.myweb.controller.Controller;
import org.comstudy.myweb.controller.ModelAndView;

public class MemberController implements Controller {

	private String adminUser = "admin@gmail.com";
	private String adminPass = "admin1234";
	HttpSession session;

	@Override
	public ModelAndView execute(HttpServletRequest req) {
		session = req.getSession();
		ModelAndView modelAndView = new ModelAndView();
		
		String filePath = (String)req.getAttribute("filePath");

		if("/login.do".equals(filePath)) {
        if("GET".equals( req.getMethod()) ) {
				modelAndView.setViewName("member/login");
        } else if("POST".equals( req.getMethod())) {
				String id = req.getParameter("id");
				String password = req.getParameter("password");
				String[] checkbox = req.getParameterValues("checkbox");
				System.out.println("id => " + id);
				System.out.println("password => " + password);
				System.out.println("checkbox => " + Arrays.toString(checkbox));
				// modelAndView.setViewName("redirect:list.do");

				if(id.equals(adminUser) && password.equals(adminPass)) {
					session.setAttribute("user_id", id);
					session.setAttribute("user_name", "홍길동");
					System.out.println(">>> 로그인 성공!");
				}
				modelAndView.setViewName("redirect:login.do");
			}
		} else if("/logout.do".equals(filePath)) {
			// 브라우저가 열려 있어도 session을 비우면 로그아웃이다.
			//session.removeAttribute("user_id");
			session.invalidate(); // 세션의 모든 정보를 한꺼번에 삭제한다.
			modelAndView.setViewName("redirect:login.do");
		} else if("/list.do".equals(filePath)) {
			modelAndView.setViewName("member/list");
			modelAndView.addObject("message", "Hello member");
		}

		return modelAndView;
	}
}