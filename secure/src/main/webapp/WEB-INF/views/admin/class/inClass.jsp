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
	      <th scope="col">Section Id</th>
	      <th scope="col">Section Name</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var = "oneSectionsAndClasses" items = "${sectionsAndClasses }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${oneSectionsAndClasses.section.sectionId}</td>
		  			<td>${oneSectionsAndClasses.section.sectionName}</td>
		  			<td><form action = "${oneSectionsAndClasses.section.sectionId}/view" 
		  			method = "get">
		  				<button class="btn btn-success" type = "submit">View</button>
					</form></td>
		  		</tr>
		  </c:forEach>
	    
		  		
	  </tbody>
	</table>

	<form action = "newSection" method = "get">
		  <button class="btn btn-success" type = "submit">Create New Section</button>
	</form>
</body>
</html>