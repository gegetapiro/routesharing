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
<title>Pagina di errore mail già registrata</title>
</head>
<body>
	<div class="container">
		<h4>
			<%
				String rispostaerrore = (String) request.getAttribute("errore");
				out.print(rispostaerrore);
			%>
		</h4>
		<h4>
			<a href="gotojobplace.html">Torna ad ad inserimento dati</a>
		</h4>
	</div>
</body>
</html>