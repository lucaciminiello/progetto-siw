<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma3.siw.model.Attività"%>
<%@ page import="it.uniroma3.siw.model.Allievo"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${centro.nome}</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
<h1>${centro.nome}</h1>
<h2 style="text-align:left;">Lista Attività</h2>
	<ul>
		<c:forEach var="attività" items="${centro.attività}">
			<li>
				<div>${attività.nome} : ${attività.giorno} ${attività.oraInizio}-${attività.oraFine}</div>
			</li>
		</c:forEach>
	</ul>
<h2 style="text-align:left;">Lista Allievi</h2>
	<ul>
		<c:forEach var="allievo" items="${centro.allievi}">
			<li>
				<div>${allievo.nome} ${allievo.cognome} :</div>
				<div>Nato a : ${allievo.luogoNascita}</div>
				<div>Email : ${allievo.email}</div>
				<div>Numero di Telefono : ${allievo.numeroTelefono}</div>
				</br>
			</li>
		</c:forEach>
	</ul>
	<a href = "index.html">Torna ai comandi</a>
	</br>
</body>
</html>