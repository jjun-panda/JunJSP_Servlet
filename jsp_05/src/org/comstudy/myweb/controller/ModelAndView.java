package org.comstudy.myweb.controller;

import java.util.Hashtable;

public class ModelAndView {
	private String viewName;
	private Hashtable<String, Object> models = new Hashtable<String, Object>();
	
	public ModelAndView() {
		this("");
	}
	
	public ModelAndView(String viewName) {
		this.viewName = viewName;
	}
	
	public void addObject(String key, Object value) {
		models.put(key, value);
	}
	
	public Object getObjcet(String key) {
		return models.get(key);
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
}