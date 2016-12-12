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
 * @author Administrator
 *
 */
public class EditUserService {
	public void editUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		HttpSession session = request.getSession();
		RegisterUser userDAO=new RegisterUser();
		User user=new User();
		user.setUsername(session.getAttribute("username").toString());		
		user.setPassword(request.getParameter("pwd"));
		user.setEmail(request.getParameter("email"));
		user.setXm(request.getParameter("xm"));		
		user.setAddress(request.getParameter("address"));
		user.setFavcategory(request.getParameter("fav"));		
		if(userDAO.registerEditUser(user)>0){
			//重新登录
			LoginUser login=new LoginUser(); 
			
			user=login.loginUser(user);
			if(user.getXm()!=null){							
				session.setAttribute("username", user.getUsername());
				session.setAttribute("password", user.getPassword());
				session.setAttribute("xm", user.getXm());
				session.setAttribute("bannername", user.getBanner().getBannername());
				
			}
		}
		
	}


}
