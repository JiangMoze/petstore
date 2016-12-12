<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
  		<TITLE>宠物商店</TITLE>
		<META content="text/html; charset=utf-8" http-equiv=Content-Type>
  </head>
  
 <BODY bgColor=white>
   	<TABLE background="images/bkg-topbar.gif" border=0 cellSpacing=0
			cellPadding=5 width="100%">
			<TBODY>
				<TR>
					<TD>
						<A href="#"><IMG border=0
								src="images/logo-topbar.gif">
						</A>
					</TD>
					<TD align=right>
						<A href="shop/cartList.xhtml"><IMG border=0 name=img_cart
								src="images/cart.gif">
						</A>
						<IMG border=0 src="images/separator.gif">

						<A href="shop/loginMain.jsp"> <IMG border=0
								name=img_signin src="images/sign-in.gif">
						</A>
						
						
					</TD>
					<TD align=left valign=bottom>
						<FORM action="shop/productQuery.xhtml">
							<INPUT name=keyword size=14>
							<INPUT border=0 src="images/search.gif" type=image>
						</FORM>
					</TD>
					<td align=left >
						<font color="#fbf204"></font>
						:
					</td>
					
				</TR>
			</TBODY>
		</TABLE>
		
		<TABLE border=0 cellSpacing=0 width="100%">
			<TBODY>
				<TR>

					<TD vAlign=top width=100%>
						<p>
							&nbsp;
						</p>
						<p align="center">
							<b></b>
						</p>
						<p align="center">
							<a href="shop/main.jsp">欢迎进入宠物商店</a>
							
						</p>
					</TD>
				</TR>
			</TBODY>
		</TABLE>

		<P>
			&nbsp;
		</P>

		<%@include file="commons/bottom.jsp" %>

	


