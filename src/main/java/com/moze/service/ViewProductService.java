package com.moze.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moze.dao.ViewItems;
import com.moze.dao.ViewProduct;
import com.moze.pojo.Item;
import com.moze.pojo.Product;

public class ViewProductService {
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public void productQuery(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ViewProduct pro=new ViewProduct();
		List <Product> list=pro.likeProductList(request.getParameter("keyword"));
		
		request.setAttribute("productList", list);
		
	
	}
	public void getItemList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		String productId=(String)request.getParameter("productid");
		List <Item> list=showItemByProductId(productId);

		request.setAttribute("itemsList", list);
		
		
		
		
	}

	private List<Item> showItemByProductId(String productId) {
		// TODO Auto-generated method stub
		ViewProduct pro=new ViewProduct();
		ViewItems items=new ViewItems();
		pro.setItems(items);
		List <Item> list=pro.showItemsByProductId(productId);
		return list;
	}
	
}
