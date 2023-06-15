package org.comstudy.myweb.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myweb.shop.ShopController;

public class DispatcherServlet extends HttpServlet {
	ShopController shopCtrl = new ShopController();
	ViewResolver viewResolver = new ViewResolver();

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
    
		viewResolver.setPrefix(getInitParameter("prefix"));
		viewResolver.setSuffix(getInitParameter("suffix"));

		// System.out.println("doProcess() - DispatcherServlet");

		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		int beginIndex = ctxPath.length();
		String path = reqUri.substring(beginIndex);
		
		int endIndex = path.lastIndexOf("/");
		String dirPath = "/home";
		if(beginIndex < reqUri.lastIndexOf("/")) {
			dirPath = path.substring(0, endIndex);
		}
		String filePath = path.substring(dirPath.length());
		req.setAttribute("filePath", filePath);
		req.setAttribute("dirPath", dirPath);

		String viewName = shopCtrl.execute(req);

		viewResolver.forward(viewName, req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("doGet - DispatcherServlet");

		// Enumeration<String> paramNames = getInitParameterNames();
		// while(paramNames.hasMoreElements()) {
		// 	System.out.println(paramNames.nextElement());
		// }

		// String prefix = getInitParameter("prefix");
		// String suffix = getInitParameter("suffix");
		// System.out.println("prefix => " + prefix);
		// System.out.println("suffix => " + suffix);

		viewResolver.setPrefix(getInitParameter("prefix"));
		viewResolver.setSuffix(getInitParameter("suffix"));
		viewResolver.forward("home", req, resp);

		// contest-param 사용하기
		ServletContext application = req.getServletContext();
		String user = application.getInitParameter("user");
		// System.out.println("context param - user => "+ user);

		// Resource as Stream 사용하기
		InputStream is = application.getResourceAsStream("/WEB-INF/file.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String data = br.readLine();
		StringTokenizer strtk = new StringTokenizer(data, "&");
		// System.out.println("url => " + strtk.nextToken());
		// System.out.println("user => " + strtk.nextToken());
		// System.out.println("password => " + strtk.nextToken());
		// application.log("url => " + strtk.nextToken());
		// application.log("user => " + strtk.nextToken());
		// application.log("password => " + strtk.nextToken());

	}
}
