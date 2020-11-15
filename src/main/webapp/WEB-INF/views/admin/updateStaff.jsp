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
	<form  action = "updateSpecInfo" method = "post">
		 <div class="form-group">
		    <label for="">Salary</label>
   			<input type="text" class="form-control" placeholder="enter fees Due" 
   			name = "salary" value = "${staff.salary }">
   		 </div>
	  	
	  	<div class="form-group">
		    <label for="">Leaves taken</label>
   			<input type="number" class="form-control" placeholder="enter leaves Taken" 
   			name = "leavesTaken" value = "${staff.leavesTaken }">
	  	</div>
	  	
	  	<div class="form-group">
		    <label for="">Designation</label>
   			<input type="text" class="form-control" placeholder="enter fees Due" 
   			name = "designation" value = "${staff.designation }">
   		 </div>
   		 <div class="form-group">
		    <label for="">Number of leaves allowed</label>
   			<input type="text" class="form-control" placeholder="enter fees Due"
   			name = "numberOfLeavesAllowed" value = "${staff.numberOfLeavesAllowed }">
   		 </div>
		<button type = "submit" class = "btn btn-success" > Update</button>
		
	</form>
</body>
</html>