<%@page import="com.training.crud.entity.Departemen"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Departemen dpt = (Departemen)request.getAttribute("dpt");
String title = request.getAttribute("title").toString();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= title %></title>
</head>
<body>
<h1><%= title %></h1>
<form method="post">
	<table>
		<tr>
			<td>ID </td><td> : </td><td><input type="text" value="<%= (dpt != null)?dpt.getId():"" %>" name="id"/></td>
		</tr>
		<tr>
			<td>Nama Departemen </td><td> : </td><td><input type="text" value="<%= (dpt != null)?dpt.getNamaDepartemen():"" %>" name="nama_departemen"/></td>
		</tr>
		<tr>
			<td>Alamat </td><td> : </td><td><input type="text" value="<%= (dpt != null)?dpt.getAlamat():"" %>" name="alamat"/></td>
		</tr>
		<tr>
			<td>Website </td><td> : </td><td><input type="text" value="<%= (dpt != null)?dpt.getWebsite():"" %>" name="website"/></td>
		</tr>
		<tr><td colspan="3"><input type="submit" value="simpan"></td></tr>
	</table>
</form>
</body>
</html>