package com.journey.javaweb.encoding;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.journey.javaweb.cache.HttpFilter;

public class EncodingFilter extends HttpFilter{
	
	
	
	private String encoding;
	
	@Override
	protected void init() {
		encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
	}
	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(encoding);
		System.out.println(encoding);
		filterChain.doFilter(request, response);
	}

}
