<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Scripts&Styles/styles/insideStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h3>pagina errore ricerca utenti</h3>
	<%
		String dati = (String) request.getAttribute("esitonegativo");
		out.print(dati);
	%>
<a href="disponibilita_passaggi.html"><p>TORNA ALLA PAGINA DI RICERCA</p></a>
</body>
</html>