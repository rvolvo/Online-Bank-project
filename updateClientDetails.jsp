<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@page import="beans.ClientBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Update Client Details</title>
<link rel="icon" type="image/png" href="pics/favIcon.jpg">
</head>
<body>
	<jsp:directive.include file="/main.jsp" />
	<script src="updateClientDetails.js"></script>

	<h4>Update Client Details</h4>

	<form name="updateClientDetails" action="UpdateClientDetails" method="post" 
	onsubmit="return CheckName() && CheckPassword() && CheckEmail() && CheckAddress() && CheckPhone() && CheckComment()">

<div class="formDiv">
		<ul class="form-style-1">
			<li><label>Full Name</label> <input type="text"
				id="clientName" name="clientName" value="<%= clientBean.getClientName() %>"
				class="field-long"></li>
			<li><label>Password<span></span></label> <input type="text"
				id="clientPassword" name="clientPassword" value="<%= clientBean.getPassword() %>"
				class="field-long"></li>
			<li><label>Email</label> <input type="text" id="clientEmail"
				name="clientEmail" value="<%= clientBean.getEmail() %>"
				class="field-long"></li>

			<li><label>Address</label> <input type="text" id="clientAddress"
				name="clientAddress" value="<%= clientBean.getAddress() %>"
				class="field-long"></li>

			<li><label>Phone</label> <input type="text" id="clientPhone"
				name="clientPhone" value="<%= clientBean.getPhone() %>"
				class="field-long"></li>

			<li><label>Comment</label> <input type="text" id="clientComment"
				name="clientComment" value="<%= clientBean.getComment() %>"
				class="field-long"></li>
			<li><input type="submit" value="Update Details"></li>
		</ul>
</div>
	</form>


</body>
</html>