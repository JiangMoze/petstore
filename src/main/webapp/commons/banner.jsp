<br>
<%
	if(session.getAttribute("bannername")!=null){
	

 %>


	<table align="center" background="../images/bkg-topbar.gif" cellpadding="5" width="100%">
      <tr><td>
      <center>
      	<%=session.getAttribute("bannername") %>
       
          &nbsp;
      </center>
      </td></tr>
      </table>
	

<%
	}
 %>



