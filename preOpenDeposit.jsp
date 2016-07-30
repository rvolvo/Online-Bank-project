<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>PreOpen Deposit</title>
<link rel="icon" type="image/png" href="pics/favIcon.jpg">
</head>
<body>
<jsp:directive.include file="/main.jsp" />
<script src="checkDepositId.js"></script>

<h4>PreOpen Deposit </h4>

<form name="preOpenDeposit" action="PreOpenDeposit" method="post" onsubmit="return CheckDepositId();">

		<div class="formDiv">
			<ul class="form-style-1">
				<li><label>Enter deposit Id</label> 
				<input type="text" id="depositIdToPreOpen" name="depositId" placeholder="Enter deposit Id">	
				<li><input type="submit" value="Submit"></li>
			</ul>
		</div>
</form>

</body>
</html>