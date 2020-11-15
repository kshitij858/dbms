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
	<h3>This is Class :${oneClass.className }   Section : ${classSection.section.sectionName } 
	of year ${oneClass.classYear }</h3>
	<h4>Class Teacher : ${teacher.user.firstName }  ${teacher.user.lastName }</h4>
	<form  action = "selectClassTeacher" method = "post">
		 <div class="form-group">
   			<label for="">Select Teacher</label>
   			<select name = "teacherId" class = "form-control">
   				<c:forEach var = "oneTeacher" items = "${teachers }" >
   					<option value = "${oneTeacher.teacherId}">
   					${oneTeacher.user.firstName } ${oneTeacher.user.lastName } ${oneTeacher.teacherId }</option>
   				</c:forEach>
   			</select>
	  	</div>
	  	<button type = "submit" class = "btn btn-success" > Update Class Teacher</button>
	</form>
	<form action = "viewStudents" method = "get">
		<button class="btn btn-success" type = "submit">view Students</button>
	</form>
	<form action = "viewTeachers" method = "get">
		<button class="btn btn-success" type = "submit">view Teachers</button>
	</form>
</body>
</html>