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
	      <th scope="col">User Id</th>
	      <th scope="col">UserName</th>
	      <th scope="col">Role</th>
	    </tr>
	  </thead>
	  <tbody>
	    
		  <c:forEach var = "users" items = "${allUsers }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${users.user.username}</td>
		  			<td>${users.user.role}</td>
		  			<td>
		  				<form action = "${currentUrl}/${users.user.userId}/updateGenInfo" method = "get">
		  					<button class="btn btn-success" type = "submit">update general information</button>
		  				</form>
		  			</td>
		  			<td>
		  				<form action = "${currentUrl}/${users.user.userId}/updateSpecInfo" method = "get">
		  					<button class="btn btn-success" type = "submit">update user specific information</button>
		  				</form>
		  			</td>
		  		</tr>
		  </c:forEach>
	  </tbody>
	</table>
</body>
</html>