package com.journey.javaweb.tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ReadFileTag extends SimpleTagSupport{
	//相当于当前WEB 应用的根路径的文件名
	private String src;
	
	public void setSrc(String src){
		this.src = src;
	}
	
	public void doTag() throws JspException , IOException{
		PageContext pageContext = (PageContext) getJspContext();
		InputStream is = pageContext.getServletContext().getResourceAsStream(src);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		String str = null;
		while((str=reader.readLine())!=null){
			
			str = Pattern.compile("<").matcher(str).replaceAll("&lt");
			str = Pattern.compile(">").matcher(str).replaceAll("&gt");
			
			pageContext.getOut().println(str);
			pageContext.getOut().println("<br>");
		}
	}
}
