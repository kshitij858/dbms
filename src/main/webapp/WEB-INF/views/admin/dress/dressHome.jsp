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
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css"> 
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
</head>
<body>
	<div class="btn-group">
		  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		   Add uniform
		  </button>
		  <div class="dropdown-menu">
		    <form action = "addDress" method = "get">
	  			<div class="form-group">
				    <label for="">Dress Description</label>
		   			<input type="text" class="form-control" placeholder="For ex: blue trouser"
		   			name = "dressDescription">
			  	</div>
 					<button class="btn btn-success" type = "submit">Add this Uniform</button>
 				</form>
		  </div>
	</div>
	<table class="table table-dark table-responsive ">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Dress Id</th>
	      <th scope="col">Dress Description</th>
	    </tr>
	  </thead>
	    <tbody>
	  <c:forEach var = "one" items = "${dresses }" >
		  		<tr>
		  			<th scope = "row"> 1</th>
		  			<td>${one.dressId}</td>
		  			<td>${one.dressDescription}</td>
		  			</tr>
		  </c:forEach>
	    
		  		
	  </tbody>
	</table>
</body>
</html>