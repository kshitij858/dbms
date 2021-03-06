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
	      <th scope="col">Responsibility Id </th>
	      <th scope="col">Title </th>
	      <th scope="col">Date when responsibility was given</th>
	      <th scope="col">Till</th>
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
	  <c:forEach var = "one" items = "${allResponsibilities }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${one.positionOfResponsibilityId}</td>
		  			<td>${one.title}</td><td>${one.dateOfPositionOfResponsibility}</td>
		  			<td>${one.till}</td>
		  			<td>${one.user.userId}</td><td>${one.user.username}</td><td>${one.user.role}</td>
		  			<td>${one.user.firstName}</td><td>${one.user.middleName}</td>
		  			<td>${one.user.lastName}</td><td>${one.user.houseNumber}</td>
		  			<td>${one.user.streetName}</td>
		  			<td>${one.user.city}</td><td>${one.user.pincode}</td>
		  			<td>${one.user.adharNumber}</td>
		  			<td>${one.user.category}</td><td>${one.user.bloodGroup}</td>
		  			<td>${one.user.gender}</td>
		  			<td>${one.user.registrationDate}</td>
		  			
		  		</tr>
		  </c:forEach>
	    
		  		
	  </tbody>
	</table>
	 <c:forEach var = "one" items = "${allResponsibilities }" >
<%-- 		  	<h1>${one.positionOfResposibilityId}</h1> --%>
		  </c:forEach>
</body>
</html>