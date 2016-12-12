package com.moze.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.moze.db.DruidDB;
import com.moze.pojo.Banner;
import com.moze.pojo.Profile;
import com.moze.pojo.User;

public class LoginUser {
	private Connection getConn(){	

		return DruidDB.getConnection();

	}
	public User loginUser(User user){

		String sql="select * from account,profile,banner "+ 
		"where account.username='"+user.getUsername().trim()+"' and "+
		"profile.username='"+user.getUsername().trim()+"' and "+
		"account.password='"+user.getPassword().trim()+"' and "+
		"profile.favcategory=banner.favcategory";



		Statement stmt=null;
		ResultSet rs=null;
		User result=new User();
		Banner banner=new Banner();
		Profile profile=new Profile();
		try {
			stmt=this.getConn().createStatement();

			rs=stmt.executeQuery(sql);				
			
			while(rs.next()){
					banner.setBannername(rs.getString("bannername"));
					banner.setFavcategory(rs.getString("favcategory"));
					banner.setUsername(rs.getString("username"));
					profile.setFavcategory(rs.getString("favcategory"));
					profile.setLangpref(rs.getString("langpref"));
					profile.setUsername(rs.getString("username"));
					result.setXm(rs.getString("xm"));
					result.setPassword(rs.getString("password"));
					result.setEmail(rs.getString("Email"));
					result.setAddress(rs.getString("address"));
					result.setUsername(rs.getString("username"));
					result.setFavcategory(rs.getString("favcategory"));
					result.setBanner(banner);
					result.setProfile(profile);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;

	}
}
