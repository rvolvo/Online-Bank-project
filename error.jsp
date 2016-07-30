<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Error Occurred</title>
</head>
<body>
<jsp:directive.include file="/main.jsp" />

<div id="errorDiv">
<p>Error has occurred</p>

<p>Message:</p>
<p><%= request.getAttribute("errorMsg") %></p>

<p>Cause:</p>
<p><%= request.getAttribute("errorCause") %></p>

<p><a href="Controller?command=homePage">Go to Home Page</a></p>

</div>

</body>
</html>