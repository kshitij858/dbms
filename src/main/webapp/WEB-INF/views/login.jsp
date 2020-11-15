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
	<form  action = "login" method = "post">
		<div class="form-group">
		<label for="formGroupExampleInput">username</label> <input
			name="username" type="text" class="form-control"
			id="formGroupExampleInput" placeholder="Example input placeholder">
	</div>
	<div class="form-group">
		<label for="formGroupExampleInput2">password</label> <input
			name="password" type="password" class="form-control"
			id="formGroupExampleInput2" placeholder="Another input placeholder">
	</div>
	<button type="submit" class="btn btn-success">sign in</button>
	</form>
</body>
</html>