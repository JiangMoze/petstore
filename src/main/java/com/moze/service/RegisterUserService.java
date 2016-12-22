/**
 * 
 */
package com.moze.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moze.dao.LoginUser;
import com.moze.dao.RegisterUser;
import com.moze.pojo.User;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/12/07.
 */
public class RegisterUserService {
	//存储用户
	public void registerUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RegisterUser userDAO=new RegisterUser();
		User user=new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("pwd"));
		user.setEmail(request.getParameter("email"));
		user.setXm(request.getParameter("xm"));
		user.setAddress(request.getParameter("address"));
		user.setFavcategory(request.getParameter("fav"));
		if(userDAO.registerUser(user)>0){
			HttpSession session = request.getSession();
			//注册后，把用户取出来
			LoginUser userdao=new LoginUser();	
			User result=userdao.loginUser(user);			
			session.setAttribute("username", result.getUsername());
			session.setAttribute("password", result.getPassword());
			session.setAttribute("xm", result.getXm());
			session.setAttribute("bannername", result.getBanner().getBannername());
		}
	}
}
