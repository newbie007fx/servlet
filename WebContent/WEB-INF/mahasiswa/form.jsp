<%@page import="com.training.crud.entity.Mahasiswa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Mahasiswa mhs = (Mahasiswa)request.getAttribute("mhs");
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
			<td>Nim </td><td> : </td><td><input type="text" value="<%= (mhs != null)?mhs.getNim():"" %>" name="nim"/></td>
		</tr>
		<tr>
			<td>Nama </td><td> : </td><td><input type="text" value="<%= (mhs != null)?mhs.getNama():"" %>" name="nama"/></td>
		</tr>
		<tr>
			<td>Email </td><td> : </td><td><input type="text" value="<%= (mhs != null)?mhs.getEmail():"" %>" name="email"/></td>
		</tr>
		<tr>
			<td>Prodi </td><td> : </td><td><input type="text" value="<%= (mhs != null)?mhs.getProdi():"" %>" name="prodi"/></td>
		</tr>
		<tr><td colspan="3"><input type="submit" value="simpan"></td></tr>
	</table>
</form>
</body>
</html>