package org.comstudy.myweb;

import javax.servlet.http.HttpServletRequest;

import org.comstudy.myweb.controller.Controller;
import org.comstudy.myweb.controller.ModelAndView;

public class HomeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName(("home"));
		modelAndView.addObject("message", "Home Page");

		return modelAndView;
	}
}
