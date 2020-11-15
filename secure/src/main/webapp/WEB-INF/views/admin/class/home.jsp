<%@include file = "/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- home of class -->
<%@ page isELIgnored="false" %>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>See All USERS!!!</title>
</head>
<body>
	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Class Id</th>
	      <th scope="col">Class Name</th>
	      <th scope="col">Class Year</th>
	      <th scope="col">Number of Classes held</th>
	      <th scope="col">Fees of class</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var = "oneClass" items = "${allClasses }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${oneClass.classId}</td>
		  			<td>${oneClass.className}</td>
		  			<td>${oneClass.classYear}</td>
		  			<td>${oneClass.noOfClassesHeld}</td>
		  			<td>${oneClass.fees}</td>
		  			<td>
		  				<form action = "classes/${oneClass.classId}/section" method = "get">
		  					<button class="btn btn-success" type = "submit">See Sections</button>
		  				</form>
		  			</td>
		  			<td>
		  				<form action = "classes/${oneClass.classId}/course" method = "get">
		  					<button class="btn btn-success" type = "submit">See Courses</button>
		  				</form>
		  			</td>
		  			<td>
		  				<form action = "classes/${oneClass.classId}/dress" method = "get">
		  					<button class="btn btn-success" type = "submit">View Uniforms</button>
		  				</form>
		  			</td>
		  		</tr>
		  </c:forEach>
	  </tbody>
	</table>
	
	
	    <form action = "classes/createClass" method = "get">
			<button class="btn btn-success" type = "submit">Create New Class</button>
		</form>
		<form action = "classes/createSection" method = "get">
			<button class="btn btn-success" type = "submit">Create New Section</button>
		</form>
		  		
</body>
</html>