<%@ page language="java" import="java.util.*,com.moze.pojo.*"
	pageEncoding="utf-8"%>

<%@include file="../commons/top.jsp"%>

<script type="text/javascript">
<!--
	function goBack()
	{
		history.back();
	}
//-->
</script>


<table border="0" width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td valign="top" width="20%" align="left">
			<table align="left" bgcolor="#008800" border="0" cellspacing="2"
				cellpadding="2">
				<tr>
					<td bgcolor="#FFFF88">
						<a href="javascript:goBack()"><b><font color="BLACK"
								size="2">&lt;&lt;购物车</font> </b> </a>
					</td>
				</tr>
			</table>
		</td>

		<td valign="top" align="center">
			<h2 align="center">
				确认商品
			</h2>

			<table align="center" bgcolor="#008800" border="0" cellspacing="2"
				cellpadding="5">

				<tr bgcolor="#cccccc">
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
						<b>有否宠物</b>
					</td>
					<td width="100">
						<b>数量</b>
					</td>
					<td>
						<b>单价</b>
					</td>
					<td>
						<b>总价格</b>
					</td>

				</tr>
				<%
						List<Cart> list=(ArrayList<Cart>)session.getAttribute("cartList");
						if(list!=null){
						
							for(Cart c:list){
					 %>

				<tr bgcolor="#FFFF88">
					<td>
						<b> <a href="viewItem.xhtml?itemid=<%=c.getItemid()%>"><%=c.getItemid()%></a>
							<%
								String id=c.getItemid()+"id";
								
							 %> <input type="hidden" name="<%=id%>"
								value="<%=c.getItemid()%>"> </b>
					</td>
					<td>
						<%=c.getProductid()%>

					</td>
					<td>
						<%=c.getDesc()%>

					</td>
					<td align="center">
						<%
								if(c.getIsStock()!=null){
								
							%>
						有
						<%	
								}else{
							 %>
						无
						<%
							 	}
							  %>

					</td>
					<td>
						<%=c.getQty()%>

					</td>
					<td align="right">
						<%=c.getPrice()%>
						<br />
					</td>
					<td align="right">

						<%=c.getTotalcost()%>
					</td>

				</tr>

				<%
						}
							}
						 %>
				<tr bgcolor="#FFFF88">
					<td colspan="7" align="right">
						<b>总计: <%
								Float sub=(Float)session.getAttribute("subcost");
									if(sub!=null){
							 %> <%=session.getAttribute("subcost") %> <%
								 	}
								  %> </b>

					</td>

				</tr>
			</table>
			<center>


			</center>
			<br>
			<center>
				<%
							if(session.getAttribute("subcost")!=null){
						 %>
				<a href="orderMain.xhtml"><img border="0"
						src="../images/button_continue.gif" /> </a>

				<%
							}
						 %>



			</center>
		</td>


		<td valign="top" width="20%" align="right">
			&nbsp;
		</td>

	</tr>
</table>


<%@include file="../commons/bottom.jsp"%>