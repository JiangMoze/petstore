package com.moze.dao;

import com.moze.db.DruidDB;
import com.moze.pojo.Inventory;
import com.moze.pojo.Item;
import com.moze.pojo.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ViewItems {
	private Connection getConn(){

		return DruidDB.getConnection();

	}
	//通过用户名，得到当前用户的喜爱宠物
	public List<Product> showFavItems(String username){
		String sql="(select * from product as p"+
				" where p.category=" +
				" (select favcategory from profile where username='"+username+"'))";
		Statement stmt=null;
		ResultSet rs=null;
		List<Product> list=null;
		try {
			stmt=this.getConn().createStatement();
			rs=stmt.executeQuery(sql);
			list=new ArrayList<Product>();
			while(rs.next()){
				Product product=new Product();
				product.setName(rs.getString("name"));
				product.setProductid(rs.getString("productid"));
				list.add(product);
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
		return list;
	}
	public List<Item> showItems(String productId){
		String sql="select * from item where productid='"+productId+
				"' order by itemid" ;
		Statement stmt=null;
		ResultSet rs=null;
		List<Item> list=null;
		try {
			stmt=this.getConn().createStatement();

			rs=stmt.executeQuery(sql);
			list=new ArrayList<Item>();
			while(rs.next()){
				Item item=new Item();
				item.setItemid(rs.getString("itemid"));
				item.setProductid(rs.getString("productid"));
				item.setListprice(rs.getFloat("listprice"));



				item.setAttr1(rs.getString("attr1"));
				list.add(item);
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
		return list;


	}

	public Item showItem(String itemId){
		String sql="select * from item,inventory,product where item.itemid='"+itemId+
				"' and item.itemid=inventory.itemid and  item.productid=product.productid" ;
		Statement stmt=null;
		ResultSet rs=null;
		Item item=new Item();
		Inventory inventory=new Inventory();
		Product product=new Product();
		try {
			stmt=this.getConn().createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				item.setItemid(rs.getString("itemid"));
				item.setProductid(rs.getString("productid"));
				item.setListprice(rs.getFloat("listprice"));



				item.setAttr1(rs.getString("attr1"));
				item.setInventory(inventory);
				item.setProduct(product);
				item.getInventory().setItemid(rs.getString("itemid"));

				item.getInventory().setQty(rs.getInt("qty"));
				if(rs.getInt("qty")>0){
					item.setIsStock("OK");//有库存
				}
				item.getProduct().setDescn(rs.getString("descn"));

				item.getProduct().setName(rs.getString("name"));
				item.getProduct().setCategory(rs.getString("category"));
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
		return item;


	}

}
