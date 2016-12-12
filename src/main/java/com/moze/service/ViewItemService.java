package com.moze.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moze.dao.ViewItems;
import com.moze.pojo.Item;

public class ViewItemService {
	public void getItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String itemId=(String)request.getParameter("itemid");
		Item item=showItemByItemId(itemId);

		request.setAttribute("item", item);
	}
	
	private Item showItemByItemId(String itemId) {
		// TODO Auto-generated method stub
		ViewItems vitem=new ViewItems();		
		Item item=vitem.showItem(itemId);
		return item;
	}
}
