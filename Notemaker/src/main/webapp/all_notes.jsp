O<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.*"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.*"%>

<title>All notes : Note maker</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>



	<div class="container">

		<%@include file="Navbar.jsp"%>
		<br>
		<div align="center">
			<h1>All Notes:</h1>
		</div>


		<div class="row">
			<div class="col-12">


				<%
				Session s = Factory_provider.getFactory().openSession();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();
				for (Note n : list) {
				%>
				<div class="card note-card">
					<div class="card-header">Notes...</div>
					<div class="card-body">
						<h5 class="card-title"><%=n.getId()%></h5>
						<h5 class="card-title"><%=n.getTitle()%></h5>
						<p class="card-text"><%=n.getContent()%></p>
						<a href="DeleteServlet?note_id=<%=n.getId()%>"
							class="btn btn-danger">Delete</a> <a
							href="EditServlet?note_id=<%=n.getId()%>" class="btn btn-primary">Edit</a>

					</div>
				</div>

				<%
				}

				s.close();
				%>



			</div>



		</div>



	</div>

</body>
</html>