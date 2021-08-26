<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en" ><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="Scripts&Styles/styles/insideStyle.css">
<!-- Fogli di stile -->
<link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="assets/css/stili-custom.css" rel="stylesheet" media="screen">
<!-- Modernizr -->
<script src="assets/js/modernizr.custom.js"></script>
<!-- respond.js per IE8 -->
<!--[if lt IE 9]>
		<script src="js/respond.min.js"></script>
		<![endif]-->
</head>
<body>
	<div class="container-fluid">
		<h3 class="spazio">Risultato utenti compatibili trovati</h3>
		<%
			int lunghezza = Integer.parseInt(request.getAttribute("resullong").toString());
			if (lunghezza > 0) {
				String[][] lamatrice = new String[lunghezza][7];
				lamatrice = (String[][]) request.getAttribute("risullistcomp");

				for (int i = 0; i < lunghezza; i++) {
		%>
		<div class="spazio">

			<%
				for (int e = 0; e < 7; e++) {
			%>
			<div class="row">
				<div class="col-xs-8 col-sm-8 col-md-6 col-lg-4">
					<div class="form-group">
						<%
							out.print(lamatrice[i][e]);
						%>
					</div>
				</div>
			</div>


			<%
				}
			%>
			<form action="mailform.jsp" method="post">
				<input type="hidden" id="valoremail" name="valoremail" value="<%=lamatrice[i][1]%>" />
				<label>
					Invia mail a: <input type="submit" value="CONTATTA" />
				</label>
			</form>

		</div>
		<%
			}
			} else {
				out.print("nessun utente compatibile trovato");
			}
		%>
		<br />
		<br /> <a href="condivisione-passaggi.html">Torna alla home</a>
	</div>
</body>
</html>