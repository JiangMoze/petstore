package com.moze.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moze.dao.OperationOrder;
import com.moze.pojo.Cart;
import com.moze.pojo.Order;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/12/07.
 */
public class OrderService {
	//保存订单
	@SuppressWarnings("unchecked")
	public void ordersave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OperationOrder oorder=new OperationOrder();
		Order order=new Order();
		order.setUserid(request.getSession().getAttribute("username").toString());
		order.setShipname(request.getParameter("xm"));
		order.setShipaddr(request.getParameter("address"));
		order.setShipcity(request.getParameter("city"));
		order.setCardno(request.getParameter("cardno"));
		order.setCardtype(request.getParameter("cardtypevalue"));
		order.setTotalprice(request.getParameter("totalprice"));
		List<Cart> list=(List)request.getSession().getAttribute("cartList");
		if((oorder.saveOrder(order)&(oorder.saveOrderDetail(list)))){
			//提交成功后清空相应的session
			request.getSession().removeAttribute("cartList");
			request.getSession().removeAttribute("subcost");
			CartService.cartlist.clear();
			CartService.itemidlist.clear();

		}

	}

	//生成订单
	public String ordermain(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getSession().getAttribute("username")==null){
			return "login";
		}else{
			
			return "MAIN";
		}
	}
}
