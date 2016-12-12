<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		
		document.getElementById("formlogin").submit(); 
        return true;   
	
	}
//-->
</script>

<%@include file="../commons/top.jsp"%>
<form action="loginUser.xhtml" id="formlogin"  >
	<table align="center" border="0">
		<tr>
			<td colspan="2">				
				请正确输入你的用户名和密码。
				<br />
				
			</td>
		</tr>
		<tr>
			<td>
				用户名：
			</td>
			<td>
				<input type="text" id="username" name="username">
			</td>
		</tr>
		<tr>
			<td>
				密码：
			</td>
			<td align="right">
				<input type="password" id="pwd" name="pwd">
				
			</td>
		</tr>
		<tr>
			<td>
				<a href = "#"  onclick ="javascript:validateUser();" > <img border="0"
					src="../images/button_submit.gif" /> </a>

			</td>
			<td>
				<a href = "registerUser.jsp"  > <img border="0"
					src="../images/button_register_now.gif" /> </a> 
				<input type="button" onclick="validateUser()">
			</td>
		</tr>
	</table>
</form>

<%@include file="../commons/bottom.jsp"%>