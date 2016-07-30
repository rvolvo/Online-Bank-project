<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@page import="beans.ClientBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>MBank Main Menu</title>
<link type="text/css" href="mbank.css" rel="stylesheet" />
<link rel="icon" type="image/png" href="pics/favIcon.jpg">
</head>
<body id="wrap">

<div id = "welcom">
<%
ClientBean clientBean = (ClientBean)session.getAttribute("clientBean");
String clientName = clientBean.getClientName();
%>
<h4>Welcome to MBank Online <%=clientName%> </h4>
</div>

<div id = "mainMenu">
<ul>
<li><a href="Controller?command=homePage" style="float: left;" >Home Page</a></li>
<li><a href="Controller?command=viewAccount" style="float: left;" >My Account</a></li>
<li><a href="Controller?command=viewDetails" style="float: left;" >My Personal Details</a></li>
<li><a href="Controller?command=updateDetails" style="float: left;" >Update My Details</a></li>
<li><a href="Controller?command=viewDeposits" style="float: left;" >My Deposits</a></li>
<li><a href="Controller?command=viewActivities" style="float: left;" >My Activities</a></li>
<li><a href="Controller?command=withdraw" style="float: left;" >Withdraw From My Account</a></li>
<li><a href="Controller?command=deposit" style="float: left;" >Deposit To My Account</a></li>
<li><a href="Controller?command=newDeposit" style="float: left;" >Create New Deposit</a></li>	
<li><a href="Controller?command=preOpenDeposit" style="float: left;" >PreOpen Deposit</a></li>
<li><a href="Controller?command=viewProperties" style="float: left;" >View MBank Properties and Commissions</a></li>
<li><a href="Controller?command=aboutMbank" style="float: left;" >About MBank</a></li>
<li><a href="Controller?command=contactUs" style="float: left;" >Contact Us</a></li>
<li><a href="Controller?command=logout" style="float: left;" >logout</a></li>
</ul>
</div>

</body>
</html>