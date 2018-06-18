<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuova Attività</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<h1>Raccogli Dati Attività</h1>
	<form action="attivita" method="post">
		<div>
			Nome: <input type="text" name="nome" value="${nome}" />
			<div>${errNome}</div>
		</div>
		&nbsp;
		<div>
			Giorno: <input type="text" name="giorno" value="${giorno}" />
			<div>${errGiorno}</div>
		</div>
		&nbsp;
		<div>
			Ora Di Inizio: <select name="oraInizio" value="${oraInizio}"
				style="width: 70px;">
				<% for(int i=9; i<=17; i++){ %>
				<option style="color: black"><%=i %></option>
				<% }%>
			</select>
			</br>
			 Ora Di Fine:  <select name="oraFine" value="${oraFine}"
				style="width: 70px;">
				<% for(int i=9; i<=19; i++){ %>
				<option style="color: black"><%=i %></option>
				<% }%>
			</select>
			<div>${errFasciaOraria}</div>
			<div>
				</br> <input type="submit" name="sumbit" value="invia" /> &nbsp; <input
					type="reset" name="reset" value="ripristina" />
			</div>
		</div>
	</form>
</body>
</html>