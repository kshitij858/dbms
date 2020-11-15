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
	      <th scope="col">Section Id</th>
	      <th scope="col">Section Name</th>
	      <th scope="col">Number of Classes held</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var = "oneSectionClass" items = "${classesOfStudent }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${oneSectionClass.classes.classId}</td>
		  			<td>${oneSectionClass.classes.className}</td>
		  			<td>${oneSectionClass.classes.classYear}</td>
		  			<td>${oneSectionClass.section.sectionId } </td>
		  			<td>${oneSectionClass.section.sectionName } </td>
		  			<td>${oneSectionClass.classes.noOfClassesHeld}</td>
<!-- 		  			<td> -->
<%-- 		  				<form action = "addToClass/${oneClass.classId}" method = "get"> --%>
<!-- 		  					<button class="btn btn-success" type = "submit">select this class</button> -->
<!-- 		  				</form> -->
<!-- 		  			</td> -->
		  		</tr>
		  </c:forEach>
	  </tbody>
	</table>
	
	
		  		
</body>
</html>