<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
 <%@page import="java.util.Map"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Properties and Commissions</title>
<link rel="icon" type="image/png" href="pics/favIcon.jpg">
</head>
<body>
<jsp:directive.include file="/main.jsp" />

<h4>Properties and Commissions </h4>

<table id="propertiesTable">
<tr>
    <th> Property Key </th>
    <th> Property Value </th>
  </tr>
<%
Map<String, String> propMap = (Map<String, String>)session.getAttribute("propMap");
for (Map.Entry<String, String> entry : propMap.entrySet()) 
{
	String key = entry.getKey();
    String value = entry.getValue();
%>            
  <tr>
    <td> <%= key %> </td>
    <td><%= value %></td>
  </tr>
<%
}
%>
</table>

</body>
</html>