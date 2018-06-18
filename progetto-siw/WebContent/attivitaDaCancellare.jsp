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
	<div>Nome: ${attività.nome}</div>
	<div>Giorno: ${attività.giorno}</div>
	<div>Orario: ${attività.oraInizio}-${attività.oraFine}</div>
	&nbsp;
	<div>Vuoi davvero cancellare questa attività?</div>
	<a href="rispostaAttivitaEliminata">Conferma</a>
	<a href="cancellaAttivita.jsp">Annulla</a>

</body>
</html>