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
	      <th scope="col">UserName</th>
	      <th scope="col">Role</th>
	      <th scope="col">First Name</th>
	      <th scope="col">Middle Name</th>
	      <th scope="col">Last Name</th>
	      <th scope="col">House Number</th>
	      <th scope="col">Street Name</th>
	      <th scope="col">City</th>
	      <th scope="col">Pincode</th>
	      <th scope="col">Adhar Number</th>
	      <th scope="col">Category</th>
	      <th scope="col">Blood Group</th>
	      <th scope="col">Gender</th>
	      <th scope="col">Registration Date</th>
	    </tr>
	  </thead>
	  <tbody>
	    
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${user.userId}</td><td>${user.username}</td><td>${user.role}</td>
		  			<td>${user.firstName}</td><td>${user.middleName}</td>
		  			<td>${user.lastName}</td><td>${user.houseNumber}</td><td>${user.streetName}</td>
		  			<td>${user.city}</td><td>${user.pincode}</td><td>${user.adharNumber}</td>
		  			<td>${user.category}</td><td>${user.bloodGroup}</td><td>${user.gender}</td>
		  			<td>${user.registrationDate}</td>
		  		</tr>
	  </tbody>
	</table>
</body>
</html>