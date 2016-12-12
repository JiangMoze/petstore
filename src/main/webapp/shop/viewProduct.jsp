<%@ page language="java" 
import="java.util.*,com.moze.pojo.*" pageEncoding="utf-8"%>

<%@include file="../commons/top.jsp"%>


<table align="left" bgcolor="#008800" border="0" cellspacing="2"
	cellpadding="2">
	<tr>
		<td bgcolor="#FFFF88">
			<a href="viewCategory.xhtml?category=<%=request.getParameter("category")%>"><b><font
					color="BLACK" size="2"><%=request.getParameter("category")%></font>
			</b>
			</a>
		</td>
	</tr>
</table>

<p>

	<center>
		<h2><%=request.getParameter("productname")%>
		</h2>
	</center>

	<table align="center" bgcolor="#008800" border="0" cellspacing="2" cellpadding="3">
		<tr bgcolor="#CCCCCC">
			<td>
				<b>宠物序号</b>
			</td>
			<td>
				<b>产品序号</b>
			</td>
			<td>
				<b>宠物描述</b>
			</td>
			<td>
				<b>单价</b>
			</td>
			<td>
				<b>操作</b>
			</td>
		</tr>
		<%
			List<Item> list=(ArrayList<Item>)request.getAttribute("itemsList");
			for(Item i:list ){
			
		 %>
		<tr bgcolor="#FFFF88">
			<td>
				<b> <a href="viewItem.xhtml?itemid=<%=i.getItemid()%>"><%=i.getItemid()%></a>
				</b>
			</td>
			<td>
				<%=i.getProductid()%>
			</td>
			<td>
				<%=i.getAttr1()%>
				&nbsp;
				<%=request.getParameter("productname")%>
			</td>
			<td>
				$<%=i.getListprice()%>
			</td>
			<td>
				<a href="cartAdd.xhtml?itemid=<%=i.getItemid()%>&qty=1"><img border="0"
						src="../images/button_add_to_cart.gif" />
				</a>
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
	<%@include file="../commons/bottom.jsp"%>