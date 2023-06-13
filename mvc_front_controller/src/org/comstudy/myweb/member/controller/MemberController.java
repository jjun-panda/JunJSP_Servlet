package org.comstudy.myweb.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myweb.controller.Controller;
import org.comstudy.myweb.controller.ModelAndView;

public class MemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView("member/list");
		String fileName = (String)req.getAttribute("filePath");
		System.out.println("file name => " + fileName);
		
		if("/list.do".equals(fileName)) {
			mav.setViewName("member/list");
		} else if("/input.do".equals(fileName)) {
			mav.setViewName("member/input");
		} else if("/detail.do".equals(fileName)) {
			mav.setViewName("member/detail");
		} else if("/modify.do".equals(fileName)) {
			mav.setViewName("member/modify");
		}
		
		return mav;
	}

}
