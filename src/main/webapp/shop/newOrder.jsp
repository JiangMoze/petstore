<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../commons/top.jsp"%>

<script type="text/javascript">
<!--
	function validateOrder(){
		
		if(document.getElementById("cardno").value==""){
			alert("卡号为空，请输入卡号！");
			return;
		}
		if(document.getElementById("xm").value==""){
			alert("真实姓名为空，请输入真实姓名！");
			return;
		}
		
		
		document.getElementById("formorder").submit(); 
        return true;   
	
	}
//-->
</script>

<form name="form1" method="post" action="orderAdd.xhtml" id="formorder">

	<br />
	<br />
	<TABLE border=0 cellpadding=3 cellspacing=1 bgcolor="#FFFF88"
		align="center">
		<TR bgcolor=#FFFF88>
			<TD colspan=2>
				<FONT color=GREEN size=4><B>支付明细</B> </FONT>
			</TD>
		</TR>

		<TR>
			<td>
				卡类型

			</td>
			<TD bgcolor="#FFFF88">
				<select name="cardtypevalue" id="cardtypevalue">
					<option>
						龙卡
					</option>
					<option>
						牡丹卡
					</option>
					<option>
						长城卡
					</option>

				</select>

			</TD>
		</TR>


		<TR>
			<td>
				卡号

			</td>
			<TD bgcolor="#FFFF88">
				<input type="text" name="cardno" id="cardno" value="999 9999 9999 9999">
			

			</TD>
		</TR>

		<TR bgcolor="#FFFF88">
			<td>
				真实姓名：
			</td>
			<TD>
				<input type="text" name="xm" id="xm">

			</TD>


		</TR>

		<TR bgcolor=#FFFF88>
			<td>
				地址：
			</td>
			<td>
				<input type="text" name="address" id="address">

			</td>
		</TR>
		<TR bgcolor=#FFFF88>
			<td>
				所在城市：
			</td>
			<TD>
				<input type="text" name="city" id="city">
				
			</TD>
		</TR>
		<TR bgcolor=#FFFF88>
			<TD>
				总价格
				:
				<input type="hidden" name="totalprice" value="<%=session.getAttribute("subcost") %>">
			</TD>
			<TD>
				<%=session.getAttribute("subcost") %>
			</TD>
		</TR>
		<tr>
			<TD>
			<a href = "#"  onclick ="javascript:validateOrder();" > <img border="0"
					src="../images/button_submit.gif" /> </a> 
			
			</TD>
		</tr>

	</TABLE>


</form>

<%@include file="../commons/bottom.jsp"%>