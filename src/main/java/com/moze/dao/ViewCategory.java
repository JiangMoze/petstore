package com.moze.dao;

import com.moze.db.DruidDB;
import com.moze.pojo.Category;
import com.moze.pojo.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/12/07.
 */
public class ViewCategory {
	private Connection getConn(){

		return DruidDB.getConnection();

	}
	private ViewProduct product;
	public ViewProduct getProduct() {
		return product;
	}
	public void setProduct(ViewProduct product) {
		this.product = product;
	}
	public List<Product> showProductByCategory(String category){
		List <Product>list=this.product.showProduct(category);
		return list;
	}
	public List<Category> showCategoryList(){
		String sql="select * from category ";

		Statement stmt=null;
		ResultSet rs=null;
		List<Category> list=null;
		try {
			stmt=this.getConn().createStatement();

			rs=stmt.executeQuery(sql);
			list=new ArrayList<Category>();
			while(rs.next()){
				Category category=new Category();
				category.setCatid(rs.getString("catid"));
				category.setName(rs.getString("name"));
				list.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}


}
