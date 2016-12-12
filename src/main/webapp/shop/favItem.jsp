<%@ page language="java" import="java.util.*,
com.moze.pojo.*" pageEncoding="utf-8"%>
<%
	if(session.getAttribute("username")!=null){
	
	
	

 %>

<br/>
<br/>
<table align="right" bgcolor="#008800" border="0" cellspacing="2"
	cellpadding="3">
	
		<tr bgcolor="#CCCCCC">
			<td>
				<font size="4"><b>你喜爱的宠物列表</b>
				</font>
				
			</td>
		</tr>
		<%
			List<Product> list1=(ArrayList<Product>)request.getAttribute("favList");
			if(list1!=null){
			
			
				for(Product p:list1){
			
			
			
			
		 %>
		
		<tr bgcolor="#FFFF88">
			<td>
				<a href="viewProduct.xhtml?category=<%=p.getCategory() %>&productid=<%=p.getProductid() %>&productname=<%=p.getName()%>"><%=p.getName()%></a>
				<br />
				<font size="2">(<%=p.getProductid()%>)</font>
				<br />
	
			</td>
		</tr>
	<%
			}
		}
	 %>

</table>
<%
	}
%>