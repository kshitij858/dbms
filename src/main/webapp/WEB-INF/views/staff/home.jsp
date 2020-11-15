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
	<h1>Welcome:${username}</h1>
	<form  action = "/logout">
		<button type = "submit" class = "btn btn-success" > Log out</button>
		
	</form>
	<form  action = "${username }/updateGenInfo">
		<button type = "submit" class = "btn btn-success" > Update Your Personal Information</button>
	</form>
	<form  action = "${username }/genInfo">
		<button type = "submit" class = "btn btn-success" > View General Information</button>
	</form>
	<form  action = "${username }/userSpecInfo">
		<button type = "submit" class = "btn btn-success" > View Academic Information</button>
	</form>
	<form  action = "${username }/viewFeedback">
		<button type = "submit" class = "btn btn-success" >View Feedback</button>
		
	</form>
	<form  action = "${username }/giveFeedback">
		<button type = "submit" class = "btn btn-success" >Give Feedback</button>
	</form>
	<form  action = "${username }/giveParticipationRequest">
		<button type = "submit" class = "btn btn-success" >Give Participation Request</button>
	</form>
	
	<form  action = "${username }/viewParticipationRequest">
		<button type = "submit" class = "btn btn-success" >View Participation Request</button>
	</form>
</body>
</html>