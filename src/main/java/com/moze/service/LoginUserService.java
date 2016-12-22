package com.moze.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moze.dao.LoginUser;
import com.moze.pojo.User;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/12/07.
 */
public class LoginUserService {
	private static final long serialVersionUID = 1L;

	public boolean loginUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginUser userdao=new LoginUser();	
		User user=new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("pwd"));
		User result=userdao.loginUser(user);
		if(result.getXm()!=null){			
			
			HttpSession session = request.getSession();
			session.setAttribute("username", result.getUsername());
			session.setAttribute("password", result.getPassword());
			session.setAttribute("xm", result.getXm());
			session.setAttribute("bannername", result.getBanner().getBannername());
			return true;
		}else{
			return false;
		}
		
		
		
	}
	
}
