package com.moze.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moze.dao.ViewCategory;
import com.moze.dao.ViewProduct;
import com.moze.pojo.Product;

/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/12/07.
 */
public class ViewCategoryService {
	public void getProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category=(String)request.getParameter("category");
		List <Product> list=showProductByCategory(category);
		request.setAttribute("productList", list);
		
		
	}
	private List <Product>  showProductByCategory(String category) {
		ViewCategory cate=new ViewCategory();
		ViewProduct product=new ViewProduct();
		cate.setProduct(product);
		List <Product> list=cate.showProductByCategory(category);
		return list;
	}
}
