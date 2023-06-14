package org.comstudy.myweb.controller;

import javax.servlet.http.HttpServletRequest;

public interface Controller {
	ModelAndView execute(HttpServletRequest req);
}
