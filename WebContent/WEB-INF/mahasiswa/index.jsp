<%@page import="com.training.crud.core.CoreController"%>
<%@page import="com.training.crud.entity.Mahasiswa"%>
<%@page import="java.util.List"%>
<%
	List<Mahasiswa> mhs = (List<Mahasiswa>) request.getAttribute("mhs");
	String title = request.getAttribute("title").toString();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=title%></title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
</head>
<body>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>My First Bootstrap Page</h1>
		<p>Resize this responsive page to see the effect!</p>
	</div>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">WebSiteName</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Page 2</a></li>
				<li><a href="#">Page 3</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h2>About Me</h2>
				<h5>Photo of me:</h5>
				<div class="fakeimg">Fake Image</div>
				<p>Some text about me in culpa qui officia deserunt mollit
					anim..</p>
				<h3>Some Links</h3>
				<p>Lorem ipsum dolor sit ame.</p>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#">Link 1</a></li>
					<li><a href="#">Link 2</a></li>
					<li><a href="#">Link 3</a></li>
				</ul>
				<hr class="hidden-sm hidden-md hidden-lg">
			</div>
			<div class="col-sm-8">
				<h2><%=title%></h2>
				<button class="btn btn-primary" id="tambah-data">Tambah
					Data</button>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>No</th>
							<th>NIM</th>
							<th>Nama</th>
							<th>Email</th>
							<th>Prodi</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="data-mhs">
						<%
							int i = 1;
							for (Mahasiswa e : mhs) {
								out.println("<tr> <td>" + i + "</td><td>" + e.getNim() + "</td><td>" + e.getNama() + "</td><td>"
										+ e.getEmail() + "</td><td>" + e.getProdi() + "</td><td>" + "<button "
										+ "class='update-mhs btn btn-success' key='" + e.getNim() + "'>Update</button> |"
										+ "<button class='delete-mhs btn btn-danger' key='" + e.getNim()
										+ "'>Delete</button></td></tr>");
								i++;
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="title-modal">Tambah Data Mahasiswa
						Baru</h4>
				</div>
				<div class="modal-body">
					<form id="create-mahasiswa" action="#" method="post">
						<div class="form-group">
							<label for="nim">NIM:</label> <input name="nim" type="text"
								class="form-control" id="nim"> <input name="hidden-key"
								type="hidden" class="form-control" id="hidden-key">
						</div>
						<div class="form-group">
							<label for="nama">Nama:</label> <input name="nama" type="text"
								class="form-control" id="nama">
						</div>
						<div class="form-group">
							<label for="email">Email:</label> <input name="email" type="text"
								class="form-control" id="email">
						</div>
						<div class="form-group">
							<label for="prodi">Program Studi:</label> <input name="prodi"
								type="text" class="form-control" id="prodi">
						</div>
						<div class="form-group">
							<input type="button" id="simpan-ajax" value="Simpan"
								class="btn btn-primary"> <input type="button"
								id="update-ajax" style="display: none" value="Update"
								class="btn btn-primary">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			function reloadTable(){
				$.ajax({
					url: '<%=CoreController.base_url%>'+'mahasiswa.html?action=list-ajax',
					type: "GET",
					dataType: "json",
					success:function(data) {
							$('#data-mhs').empty();
							var no =1;
							var dataReal = data.data;
							$.each(dataReal, function(key, value) {
									$('#data-mhs').append('<tr><td>'+ no +'</td><td>'+ value.nim +'</td><td>'+ value.nama +'</td><td>'+ value.email +'</td><td>'+ value.prodi +'</td><td><button class="update-mhs btn btn-success" key="'+value.nim+'">Update</button> | <button class="delete-mhs btn btn-danger" key="'+value.nim+'">Delete</button></td></tr>');
									no++;
							});
					}
			});
			}
			
			$("#simpan-ajax").on('click', function() {
				$.ajax({
						url: '<%=CoreController.base_url%>'+'mahasiswa.html?action=save-ajax',
						type: "POST",
						dataType: "json",
						data: { "nim": $('#nim').val(), 
							"nama": $('#nama').val(), 
							"email": $('#email').val(), 
							"prodi": $('#prodi').val() },
						success:function(data) {
							var realData = data.data;	
							if(realData.status == 'success'){
								alert(realData.ket);
									$("#myModal").modal("hide");
									reloadTable();
									clearForm();
								}
						}
				});
		});
			
			$("#update-ajax").on('click', function() {
			    
				var key = $("#hidden-key").attr('value');
				$.ajax({
						url: '<%=CoreController.base_url%>'+'mahasiswa.html?action=update-ajax&key='+key,
						type: "POST",
						dataType: "json",
						data: { "nim": $('#nim').val(), "nama": $('#nama').val(), "email": $('#email').val(), "prodi": $('#prodi').val() },
						success:function(data) {
							var realData = data.data;	
							if(realData.status == 'success'){
								alert(realData.ket);
									$("#myModal").modal("hide");
									reloadTable();
									clearForm();
								}
						}
				});
		});
		
			$("#data-mhs").delegate(".update-mhs",'click', function() {
				var key = $(this).attr('key');
				$.ajax({
						url: '<%=CoreController.base_url%>'+'mahasiswa.html?action=edit-ajax&key='+key,
						type: "GET",
						dataType: "json",
						success:function(data) {
							var realData = data.data;	
							clearForm();
							$('#nim').val(realData.nim);
							$('#hidden-key').val(realData.nim);
							$('#nama').val(realData.nama);
							$('#email').val(realData.email);
							$('#prodi').val(realData.prodi);
							changeButtonState("update");
							$("#myModal").modal("show");
						}
				});
		});
			
			$("#data-mhs").delegate(".delete-mhs",'click', function() {
				var key = $(this).attr('key');
				if(confirm("Apakah anda yakin ingin menghapus data?")){
				$.ajax({
						url: '<%=CoreController.base_url%>
		'
																		+ 'mahasiswa.html?action=delete-ajax&key='
																		+ key,
																type : "GET",
																dataType : "json",
																success : function(
																		data) {
																	var realData = data.data;
																	if (realData.status == 'success') {
																		alert(realData.ket);
																		reloadTable();
																	}
																}
															});
												}
											});
							$("#tambah-data").on('click', function() {
								clearForm();
								changeButtonState("save");
								$("#myModal").modal("show");
							});

							function clearForm() {
								$('#nim').val('');
								$('#nama').val('');
								$('#email').val('');
								$('#prodi').val('');
							}

							function changeButtonState(state) {
								if (state == "save") {
									$("#simpan-ajax").attr("style",
											"display:block");
									$("#update-ajax").attr("style",
											"display:none");
									$("#title-modal").html(
											"Tambah Data Mahasiswa Baru");
								} else {
									$("#simpan-ajax").attr("style",
											"display:none");
									$("#update-ajax").attr("style",
											"display:block");
									$("#title-modal").html(
											"Update Data Mahasiswa");
								}
							}
						});
	</script>
</body>
</html>