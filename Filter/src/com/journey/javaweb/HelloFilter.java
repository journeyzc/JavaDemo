package com.journey.javaweb;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init...");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Before HelloFilter's chain.doFilter...");
		
		//放行
		chain.doFilter(request, response);
		
		System.out.println("After HelloFilter's chain.doFilter...");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy...");
	}

}
