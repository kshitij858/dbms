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
	<h1>Give Participation Request</h1>
	<form  action = "giveParticipationRequest" method = "post">
		 <div class="form-group">
		    <label for="">Title of Participation</label>
   			<input type="text" class="form-control" placeholder="enter first name"
   			name = "titleOfParticipationRequest">
	  	</div>
	  	
		<button type = "submit" class = "btn btn-success" > Request for participation</button>
		
	</form>
</body>
</html>