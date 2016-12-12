<%@ page language="java" 
import="java.util.*,com.moze.pojo.*"
	pageEncoding="utf-8"%>
<%@include file="../commons/top.jsp"%>
<%
					Item item=(Item)request.getAttribute("item");
				 %>
<table align="left" bgcolor="#008800" border="0" cellspacing="2"
	cellpadding="2">
	<tr>
		<td bgcolor="#FFFF88">
			<a
				href="viewProduct.xhtml?category=<%=item.getProduct().getCategory() %>&productid=<%=item.getProductid()%>&productname=<%=item.getProduct().getName() %>"><b><font
					color="BLACK" size="2"><%=item.getProduct().getName() %></font> </b> </a>
		</td>
	</tr>
</table>

<p>
	<table align="center" bgcolor="#008800" cellspacing="2" cellpadding="3"
		border="0" width="60%">
		<tr bgcolor="#FFFF88">
			<td bgcolor="#FFFFFF">


				<%=item.getProduct().getDescn() %>
			</td>
		</tr>
		<tr bgcolor="#FFFF88">
			<td width="100%" bgcolor="#cccccc">
				<b><%=item.getItemid() %></b>
			</td>
		</tr>
		<tr bgcolor="#FFFF88">
			<td>
				<b><font size="4"> <%=item.getAttr1() %> &nbsp; <%=item.getProduct().getName()%>

				</font> </b>
			</td>
		</tr>
		<tr bgcolor="#FFFF88">
			<td>
				<font size="3"><i><%=item.getProduct().getName()%></i> </font>
			</td>
		</tr>
		<tr bgcolor="#FFFF88">
			<td>
				库存数量：
				<font size="2"><%=item.getInventory().getQty()%></font>

			</td>
		</tr>
		<tr bgcolor="#FFFF88">
			<td>
				$<%=item.getListprice()%>
			</td>
		</tr>

		<tr bgcolor="#FFFF88">
			<td>
				<a href="cartAdd.xhtml?itemid=<%=item.getItemid()%>&qty=1"><img
						border="0" src="../images/button_add_to_cart.gif" /> </a>
			</td>
		</tr>
	</table>
	<%@include file="../commons/bottom.jsp"%>