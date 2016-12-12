<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
  		<TITLE></TITLE>
		<META content="text/html; charset=utf-8" http-equiv=Content-Type>
		
  </head>
  
 <BODY bgColor=white >
   	<TABLE background="../images/bkg-topbar.gif" border=0 cellSpacing=0
			cellPadding=5 width="100%">
			<TBODY>
				<TR>
					<TD>
						<A href="/petstore"><IMG border=0
								src="../images/logo-topbar.gif">
						</A>
					</TD>
					<TD align=right >
						<A href="cartList.xhtml"><IMG border=0 name=img_cart
								src="../images/cart.gif">
						</A>
						<IMG border=0 src="../images/separator.gif">
						<%
							if(session.getAttribute("xm")==null){
						 %>
						 <A href="loginMain.jsp"> <IMG border=0
									name=img_signin src="../images/sign-in.gif">
						 </A>
						 <%
						 	}else{
						 
						  %>
							<A href="../commons/sigonout.jsp"> <IMG border=0
									name=img_signout src="../images/sign-out.gif">
							</A>
							<IMG border=0 src="../images/separator.gif">
							<A href="../shop/editUser.jsp"><img border="0" name="img_myaccount"
										src="../images/my_account.gif" /></A>
						 <%
						 
						 	}
						 
						  %>
						
						<IMG border=0 src="../images/separator.gif">
						
					</TD>
					<TD align=left valign="bottom">
						<FORM action="productQuery.xhtml" method="post" name="form1">
							<INPUT name=keyword size=14>
							<INPUT border=0 src="../images/search.gif" type=image>
						</FORM>
					</TD>
					
				</TR>
			</TBODY>
		</TABLE>
		<center>
			<a
				href="viewCategory.xhtml?category=Fish"><img
					border="0" src="../images/sm_fish.gif" />
			</a>
			<img border="0" src="../images/separator.gif" />
			<a
				href="viewCategory.xhtml?category=Dogs"><img
					border="0" src="../images/sm_dogs.gif" />
			</a>
			<img border="0" src="../images/separator.gif" />
			<a
				href="viewCategory.xhtml?category=Reptiles"><img
					border="0" src="../images/sm_reptiles.gif" />
			</a>
			<img border="0" src="../images/separator.gif" />
			<a
				href="viewCategory.xhtml?category=Cats"><img
					border="0" src="../images/sm_cats.gif" />
			</a>
			<img border="0" src="../images/separator.gif" />
			<a
				href="viewCategory.xhtml?category=Birds"><img
					border="0" src="../images/sm_birds.gif" />
			</a>
		</center>
		