package com.moze.dao;

import com.moze.db.DruidDB;
import com.moze.pojo.Cart;
import com.moze.pojo.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class OperationOrder {
	private int orderid=1000;
	private Connection getConn(){

		return DruidDB.getConnection();

	}
	private void getOrderNo(){
		String sql="select orderid from orders  order by orderid desc";

		Statement stmt=null;
		ResultSet rs=null;

		try {
			stmt=this.getConn().createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()){//取得倒序好后的第一条记录
				orderid=rs.getInt("orderid");
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


	}
	//	/存储订单商品明细
	public boolean saveOrderDetail(List<Cart> cartList){
		String sql="insert into lineitem(orderid,itemid,quantity,unitprice) " +
				"values(?,?,?,?)";
		boolean flag=false;
		PreparedStatement pstmt=null;

		for(Cart cart :cartList){
			try {
				pstmt=this.getConn().prepareStatement(sql);
				pstmt.setInt(1, orderid);
				pstmt.setString(2, cart.getItemid());
				pstmt.setInt(3, cart.getQty());
				pstmt.setFloat(4, cart.getTotalcost());
				int i=pstmt.executeUpdate();
				if(i>0){
					flag=true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {

					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}


		return flag;
	}
	public boolean saveOrder(Order order){
		String sql="insert into orders(orderid,orderdate,userid,shipaddr,shipcity,shipname,cardno,cardtype,totalprice) " +
				"values(?,now(),?,?,?,?,?,?,?)";
		boolean flag=false;
		PreparedStatement pstmt=null;
		getOrderNo();
		try {
			pstmt=this.getConn().prepareStatement(sql);

			pstmt.setInt(1, orderid+1);
			pstmt.setString(2, order.getUserid());
			pstmt.setString(3,order.getShipaddr());
			pstmt.setString(4,order.getShipcity());
			pstmt.setString(5,order.getShipname());
			pstmt.setString(6,order.getCardno());
			pstmt.setString(7,order.getCardtype());
			pstmt.setFloat(8,Float.valueOf(order.getTotalprice()));
			int i=pstmt.executeUpdate();
			if(i>0){

				flag=true;
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

		return flag;
	}
}
