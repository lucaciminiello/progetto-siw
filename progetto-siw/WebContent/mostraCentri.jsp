<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma3.siw.model.Centro"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Centri</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<h1>Lista Centri</h1>
	<ul>
		<c:forEach var="centro" items="${centri}">
			<li>
				<div><a href="centro?idCentro=${centro.id}">${centro.nome}</a></div>
				<div>Contatti : ${centro.numeroTelefono}</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
