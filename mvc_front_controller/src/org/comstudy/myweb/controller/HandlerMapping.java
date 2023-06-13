package org.comstudy.myweb.controller;

import java.util.HashMap;

import org.comstudy.myweb.blog.controller.BlogController;
import org.comstudy.myweb.board.controller.BoardController;
import org.comstudy.myweb.gallery.controller.GalleryController;
import org.comstudy.myweb.member.controller.MemberController;

public class HandlerMapping {
	HashMap<String, Controller> ctrlMap = new HashMap<String, Controller>();
	
	public HandlerMapping() {
		ctrlMap.put("/blog", new BlogController());
		ctrlMap.put("/board", new BoardController());
		ctrlMap.put("/gallery", new GalleryController());
		ctrlMap.put("/member", new MemberController());
	}
	
	public Controller getController(String path) {
		return ctrlMap.get(path);
	}
}
