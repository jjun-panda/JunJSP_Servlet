package org.comstudy.myweb.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myweb.controller.Controller;
import org.comstudy.myweb.controller.ModelAndView;

public class BoardController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView("board/list");
		String fileName = (String)req.getAttribute("filePath");
		System.out.println("file name => " + fileName);
		
		if("/list.do".equals(fileName)) {
			mav.setViewName("board/list");
		} else if("/input.do".equals(fileName)) {
			mav.setViewName("board/input");
		} else if("/detail.do".equals(fileName)) {
			mav.setViewName("board/detail");
		} else if("/modify.do".equals(fileName)) {
			mav.setViewName("board/modify");
		}
		
		return mav;
	}

}
