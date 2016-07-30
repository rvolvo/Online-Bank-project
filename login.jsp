<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">

<title>MBank Login</title>
<link type="text/css" href="mbank.css" rel="stylesheet" />
<link rel="icon" type="image/png" href="pics/favIcon.jpg">

</head>
<body id="bodyLogin" onload="LoginCheck();">

<script src="login.js"></script>

<script type="text/javascript">
	function LoginCheck()
	{	
		var isLogin=true;
		var isLogin = '<%= request.getAttribute("isLogin") %>';
		if(isLogin == 'false')
		{
			alert("Login Failed, Your input is not correct");
		}
	}
	</script>

	<form name="loginForm" action="Login" method="post" onsubmit="return CheckAllFields()">
		<div id="login">
			<ul class="form-style-1">
				<li><label>Client ID <span class="required">*</span></label> <input
					type="text" id="id" name="clientId" onblur="CheckClientId()"
					class="field-long" placeholder="Client ID" /></li>

				<li><label>Full Name <span class="required">*</span></label> <input
					type="text" id="name" name="clientName" class="field-long"
					placeholder="Full Name" /></li>

				<li><label>Password <span class="required">*</span></label> <input
					type="password" id="password" name="clientPassword" class="field-long"
					placeholder="Password" /></li>
				<li><input type="submit" value="Login">
				</li>
			</ul>
		</div>
	</form>
</body>
</html>
