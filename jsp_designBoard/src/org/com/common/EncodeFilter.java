package org.com.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodeFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		int beginIndex = ctxPath.length();
		String path = reqUri.substring(beginIndex);
		String dirPath = path.substring(0, path.lastIndexOf("/"));
		String filePath = path.substring(path.lastIndexOf("/"));
		
		req.setAttribute("path", path);
		req.setAttribute("dirPath", dirPath);
		req.setAttribute("filePath", filePath);
		
		chain.doFilter(request, response);
	}

}
