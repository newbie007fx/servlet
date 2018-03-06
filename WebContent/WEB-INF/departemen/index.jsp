<%@page import="com.training.crud.core.CoreController"%>
<%@page import="com.training.crud.entity.Departemen"%>
<%@page import="java.util.List"%>
<% 
List<Departemen> dpt = (List<Departemen>) request.getAttribute("dpt");
String title = request.getAttribute("title").toString();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= title %></title>
</head>
<body>
	<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nama Departemen</th>
			<th>Alamat</th>
			<th>Website</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<a href="<%= CoreController.base_url %>departemen.html?action=create"><button>Tambah Data</button></a>
	<% 
	for(Departemen e:dpt){
		out.println("<tr> <td>"
			+e.getId()+"</td><td>"
			+e.getNamaDepartemen()+"</td><td>"
			+e.getAlamat()+"</td><td>"
			+e.getWebsite()+"</td><td>"
			+"<a href='"+CoreController.base_url+"departemen.html?action=update&key="+e.getId()+"'>Update</a> |" 
			+"<a href='"+CoreController.base_url+"departemen.html?action=delete&key="+e.getId()+"' onclick='javasciprt: return confirm(\"Apakah anda yakin ingin menghapus data?\")'>Delete</a></tr>");
	} %>
	</tbody>
	</table>
</body>
</html>