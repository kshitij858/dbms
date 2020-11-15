<%@include file = "/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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
	      <th scope="col">User Id</th>
	      <th scope="col">Teacher Id</th>
	      <th scope="col">Leaves Taken</th>
	      <th scope="col">Salary</th>
	      <th scope="col">Designation</th>
	      <th scope="col">Number of leaves allowed</th>
	    </tr>
	  </thead>
	  <tbody>
	    
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${teacher.user.userId}</td>
		  			<td>${teacher.teacherId}</td>
		  			<td>${teacher.leavesTaken}</td>
		  			<td>${teacher.salary}</td>
		  			<td>${teacher.designation}</td>
		  			<td>${teacher.numberOfLeavesAllowed}</td>
		  		</tr>
	  </tbody>
	</table>
</body>
</html>