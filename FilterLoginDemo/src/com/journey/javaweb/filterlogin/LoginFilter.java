package com.journey.javaweb.filterlogin;

import java.util.List;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter extends HttpFilter{
	
	//1. 从web.xml文件中获取 sessionKey, redirectUrl , uncheckedUrls
	private String sessionKey;
	private String redirectUrl;
	private String uncheckedUrls;
	
	@Override
	protected void init() {
		ServletContext servletConfig = getFilterConfig().getServletContext();
		sessionKey = servletConfig.getInitParameter("userSessionKey");
		redirectUrl = servletConfig.getInitParameter("rediretPage");
		///login/a.jsp,/login/list.jsp,/login/login.jsp,/login/doLogin.jsp
		uncheckedUrls = servletConfig.getInitParameter("uncheckedUrls");
	}
	
	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//1. 获取当前请求的servletPath
		String requestUrl = request.getRequestURL().toString();
		String requestUri = request.getRequestURI();
		String servletPath = request.getServletPath();
		
		
		System.out.println(requestUrl);
		System.out.println(requestUri);
		System.out.println(servletPath);
		//2. 检查 1 获取的servletPath 是否为不需要检查的URL 中的一个,若是,则直接放行。方法结束
		List<String> urlsList = Arrays.asList(uncheckedUrls.split(","));
		if(urlsList.contains(servletPath)){
			filterChain.doFilter(request, response);
			return;
		}
		//3. 从session中获取sessionkey对应的值,若值不存在,则重定向到redirectU
		Object userObject = request.getSession().getAttribute(sessionKey);
		if(userObject == null){
			response.sendRedirect(request.getContextPath()+redirectUrl);
			return;
		}
		//4. 若存在,则放行,允许访问
		filterChain.doFilter(request, response);
	}

}
