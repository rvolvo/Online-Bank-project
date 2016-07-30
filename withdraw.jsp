<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@page import="beans.AccountBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Withdraw From My Account</title>
<link rel="icon" type="image/png" href="pics/favIcon.jpg">
</head>
<body>
	<jsp:directive.include file="/main.jsp" />
	<script src="checkWithdrawAmount.js"></script>

	<h4>Withdraw From My Account</h4>

	<form name="withdraw" action="Withdraw" method="post" onsubmit="return CheckWithdraw()">

		<div class="formDiv">
			<ul class="form-style-1">
				<li><label>Enter amount to withdraw from your account</label> 
				<input type="text" id="withdrawAmount" name="amount" placeholder="Amount in USD">
				<li><input type="submit" value="Submit"></li>
			</ul>
		</div>

	</form>

</body>
</html>

