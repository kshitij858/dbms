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
	      <th scope="col">Achievement Id </th>
	      <th scope="col">Title </th>
	      <th scope="col">Date when Achievement was given</th>
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
	  <c:forEach var = "one" items = "${allAchievements }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${one.achievementId}</td>
		  			<td>${one.titleOfAchievement}</td><td>${one.dateOfAchievement}</td>
		  			<td>${one.student.user.userId}</td>
		  			<td>${one.student.user.username}</td>
		  			<td>${one.student.user.role}</td>
		  			<td>${one.student.user.firstName}</td><td>${one.student.user.middleName}</td>
		  			<td>${one.student.user.lastName}</td><td>${one.student.user.houseNumber}</td>
		  			<td>${one.student.user.streetName}</td>
		  			<td>${one.student.user.city}</td><td>${one.student.user.pincode}</td>
		  			<td>${one.student.user.adharNumber}</td>
		  			<td>${one.student.user.category}</td><td>${one.student.user.bloodGroup}</td>
		  			<td>${one.student.user.gender}</td>
		  			<td>${one.student.user.registrationDate}</td>
		  			
		  		</tr>
		  </c:forEach>
	    
		  		
	  </tbody>
	</table>
	 <c:forEach var = "one" items = "${allResponsibilities }" >
<%-- 		  	<h1>${one.positionOfResposibilityId}</h1> --%>
		  </c:forEach>
</body>
</html>