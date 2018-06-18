<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Di Login</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
  <h1>Login Utente</h1>
	<form action="j_security_check" method="POST">
		Nome: <input type="text" name="j_username" />
		Password: <input type="password" name="j_password" />
		<br/>
		<input type="submit" value="Entra">
	</form>
</body>
</html>