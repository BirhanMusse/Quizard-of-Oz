<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<div class="display">
		<!-- insert values from the Model into the DOM for server-side rendering -->
		<p>Welcome, ${firstname}!</p>
		<span><b>User profile</b></span><br>
		<span>First name: ${firstname}</span><br>
		<span>Last name: ${lastname}</span><br>
		<span>User name: ${username}</span><br>
		<span>User type: ${usertype}</span><br>
		<span>Email: ${email}</span><br>
		<br>
		<br>
		<form action="logout" method="get" id="logOutForm">
			<input type="submit" value="logout" />
		</form>
	</div>
</body>
</html>