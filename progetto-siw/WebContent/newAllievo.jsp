<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuovo Allievo</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<h1>Raccogli Dati Allievo</h1>
	<form action="allievo" method="post">
		<div>
			Nome: <input type="text" name="nome" value="${nome}" />
			<div> ${errNome} </div>
		</div>
		&nbsp;
		<div>
			Cognome: <input type="text" name="cognome" value="${cognome}" />
			<div>${errCognome}</div>
		</div>
		&nbsp;
		<div>
			Email: <input type="text" name="email" value="${email}"/>
			<div>${errEmail}</div>
		</div>
		&nbsp;
		<div>
			Data Di Nascita: 
			<br/>
			<div style="display:inline-flex">
			<select name="giorno" value="${giorno}" style="width:70px;">
			<% for(int i=1; i<=31; i++){ %>
				<option style="color:black"><%=i %></option>
			<% }%>
			</select>
			 /
			 <select name="mese" value="${mese}" style="width:70px;">
			<% for(int i=1; i<=12; i++){ %>
				<option style="color:black"><%=i %></option>
			<% }%>
			</select>
			 / 
			 <select name="anno" value="${anno}" style="width:95px;">
			<% for(int i=1980; i<=2000; i++){ %>
				<option style="color:black"><%=i %></option>
			<% }%>
			</select>
			</div>
			<div>${errDataNascita}</div>
		</div>
		&nbsp;
		<div>
			Luogo Di Nascita: <input type="text" name="luogoNascita" value="${luogoNascita}"/>
			<div>${errLuogoNascita}</div>
		</div>
		&nbsp;
		<div>
			Numero Di Telefono: <input type="text" name="numeroTelefono" value="${numeroTelefono}"/>
			<div>${errNumeroTelefono}</div>
		</div>
		&nbsp;
		<div>
			<input type="submit" name="sumbit" value="invia" />
			&nbsp;
			<input type="reset" name="reset" value="ripristina" />
		</div>
		
	</form>
</body>
</html>