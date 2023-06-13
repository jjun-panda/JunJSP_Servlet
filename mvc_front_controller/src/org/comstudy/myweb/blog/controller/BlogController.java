package org.comstudy.myweb.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myweb.controller.Controller;
import org.comstudy.myweb.controller.ModelAndView;

public class BlogController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView("blog/list");
		String fileName = (String)req.getAttribute("filePath");
		System.out.println("file name => " + fileName);
		
		if("/list.do".equals(fileName)) {
			mav.setViewName("blog/list");
		} else if("/input.do".equals(fileName)) {
			mav.setViewName("blog/input");
		} else if("/detail.do".equals(fileName)) {
			mav.setViewName("blog/detail");
		} else if("/modify.do".equals(fileName)) {
			mav.setViewName("blog/modify");
		}
		
		return mav;
	}

}
