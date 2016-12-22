package com.moze.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/12/07.
 */
public class EncodingFilter implements Filter {

	/**
	 * Constructor of the object.
	 */
	protected FilterConfig filterConfig;
	private String targetEncoding="utf-8";
	
	

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		this.filterConfig=null;
		
	}



	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) throws IOException, ServletException {


		HttpServletRequest request=(HttpServletRequest)srequest;
		request.setCharacterEncoding(targetEncoding);

		chain.doFilter(srequest, sresponse);
		
	}

	public void init(FilterConfig config) throws ServletException {

		this.filterConfig=config;
		this.targetEncoding=config.getInitParameter("encoding");
		
		
	}
	public void setFilterConfig(final FilterConfig filterConfig){
		this.filterConfig=filterConfig;
		
	}

}
