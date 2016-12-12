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

public class ViewCategoryService {
	public void getProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
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
