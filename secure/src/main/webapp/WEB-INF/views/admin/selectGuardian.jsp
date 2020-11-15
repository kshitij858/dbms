<%@include file = "/WEB-INF/views/template/header.jsp" %>
<%@ page isELIgnored="false" %>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

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
	      <th scope="col">Guardian Id</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var = "one" items = "${allGuardians }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${one.user.userId}</td><td>${one.user.username}</td><td>${one.user.role}</td>
		  			<td>${one.user.firstName}</td><td>${one.user.middleName}</td>
		  			<td>${one.user.lastName}</td><td>${one.user.houseNumber}</td>
		  			<td>${one.user.streetName}</td>
		  			<td>${one.user.city}</td><td>${one.user.pincode}</td>
		  			<td>${one.user.adharNumber}</td>
		  			<td>${one.user.category}</td><td>${one.user.bloodGroup}</td>
		  			<td>${one.user.gender}</td>
		  			<td>${one.user.registrationDate}</td>
		  			<td>${one.guardianId}</td>
		  			<td><form action = "addGuardian/${one.guardianId }" method = "post">
				  			<div class="form-group">
							    <label for="">Relationship</label>
					   			<input type="text" class="form-control" placeholder="enter first name"
					   			name = "relationship">
						  	</div>
		  					<button class="btn btn-success" type = "submit">Add</button>
		  				</form>
					</td>
		  			
		  			
		  		</tr>
		  </c:forEach>
	    
		  		
	  </tbody>
	</table>
</body>
</html>