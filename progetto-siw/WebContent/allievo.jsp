<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Di Conferma</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<h1>Riepilogo Dati</h1>
	<div>Nome: ${allievo.nome}</div>
	<div>Cognome: ${allievo.cognome}</div>
	<div>Email: ${allievo.email}</div>
	<div>LuogoNascita: ${allievo.luogoNascita}</div>
	<div>DataNascita: ${allievo.giorno}/${allievo.mese}/${allievo.anno}</div>
	<div>NumeroTelefono: ${allievo.numeroTelefono}</div>
	&nbsp;
	<div>I dati inseriti sono corretti?</div>
	<a href="conferma">Conferma</a>
	<a href="newAllievo.jsp">Annulla</a>

</body>
</html>