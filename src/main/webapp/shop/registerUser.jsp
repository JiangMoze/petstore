<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@include file="../commons/top.jsp"%>

<script type="text/javascript">
<!--
	function validateUser(){
	
		if(document.getElementById("username").value==""){
			alert("用户名为空，请输入用户名！");
			return;
		}
		if(document.getElementById("pwd").value==""){
		
			alert("密码为空，请输入密码！");
			return;
		}
		if(document.getElementById("repwd").value==""){
			alert("再次输入密码为空，请重新输入密码！");
			return;
		}
		if(document.getElementById("pwd").value!=document.getElementById("repwd").value){
			alert("两次输入密码不同，请重新输入");
			return;
		}
		if(document.getElementById("xm").value==""){
			alert("真实姓名不能为空，请重新输入真实姓名。");
			return;
		}
		document.getElementById("form1").submit(); 
        return true;   
	
	}
//-->
</script>
<br/>

<form action="registerUser.xhtml" name="form1" method="post" id="form1">	
	<TABLE cellpadding=10 cellspacing=0 align=center border=1 width="400"
		bgcolor=#dddddd>
		<TR>
			<TD>
				<FONT color=darkgreen>
					<H3>
						用户信息
					</H3>
				</FONT>
				<TABLE border=0  bgcolor=#FFFF88  width="100%">
					<TR bgcolor=#FFFF88>	
						<TD>
							用户名*：
						</TD>					
						<TD>
							<input type="text" name="username" id="username">
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>
						<TD>
							密码*：
						</TD>
						<TD>
							<input type="password" name="pwd" id="pwd"> 
							
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>
						<TD>
							重新输入密码*：
						</TD>
						<TD>
							<input type="password" name="repwd" id="repwd"> 
							
						</TD>
					</TR>
				</TABLE>





				<FONT color=darkgreen><H3>
							账户信息 
					</H3>
				</FONT>

				<TABLE bgcolor="#FFFF88" border=0 
					bgcolor=#FFFF88 width="100%">
					<TR bgcolor=#FFFF88>
						<TD>
							真实姓名*：
						</TD>
						<TD>
							<input type="text" name="xm" id="xm"> 
						</TD>
					</TR>
					
					<TR bgcolor=#FFFF88>
						<TD>
							邮箱：
						</TD>
						<TD>
							 <input type="text" name="email" id="email"> 
						</TD>
					</TR>
					
					<TR bgcolor=#FFFF88>
						<TD>
							住址：
						</TD>
						<TD>
							  <input type="text" name="address" id="address"> 
							
						</TD>
					</TR>
					
					
				</TABLE>


				<FONT color=darkgreen><H3>
						喜爱的设置 
					</H3>
				</FONT>

				<TABLE bgcolor="#FFFF88" border=0 cellpadding=3 cellspacing=1 width="100%">
					
					<TR bgcolor=#FFFF88>
						<TD>
							喜爱的宠物：
						</TD>
						<TD>
							<select name="fav" id="fav">
								<option>Birds</option>
								<option>Cats</option>
								<option>Dogs</option>
								<option>Fish</option>
								<option>Reptiles</option>
							
							</select>
						</TD>
					</TR>
					
				</TABLE>
	</TABLE>

	<BR>
	<CENTER>
	
			<a href = "#"  onclick ="javascript:validateUser();" > <img border="0"
					src="../images/button_submit.gif" /> </a> 
	</CENTER>

</form>
<%@include file="../commons/bottom.jsp"%>