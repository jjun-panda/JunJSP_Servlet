package org.comstudy.myweb.blog;

import javax.servlet.http.HttpServletRequest;

import org.comstudy.myweb.controller.Controller;
import org.comstudy.myweb.controller.ModelAndView;

public class BlogController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req){
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("blog/list");
		modelAndView.addObject("message", "Hello blog");

		return modelAndView;
	}
}
