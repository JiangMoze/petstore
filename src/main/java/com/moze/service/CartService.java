package com.moze.service;

import com.moze.dao.ViewItems;
import com.moze.pojo.Cart;
import com.moze.pojo.Item;
import com.moze.pojo.Product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class CartService {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static List<Cart> cartlist=cartlist=new ArrayList<Cart>();
	public static List<String> itemidlist=itemidlist=new ArrayList<String>();
	private HttpServletRequest request ;

	public CartService(HttpServletRequest re){
		this.request=re;

	}

	public void cartmain() throws Exception {
		// TODO Auto-generated method stub
		String itemId=(String)request.getParameter("itemid");
		//新点击连接添加一个新的itemid号。

		boolean flag=false;

		for(String  s  :itemidlist){
			if(itemId.equals(s)){//有相同的项目
				flag=true;
				break;
			}

		}
		if(flag!=true){
			itemidlist.add(itemId);
		}

		String qty=(String)request.getParameter("qty");
		Item item=showItemByItemId(itemId);

		List<Cart> cartlist=cartCom(item,qty,0);



		//计算购物车的总元数
		float sum=0f;
		for(Cart cart :cartlist){

			sum+=cart.getTotalcost();

		}


		request.getSession().setAttribute("subcost", sum);//总计

		request.getSession().setAttribute("cartList", cartlist);

		this.favItem();//得到喜爱的宠物列表


	}
	//点击更新按钮
	public void cartupdate() throws Exception {
		if(itemidlist.size()==0){
			return ;
		}

		//从itemidlist中取出所有的itemid，进行数据取值
		String itemid=null;
		String qty=null;
		List<Cart> cartlist1=null;
		for(String s  :itemidlist){
			itemid=request.getParameter(s+"id");//取itemid
			qty=request.getParameter(s+"qty");//取得相应商品的数量
			Item item=showItemByItemId(s);
			cartlist1=cartCom(item,String.valueOf(qty),1);
		}

		//计算购物车的总元数
		float sum=0f;
		for(Cart cart :cartlist1){

			sum+=cart.getTotalcost();

		}
		this.favItem();//得到喜爱的宠物列表
		request.getSession().setAttribute("cartList", cartlist1);//购物车
		request.getSession().setAttribute("subcost", sum);//总计


	}
	public void cartlist() throws Exception {

		this.favItem();//得到喜爱的宠物列表

	}

	//删除购物车中的商品
	public void cartremove() throws Exception {
		//首先删除itemidlist中的此种商品

		String itemId=(String)request.getParameter("itemid");
		itemidlist.remove(itemId);
		//删除购物车商品
		boolean flag=false;
		int i=0;
		for(Cart  cart  :cartlist){
			if(cart.getItemid().equals(itemId)){//有相同的项目
				flag=true;
				break;
			}
			i++;
		}
		if(flag==true){//有相同的

			cartlist.remove(i);

		}


		//计算购物车的总元数
		float sum=0f;
		for(Cart cart :cartlist){

			sum+=cart.getTotalcost();

		}
		this.favItem();//得到喜爱的宠物列表

		request.getSession().setAttribute("subcost", sum);//总计
		request.getSession().setAttribute("cartList", cartlist);

	}
	private Item showItemByItemId(String itemId) {
		// TODO Auto-generated method stub
		ViewItems vitem=new ViewItems();
		Item item=vitem.showItem(itemId);
		return item;
	}

	//形成购物车
	/* item:宠物商品的全部属性
	 * qty:购买宠物商品数量
	 * type:类型：是从usermain方法传过来的（点击add cart按钮），还是直接操作的购物侧的uodate按钮
	 *
	 * 		0:cartmain
	 * 		1:cartupdate
	 */
	private List<Cart> cartCom(Item item,String qty,int type){

		//判断是否有相同商品，有商品不添加数据，只是在数量上加1
		boolean flag=false;
		int i=0;
		for(Cart  cart  :cartlist){
			if(cart.getItemid().equals(item.getItemid())){//有相同的项目
				flag=true;
				break;
			}
			i++;
		}
		if(flag==true){//有相同的

			Cart cart=(Cart)cartlist.get(i);
			cart.setItemid(item.getItemid());
			cart.setPrice(item.getListprice());
			switch (type) {
				case 0://cartmain
					cart.setQty(cart.getQty()+Integer.valueOf(qty));
					break;

				case 1://cartudate
					cart.setQty(new Integer(qty));
					break;
			}


			cart.setDesc(item.getAttr1()+"<br/>"+item.getProduct().getName());
			cart.setProductid(item.getProductid());
			cart.setIsStock(item.getIsStock());
			float totalcost=cart.getQty()*item.getListprice();
			cart.setTotalcost(totalcost);

			cartlist.set(i, cart);//替换原有的cart

		}else{
			Cart cart=new Cart();
			cart.setItemid(item.getItemid());
			cart.setPrice(item.getListprice());
			cart.setQty(Integer.valueOf(qty));
			cart.setDesc(item.getAttr1()+"<br/>"+item.getProduct().getName());
			cart.setProductid(item.getProductid());
			cart.setIsStock(item.getIsStock());
			float totalcost=Integer.valueOf(qty)*item.getListprice();
			cart.setTotalcost(totalcost);

			cartlist.add(cart);
		}



		return cartlist;
	}
	private List<Product> favItem(){
		ViewItems vitem=new ViewItems();
		String username=(String)request.getSession().getAttribute("username");
		List<Product> list=vitem.showFavItems(username);
		request.setAttribute("favList", list);
		return list;
	}


}
