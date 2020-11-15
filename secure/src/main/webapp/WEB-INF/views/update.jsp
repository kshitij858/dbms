<%@include file = "/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<%@ page isELIgnored="false" %>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page with username!!</title>
</head>
<body>
	<h1>Update your information:${username}</h1>
	<form  action = "	update" method = "post">
		 <div class="form-group">
		    <label for="">First Name</label>
   			<input type="text" class="form-control" placeholder="enter first name", name = firstName>
	  	</div>
	  	<div class="form-group">
		    <label for="">Middle Name</label>
   			<input type="text" class="form-control" placeholder="enter middle name", name = middleName>
	  	</div>
	  	<div class="form-group">
		    <label for="">Last Name</label>
   			<input type="text" class="form-control" placeholder="enter last name", name = lastName>
	  	</div>
	  	<div class="form-group">
		    <label for="">House Number</label>
   			<input type="text" class="form-control" placeholder="enter house number", name = houseNumber>
	  	</div>
	  	<div class="form-group">
		    <label for="">City Name</label>
   			<input type="text" class="form-control" placeholder="enter city name", name = city>
	  	</div>
	  	<div class="form-group">
		    <label for="">Street Name</label>
   			<input type="text" class="form-control" placeholder="enter street name", name = streetName>
	  	</div>
	  	<div class="form-group">
		    <label for="">Pin Code</label>
   			<input type="number" class="form-control" placeholder="enter pin code", name = streetName>
	  	</div>
	  	<div class="form-group">
		    <label for="">Adhar Number</label>
   			<input type="text" class="form-control" placeholder="enter Adhar Number", name = adharNumber>
	  	</div>
	  	<div class="form-group">
		    <label for="">Category</label>
   			<input type="text" class="form-control" placeholder="enter category", name = category>
	  	</div>
	  	<div class="form-group">
		    <label for="">Blood Group</label>
   			<input type="text" class="form-control" placeholder="enter blood group", name = bloodGroup>
	  	</div>
	  	<div class="form-group">
		    <label for="">Gender</label>
   			<input type="text" class="form-control" placeholder="enter Gender", name = gender>
	  	</div>
		<button type = "submit" class = "btn btn-success" > Update</button>
		
	</form>
</body>
</html>