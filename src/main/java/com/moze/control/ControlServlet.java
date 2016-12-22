package com.moze.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moze.service.*;
/**
 * Created by IntelliJ IDEA.
 * Created by 蒋东雨 on 2016/12/07.
 */

public class ControlServlet extends HttpServlet {
	private HashMap<String,String> forwards;
	private final static String VIEWCATEGORY="viewCategory";
	private final static String VIEWPRODUCT="viewProduct";
	private final static String VIEWITEM="viewItem";
	private final static String LOGINUSER="loginUser";
	private final static String LOGINUSERERROR="loginUserError";
	private final static String REGISTERUSER="registerUser";
	private final static String EDITUSER="editUser";
	private final static String PRODUCTQUERY="productQuery";
	private final static String CARTLIST="cartList";
	private final static String CARTADD="cartAdd";
	private final static String CARTREMOVE="cartRemove";
	private final static String CARTUPDATE="cartUpdate";
	private final static String CARTCHECKOUT="cartCheckout";
	private final static String ORDERMAIN="orderMain";
	private final static String LOGINMAIN="loginMain";
	private final static String ORDERADD="orderAdd";
	public ControlServlet() {
		//super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request,response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request,response);
	}


	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		forwards=new HashMap<String,String>();
		//读取web.xml文件中以first为标识的<param-name>，放到HashMap中。
		forwards.put(VIEWCATEGORY,config.getInitParameter(VIEWCATEGORY));
		forwards.put(VIEWPRODUCT,config.getInitParameter(VIEWPRODUCT));
		forwards.put(VIEWITEM,config.getInitParameter(VIEWITEM));
		forwards.put(LOGINUSER,config.getInitParameter(LOGINUSER));
		forwards.put(LOGINUSERERROR,config.getInitParameter(LOGINUSERERROR));
		forwards.put(REGISTERUSER,config.getInitParameter(REGISTERUSER));
		forwards.put(EDITUSER,config.getInitParameter(EDITUSER));
		forwards.put(PRODUCTQUERY,config.getInitParameter(PRODUCTQUERY));
		forwards.put(CARTLIST,config.getInitParameter(CARTLIST));
		forwards.put(CARTADD,config.getInitParameter(CARTADD));
		forwards.put(CARTREMOVE,config.getInitParameter(CARTREMOVE));
		forwards.put(CARTUPDATE,config.getInitParameter(CARTUPDATE));
		forwards.put(CARTCHECKOUT,config.getInitParameter(CARTCHECKOUT));
		forwards.put(ORDERMAIN,config.getInitParameter(ORDERMAIN));
		forwards.put(LOGINMAIN,config.getInitParameter(LOGINMAIN));
		forwards.put(ORDERADD,config.getInitParameter(ORDERADD));
	}
	//指向相关联的页面
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{

			//返回servlet的上下文
			ServletContext context=getServletContext();
			//得到地址的全称

			String logicalName=request.getServletPath();
			String physicalURL="/";
			//通过分割字符串，找到其中的fist或second
			logicalName=logicalName.substring(logicalName.lastIndexOf('/')+1,logicalName.indexOf('.'));
			if(logicalName.equals(VIEWCATEGORY)){

				physicalURL=(String)forwards.get(VIEWCATEGORY);//HashMap对象名
				ViewCategoryService va=new ViewCategoryService();
				va.getProductList(request, response);
			}else if(logicalName.equals(VIEWPRODUCT)){

				physicalURL=(String)forwards.get(VIEWPRODUCT);//HashMap对象名
				ViewProductService vp=new ViewProductService();
				vp.getItemList(request, response);
			}else if(logicalName.equals(VIEWITEM)){
				physicalURL=(String)forwards.get(VIEWITEM);//HashMap对象名
				ViewItemService vp=new ViewItemService();
				vp.getItem(request, response);
			}else if(logicalName.equals(LOGINUSER)){
				physicalURL=(String)forwards.get(LOGINUSER);//HashMap对象名
				LoginUserService lu=new LoginUserService();
				if(!lu.loginUser(request, response)){//成功验证
					physicalURL=(String)forwards.get(LOGINUSERERROR);//HashMap对象名

				}
			}else if(logicalName.equals(REGISTERUSER)){
				physicalURL=(String)forwards.get(REGISTERUSER);//HashMap对象名
				RegisterUserService ru=new RegisterUserService();
				ru.registerUser(request, response);
			}else if(logicalName.equals(EDITUSER)){
				physicalURL=(String)forwards.get(EDITUSER);//HashMap对象名
				EditUserService eu=new EditUserService();
				eu.editUser(request, response);
			}else if(logicalName.equals(PRODUCTQUERY)){
				physicalURL=(String)forwards.get(PRODUCTQUERY);//HashMap对象名
				ViewProductService vp=new ViewProductService();
				vp.productQuery(request, response);
			}else if(logicalName.equals(CARTLIST)){
				physicalURL=(String)forwards.get(CARTLIST);//HashMap对象名
				CartService cs=new CartService(request);
				cs.cartlist();

			}else if(logicalName.equals(CARTADD)){
				physicalURL=(String)forwards.get(CARTADD);//HashMap对象名
				CartService cs=new CartService(request);
				cs.cartmain();
			}else if(logicalName.equals(CARTREMOVE)){
				physicalURL=(String)forwards.get(CARTREMOVE);//HashMap对象名
				CartService cs=new CartService(request);
				cs.cartremove();
			}else if(logicalName.equals(CARTUPDATE)){
				physicalURL=(String)forwards.get(CARTUPDATE);//HashMap对象名
				CartService cs=new CartService(request);
				cs.cartupdate();
			}else if(logicalName.equals(CARTCHECKOUT)){
				physicalURL=(String)forwards.get(CARTCHECKOUT);//HashMap对象名

			}else if(logicalName.equals(ORDERMAIN)){
				physicalURL=(String)forwards.get(ORDERMAIN);//HashMap对象名
				OrderService os=new OrderService();
				if(os.ordermain(request, response).equals("login")){
					physicalURL=(String)forwards.get(LOGINMAIN);//HashMap对象名
				}
			}else if(logicalName.equals(ORDERADD)){
				physicalURL=(String)forwards.get(ORDERADD);//HashMap对象名
				OrderService os=new OrderService();
				os.ordersave(request, response);
			}


			RequestDispatcher dispatcher=context.getRequestDispatcher(physicalURL);//转发到所选择的目标

			dispatcher.forward(request,response);


		}catch(Exception e){
			throw new ServletException(e);

		}finally{

		}

	}


}
