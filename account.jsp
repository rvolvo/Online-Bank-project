<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@page import="beans.AccountBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>My Account</title>
<link rel="icon" type="image/png" href="pics/favIcon.jpg">
</head>
<body>
	<jsp:directive.include file="/main.jsp" />
	<h4>Account Details</h4>
	<%AccountBean accountBean = (AccountBean)session.getAttribute("accountBean");%>
	<table id="accountDetailsTable">
		<tr>
			<td>Account Owner Id</td>
			<td><%= accountBean.getClientId() %></td>
		</tr>
		<tr>
			<td>Account Id</td>
			<td><%= accountBean.getAccountId() %></td>
		</tr>
		<tr>
			<td>Account Balance</td>
			<td><%= accountBean.getBalance() %></td>
		</tr>
		<tr>
			<td>Credit Limit</td>
			<td><%= accountBean.getCreditLimit() %></td>
		</tr>
		<tr>
			<td>Comment</td>
			<td><%= accountBean.getComment()%></td>
		</tr>
	</table>
</body>
</html>