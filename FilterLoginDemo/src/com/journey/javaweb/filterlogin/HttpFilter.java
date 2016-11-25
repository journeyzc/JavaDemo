package com.journey.javaweb.filterlogin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的 HttpFilter, 实现自 Filter 接口
 * 
 * @author journey
 * 
 */
public abstract class HttpFilter implements Filter {

	/**
	 * 用于保存 FilterConfig 对象
	 */

	private FilterConfig filterConfig;

	/**
	 * 不建议子类直接覆盖, 若直接覆盖, 将可能会导致filterConfig 成员变量初始化失败
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = filterConfig;
		init();
	}

	/**
	 * 供子类继承的初始化方法,可以通过getFilterConfig() 获取FilterConfig 对象.
	 */
	protected void init() {
	}

	/**
	 * 直接返回 init(ServletConfig) 的 FilterConfig 对象
	 * 
	 * @return
	 */
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	/**
	 * 原生的 doFilter 方法, 在方法内部把 ServletRequest 和 ServletResponse 转为了
	 * HttpServletRequest 和 HttpServletResponse,并调用了doFilter(HttpServletRequest
	 * request, HttpServletResponse response , FilterChain filterChain)
	 * 
	 * 若编写 Filter 的过滤方法不建议直接继承方法. 而建议继承
	 * doFilter(HttpServletRequest
	 * request, HttpServletResponse response , FilterChain filterChain)
	 */
	public void doFilter(ServletRequest requ, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) requ;
		HttpServletResponse response = (HttpServletResponse) resp;
		doFilter(request, response, chain);
	}
	/**
	 * 抽象方法,为Http 请求定制,必须实现的方法
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	public abstract void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException;
	/**
	 * 空的 destroy 方法.
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
