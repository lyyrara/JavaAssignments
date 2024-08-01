<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ecommerce Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div style="margin-left: 280px; font-size: 50px;">Welcome
		To ECommerce Application</div>
	<div style="margin-left: 500px; color: green;">${registerSuccess}</div>
	<div style="margin-left: 500px; color: red;">${loginFailedStatus}</div>
	<form action="/login" method="post">
	${unauthorizedMessage }
	${unauthenticatedMessage}
	<div style="margin-left: 500px; margin-right: 500px">
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Username</label>
			<input type="text" class="form-control" id="exampleFormControlInput1"
				placeholder="Provide your Username" name = "userId">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">Password</label>
			<input type="text" class="form-control" id="exampleFormControlInput1"
				placeholder="Provide your Password" name = "password">
		</div>
		
		<button style="margin-left: 100px" type="submit" class="btn btn-primary">Login</button><br><br>
		</form>
		<a style="margin-left: 50px" href="/signup">New User? Register Here!!</a>
		
	</div>

</body>
</html>

