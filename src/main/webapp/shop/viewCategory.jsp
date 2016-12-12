<%@ page language="java" 
import="java.util.*,com.moze.pojo.*" pageEncoding="utf-8"%>

<%@include file="../commons/top.jsp" %>

<table align="left" bgcolor="#008800" border="0" cellspacing="2"
	cellpadding="2">
	<tr>
		<td bgcolor="#FFFF88">
			<a href="main.jsp"><b><font color="BLACK" size="2">&lt;&lt; 主菜单</font>
				</b></a>
		</td>
	</tr>
</table>

<p>
	<center>
		<h2>
			<%=request.getParameter("category") %>
		</h2>
	</center>
	<table align="center" bgcolor="#008800" border="0" cellspacing="2"
		cellpadding="3">
		<tr bgcolor="#CCCCCC">
			<td>
				<b>产品序号</b>
			</td>
			<td>
				<b>产品名称</b>
			</td>
		</tr>
			<%
				List<Product> list=(ArrayList<Product>)request.getAttribute("productList");
				for(Product p:list){
			
			
			 %>
			
			
				<tr bgcolor="#FFFF88">
				<td>
					<b><a href="viewProduct.xhtml?category=<%=p.getCategory()%>&productid=<%=p.getProductid() %>&productname=<%=p.getName() %>"><font color="BLACK"><%=p.getProductid() %>
							</font></a>
					</b>
				</td>
				<td>
					<%=p.getName() %>
				</td>
			</tr>
			<%
				}
			 %>
			
			
		
			
		
		<tr>
			<td bgcolor="#FFFFFF" colspan="2">
				
				
			</td>
		</tr>
	</table>
<%@include file="../commons/bottom.jsp" %>