<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<h1>Grazie Per Essere Passato!</h1>
	<%
		session.invalidate();
	%>
	<a href="index.html">Torna ai comandi</a>
</body>
</html>