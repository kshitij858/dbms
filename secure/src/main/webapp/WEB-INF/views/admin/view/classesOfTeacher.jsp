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
	      <th scope="col">Section Name</th>
	      <th scope="col">Course Name</th>
	      <th scope="col">Course Year</th>
	      <th scope="col">For class</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var = "oneClass" items = "${teacherWithSection }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${oneClass.classes.classId}</td>
		  			<td>${oneClass.classes.className}</td>
		  			<td>${oneClass.classes.classYear}</td>
		  			<td>${oneClass.classes.noOfClassesHeld}</td>
		  			<td>${oneClass.section.sectionName}</td>
		  			<td>${oneClass.course.courseName}</td>
		  			<td>${oneClass.course.courseYear}</td>
		  			<td>${oneClass.course.forClass}</td>
		  		</tr>
		  </c:forEach>
	  </tbody>
	</table>
	
		  		
</body>
</html>