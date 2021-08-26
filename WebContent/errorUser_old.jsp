<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina di errore mail già registrata</title>
</head>
<body>
<script language="javascript" src="personalscript/allscript.js"></script>
	<%
		String rispostaerrore = (String) request.getAttribute("errore");
		out.print(rispostaerrore);
	%>
	<p><a href="gotojobplace.html">Torna ad ad inserimento dati</a></p>
</body>
</html>