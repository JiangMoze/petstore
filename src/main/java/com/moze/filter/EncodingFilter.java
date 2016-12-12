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


	/*
	 * ���й��˴��������������Ҫ����Ҳ���Ի�ó�ʼ������
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */

	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
	
//		HttpServletRequest�ӿ��Ǽ̳���ServletRequest�ӿڵġ������˺�HTTP��ص�һЩ������   

		HttpServletRequest request=(HttpServletRequest)srequest;
		request.setCharacterEncoding(targetEncoding);
		
		//�Ѵ���Ȩ��������һ��,����һ��������������
		chain.doFilter(srequest, sresponse);
		
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig=config;
		this.targetEncoding=config.getInitParameter("encoding");//ȡ�������ļ��ı���
		
		
	}
	public void setFilterConfig(final FilterConfig filterConfig){
		this.filterConfig=filterConfig;
		
	}

}
