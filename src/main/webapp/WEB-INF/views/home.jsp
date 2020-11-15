<%@include file = "/WEB-INF/views/template/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Create an account</title>

</head>

<form action="processReg" method="post">
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
	<div class="form-group">
		<label for="formGroupExampleInput">role</label> 
		<input name="role"
			type="text" class="form-control" id="formGroupExampleInput"
			placeholder="Example input placeholder">
	</div>
	<button type="submit" class="btn btn-success">sign up</button>
</form>

</body>
</html>