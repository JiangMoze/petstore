/**
 *
 */
package com.moze.dao;

import com.moze.db.DruidDB;
import com.moze.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * @author Administrator
 *
 */
public class RegisterUser {
	private Connection getConn(){

		return DruidDB.getConnection();
	}
	private boolean IsUserSame(User user){//判断是否有用户重名
		String sql="select * from account where username=?";

		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		try {
			pstmt=this.getConn().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			rs=pstmt.executeQuery();
			while(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return flag;
	}
	private int registerEditProfile(User user){
		String sql="update profile set langpref='"+user.getLangpref()+"', favcategory='" +user.getFavcategory()+"'"+
				" where username='"+user.getUsername()+"'";

		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=this.getConn().prepareStatement(sql);


			result=pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {

				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;


	}
	private int registerProfile(User user){

		String sql="insert into profile(username,favcategory)" +
				"values(?,?)";

		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=this.getConn().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());

			pstmt.setString(2, user.getFavcategory());

			result=pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {

				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}

	public int registerUser(User user){
		if(IsUserSame(user)){//有重复用户
			return 0;
		}
		String sql="insert into account(username,password,email,xm,address,status)" +
				"values(?,?,?,?,?,?)";

		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=this.getConn().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getXm());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, "OK");//登录状态
			result=pstmt.executeUpdate();
			if(result>0){
				registerProfile(user);//存储用户的喜爱设置
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {

				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}
	public int registerEditUser(User user){

		String sql="update account set password='"+user.getPassword()+
				"' ,email='"+user.getEmail()+
				"' ,xm='"+user.getXm()+
				"' ,address='" +user.getAddress()+
				"' where username='"+user.getUsername()+"'";

		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=this.getConn().prepareStatement(sql);



			result=pstmt.executeUpdate();
			if(result>0){
				registerEditProfile(user);//修改用户的喜爱设置
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {

				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;

	}

}
