package com.journey.javaweb;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Second init...");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Before SecondFilter's doFilter...");
		chain.doFilter(request, response);
		System.out.println("After SecondFilter's doFilter...");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Second destroy...");
	}
	
}
