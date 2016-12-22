package com.moze.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moze.dao.ViewItems;
import com.moze.pojo.Item;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/12/07.
 */
public class ViewItemService {
	public void getItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String itemId=(String)request.getParameter("itemid");
		Item item=showItemByItemId(itemId);

		request.setAttribute("item", item);
	}
	
	private Item showItemByItemId(String itemId) {
		ViewItems vitem=new ViewItems();		
		Item item=vitem.showItem(itemId);
		return item;
	}
}
