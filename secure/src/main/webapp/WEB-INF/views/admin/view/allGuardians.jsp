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
	  <c:forEach var = "student" items = "${allUsers }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${student.user.userId}</td><td>${student.user.username}</td><td>${student.user.role}</td>
		  			<td>${student.user.firstName}</td><td>${student.user.middleName}</td>
		  			<td>${student.user.lastName}</td><td>${student.user.houseNumber}</td>
		  			<td>${student.user.streetName}</td>
		  			<td>${student.user.city}</td><td>${student.user.pincode}</td>
		  			<td>${student.user.adharNumber}</td>
		  			<td>${student.user.category}</td><td>${student.user.bloodGroup}</td>
		  			<td>${student.user.gender}</td>
		  			<td>${student.user.registrationDate}</td>
		  			<td>${student.guardianId}</td>
		  			<td><div class="btn-group">
						  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Update
						  </button>
						  <div class="dropdown-menu">
						    <a class="dropdown-item" href="/admin/${username}/allGuardians/${student.user.userId}/updateGenInfo">Update General Information</a>
						  </div>
						</div>
					</td>
					<td><div class="btn-group">
					  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    Contact details
					  </button>
					  <div class="dropdown-menu">
					    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/viewPhoneNumbers">view Phone numbers</a>
					    <a class="dropdown-item" href="${currentUrl}/${student.user.userId}/viewEmails">view Emails</a>
					    <form action = "${currentUrl}/${student.user.userId}/addPhoneNumber" method = "post">
				  			<div class="form-group">
							    <label for="">Contact Number</label>
					   			<input type="text" class="form-control" placeholder="enter first name"
					   			name = "phoneNumber">
						  	</div>
		  					<button class="btn btn-success" type = "submit">Add this number</button>
		  				</form>
		  				 <form action = "${currentUrl}/${student.user.userId}/addEmail" method = "post">
				  			<div class="form-group">
							    <label for="">Email Address</label>
					   			<input type="text" class="form-control" placeholder="enter first name"
					   			name = "email">
						  	</div>
		  					<button class="btn btn-success" type = "submit">Add this email address</button>
		  				</form>
					  </div>
					</div>
					</td>
		  		</tr>
		  </c:forEach>
	    
		  		
	  </tbody>
	</table>
</body>
</html>