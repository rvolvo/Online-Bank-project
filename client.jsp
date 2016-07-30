<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@page import="beans.ClientBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>My Personal Details</title>
<link rel="icon" type="image/png" href="pics/favIcon.jpg">
</head>
<body>
<jsp:directive.include file="/main.jsp" />

<h4>Personal Details </h4>

<table id="clientDetailsTable">
  <tr>
    <td>Full Name</td>
    <td><%= clientBean.getClientName() %></td>
  </tr>
  <tr>
    <td>Client Id</td>
    <td><%= clientBean.getClientId() %></td>
  </tr>
  <tr>
    <td>Password</td>
    <td><%= clientBean.getPassword() %></td>
  </tr>
    <tr>
    <td>Address</td>
    <td><%= clientBean.getAddress() %></td>
  </tr>
      <tr>
    <td>Email</td>
    <td><%= clientBean.getEmail() %></td>
  </tr>
      <tr>
    <td>Phone</td>
    <td><%= clientBean.getPhone() %></td>
  </tr>
        <tr>
    <td>Type</td>
    <td><%= clientBean.getType() %></td>
  </tr>
  <tr>
    <td>Comment</td>
    <td><%= clientBean.getComment()%></td>
  </tr>
</table>

</body>
</html>