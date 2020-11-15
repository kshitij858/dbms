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
	      <th scope="col">Course Id</th>
	      <th scope="col">Course Name</th>
	      <th scope="col">Course Year</th>
	      <th scope="col">For Class</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var = "oneClassAndCourse" items = "${classesAndCourses }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${oneClassAndCourse.course.courseId}</td>
		  			<td>${oneClassAndCourse.course.courseName}</td>
		  			<td>${oneClassAndCourse.course.courseYear}</td>
		  			<td>${oneClassAndCourse.course.forClass}</td>
		  		</tr>
		  </c:forEach>
	    
		  		
	  </tbody>
	</table>

	<form action = "newCourse" method = "get">
		  <button class="btn btn-success" type = "submit">Link New Course</button>
	</form>
</body>
</html>