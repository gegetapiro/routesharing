<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invio mail a <%
	request.getParameter("valoremail");
%></title>
</head>
<body>
	<%
		String oggetto = "Richiesta di condivisione auto per andare al lavoro";
		String destinatario = request.getParameter("valoremail");
		out.print(destinatario);
		String mittente = "Routesharing.org";
		String contenuto = "";
	%>
	<h1></h1>
	<form action="selectMailsend.do" method="post">
		<fieldset>
			<legend>
				richiesta di contatto a:
				<%=destinatario%></legend>
			<label>nome: <input type="text" name="name" id="name"></label>
			<label>mail: <input type="text" name="mail" id="name"></label>
			<label>telefono: <input type="text" name="tel" id="tel"></label><br>
			<br> <label>cellulare: <input type="text" name="cell"
				id="cell"></label> <label>eventuali note: <textarea
					name="note" id="note"></textarea></label>
		</fieldset>
		<input type="hidden" name="param_1" id="param_1"
			value="<%=destinatario%>"> <input type="hidden"
			name="param_2" id="param_2" value="<%=mittente%>"> <input
			type="hidden" name="param_3" id="param_3" value="<%=oggetto%>">
		<input type="hidden" name="param_4" id="param_4"
			value="<%=contenuto%>"> <input type="submit" name="invia"
			id="invia" value="INVIA COMUNICAZIONE">
	</form>

</body>
</html>