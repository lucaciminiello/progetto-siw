<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma3.siw.model.Attività"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attività</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<h1>Lista Attività</h1>
		<form action="confermaAttivitaCancellata" method="post">
		<div>
		<c:forEach var="attività" items="${attività}">
			 <input type="radio" name="listaAttivita" value="${attività.id}">${attività.nome} 
			 <br/>
		</c:forEach>
		</div>
		&nbsp;
		<input type="submit" name="sumbit" value="invia" />
	</form>
</body>
</html>