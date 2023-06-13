package org.comstudy.myweb.gallery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myweb.controller.Controller;
import org.comstudy.myweb.controller.ModelAndView;

public class GalleryController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView("gallery/list");
		String fileName = (String)req.getAttribute("filePath");
		System.out.println("file name => " + fileName);
		
		if("/list.do".equals(fileName)) {
			mav.setViewName("gallery/list");
		} else if("/input.do".equals(fileName)) {
			mav.setViewName("gallery/input");
		} else if("/detail.do".equals(fileName)) {
			mav.setViewName("gallery/detail");
		} else if("/modify.do".equals(fileName)) {
			mav.setViewName("gallery/modify");
		}
		
		return mav;
	}

}
