package com.moze.dao;

import com.moze.db.DruidDB;
import com.moze.pojo.Item;
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
public class ViewProduct {
	private ViewItems items;
	public ViewItems getItems() {
		return items;
	}
	public void setItems(ViewItems items) {
		this.items = items;
	}
	private Connection getConn(){

		return DruidDB.getConnection();

	}
	public List <Item> showItemsByProductId(String productId){
		List <Item>list=this.items.showItems(productId);
		return list;
	}
	public List<Product> likeProductList(String keyword){
		String sql="select * from product where " +
				"category like '%"+keyword.trim()+"%' or " +
				"name like '%"+keyword.trim()+"%' or " +
				"descn like '%"+keyword.trim()+"%' " +
				"order by productid" ;
		Statement stmt=null;
		ResultSet rs=null;
		List<Product> list=null;
		try {
			stmt=this.getConn().createStatement();

			rs=stmt.executeQuery(sql);
			list=new ArrayList<Product>();
			while(rs.next()){
				Product product=new Product();
				product.setProductid(rs.getString("productid"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setDescn(rs.getString("descn"));
				list.add(product);
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
	public List<Product> showProduct(String category){
		String sql="select * from product where category='"+
				category.toUpperCase()+"' order by productid" ;
		Statement stmt=null;
		ResultSet rs=null;
		List<Product> list=null;
		try {
			stmt=this.getConn().createStatement();

			rs=stmt.executeQuery(sql);
			list=new ArrayList<Product>();
			while(rs.next()){
				Product product=new Product();
				product.setProductid(rs.getString("productid"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setDescn(rs.getString("descn"));
				list.add(product);
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
