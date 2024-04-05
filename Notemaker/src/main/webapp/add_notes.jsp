<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add your notes here</title>

</head>
<body>

	<div class="Container">
		<%@include file="all_js_css.jsp"%>
		<%@include file="Navbar.jsp"%>
		<br>
		<div align="center">
		<h1 >Add your notes here</h1>
		</div>
		
		
		<br>
		


		<form action="SaveNoteServlet" method="post">
		<div class="form-group">
				<label for="exampleInputEmail1">Id</label> 
				<input name = "Id" required type="text"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter Id"/> <small
					id="emailHelp" class="form-text text-muted"></small>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label> 
				<input name = "Title" required type="text"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter Title"/> <small
					id="emailHelp" class="form-text text-muted"></small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea name = "Content" required id="Content"  placeholder="Enter your content here"
					class="form-control" style="height: 200px"> </textarea>
			</div>


		<div class="container text-center">
			<button type="submit" class="btn btn-primary"
				style="justify-content: center;">Submit</button>
				</div>
		</form>

	</div>


</body>
</html>