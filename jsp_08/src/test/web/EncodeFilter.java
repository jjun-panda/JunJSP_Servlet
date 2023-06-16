package test.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncodeFilter implements Filter {
	ServletContext application;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		application.log(">>> request filter...");

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
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
		
		long begin = System.currentTimeMillis();
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		application.log(">>> respose filter...");
		application.log(">>>>> 서블릿 실행 소요 시간: " + (end-begin)+"ms");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("EncodeFilter...");
		application = fConfig.getServletContext();
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
}
