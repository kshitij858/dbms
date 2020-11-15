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
	<form  action = "addTransaction" method = "post">
		 <div class="form-group">
		    <label for="">Amount of Transaction</label>
   			<input type="number" class="form-control" placeholder="enter first name"
   			name = "amount">
	  	</div>
	  	<div class="form-group">
		    <label for=""> Date of transaction</label>
   			<input type="text" class="form-control" placeholder="YYYY-MM-DD" name = dateOfTransaction value = "${today }">
	  	</div>
		<button type = "submit" class = "btn btn-success" >Add Transaction</button>
	</form>

</body>
</html>