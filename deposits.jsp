<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@page import="beans.DepositBean"%>
<%@page import="java.util.List"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>My Deposits</title>
<link rel="icon" type="image/png" href="pics/favIcon.jpg">
</head>
<body>
<jsp:directive.include file="/main.jsp" />

<h4>Deposits Details </h4>

<table id="clientDepositsTable">
<%
List<DepositBean> allClientDeposits = (List<DepositBean>)session.getAttribute("clientDeposits");
if (!allClientDeposits.isEmpty())
{
%>
    <thead>
    <tr>
    	<th>Deposit Id</th>
    	<th>Deposit Type</th>
        <th>Balance</th>  
        <th>Estimated Balance</th>
        <th>Opening Date</th>
        <th>Closing Date</th>
    </tr>
	</thead>
<%
	for(int i=0;i<allClientDeposits.size();i++)
	{
		DepositBean depositBean = allClientDeposits.get(i);
		%> <tr>
			<td><%=depositBean.getDepositId() %></td>
			<td><%=depositBean.getType() %></td>
			<td><%=depositBean.getBalance() %></td>
			<td><%=depositBean.getEstimatedBalance() %></td>
			<td><%=depositBean.getOpeningDate() %></td>
			<td><%=depositBean.getClosingDate() %></td>
		<%
	}
}
else
{
%>
		<p>No Deposits Found</p>
<%
}
%>
</table>

</body>
</html>