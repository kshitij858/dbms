

<%@include file = "/WEB-INF/views/template/header.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel = "stylesheet" href = "/css/style.css">
<link rel = "stylesheet" href = "/css/style.css">
<script src="/js/main.js"></script>
<meta charset="ISO-8859-1">
<title>See All USERS!!!</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css"> 
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>

</head>
<body>
	<h1>Welcome:${username}</h1>
	<form  action = "/logout">
		<button type = "submit" class = "btn btn-success" > Log out</button>
		
	</form>
	
	<form  action = "${username }/classes">
		<button type = "submit" class = "btn btn-success" > Classes</button>
	</form>
	<div class="btn-group">
		  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    View Users
		  </button>
		  <div class="dropdown-menu">
		    <a class="dropdown-item" href="${username }/allAdmins">See all admins</a>
		    <a class="dropdown-item" href="${username }/allStudents">See all students</a>
		    <a class="dropdown-item" href="${username }/allTeachers">See all teachers </a>
		    <a class="dropdown-item" href="${username }/allStaffs">See all staffs</a>
		    <a class="dropdown-item" href="${username }/allGuardians">See all guardians</a>
		  </div>
	</div>
	<p></p>
	<form  action = "${username }/courses">
		<button type = "submit" class = "btn btn-success" > Courses</button>
	</form>
	
	<form  action = "${username }/positionOfResponsibilities">
		<button type = "submit" class = "btn btn-success" > Position Of Responsibilities</button>
	</form>
	<form  action = "${username }/update">
		<button type = "submit" class = "btn btn-success" > Update Your Personal Information</button>
	</form>
	<form  action = "${username }/giveFeedback">
		<button type = "submit" class = "btn btn-success" >Give Feedback</button>
	</form>
	
	<form  action = "${username }/viewFeedback">
		<button type = "submit" class = "btn btn-success" >View Feedback</button>
	</form>
	<form  action = "${username }/viewParticipationRequest">
		<button type = "submit" class = "btn btn-success" >View Participation Requests</button>
	</form>
	<form  action = "${username }/transactions">
		<button type = "submit" class = "btn btn-success" >Transactions</button>
	</form>
	<form  action = "${username }/dress">
		<button type = "submit" class = "btn btn-success" >Uniforms</button>
	</form>
	

	
</body>


</html>