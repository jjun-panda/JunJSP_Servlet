package org.comstudy.myweb.controller;

import java.util.Hashtable;

public class ModelAndView {
	String viewName;
	Hashtable<String, Object> model = new Hashtable<String, Object>();
	
	public ModelAndView() {
		viewName = "";
	}

	public ModelAndView(String viewName) {
		// "blog/list"
		this.viewName = viewName;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
}
