<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Scripts&Styles/styles/insideStyle.css">
<!--[if IE]>
<link type="text/css"  href="Scripts&Styles/explorer/explorerstyle.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="Scripts&Styles/explorer/IEglobalstyle.css">
<![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>pagina risposta</title>
</head>
<body class="insederbodyshort">
	<h3>pagina risposta</h3>
	<%
		String risposta = (String) request.getAttribute("esito");
		out.print(risposta);
		String partial = risposta.substring(17, 24);
		if (partial.equals("fallito")) {
	%>
	problemi riprova
	<%
		} else {

			String mail = (String) request.getAttribute("indimail");
			String pass = (String) request.getAttribute("thepassword");
	%>
	<h3>Ora se vuoi puoi da subito verificare se c'è qualcuno
		compatibile</h3>
	<form action="selectSearchpartner.do" method="post">
		<fieldset>
			<legend>Verifica se c'è qualcuno che fà il tuo stesso
				percorso</legend>
			<label class="allinea">Tuo indirizzo mail: <input type="text"
				name="udmail" id="udmail" value="<%=mail%>" /></label> <label
				class="allinea">password: <input type="text" name="password"
				id="password" value="<%=pass%>" />
			</label>

		</fieldset>
		<input type="submit" value="INVIA DATI" />
	</form>
	<%
		}
	%>
</body>
</html>