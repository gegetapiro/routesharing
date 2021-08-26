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
<title>Invio mail a <%
	request.getParameter("valoremail");
%></title>
</head>
<body>
	<br />
	<br />
	<div class="container">
		<%
			String oggetto = "Richiesta di condivisione auto per andare al lavoro";
			String destinatario = request.getParameter("valoremail");
			//out.print(destinatario);
			String mittente = "Routesharing.org";
			String contenuto = "";
		%>

		<form action="selectMailsend.do" method="post">
			<fieldset>
				<legend>
					Contact request to: <span class="mailclass"><%=destinatario%></span>
				</legend>
				<div class="row">
					<div class="col-xs-8 col-sm-5 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="name">name:</label>
							<input type="text" name="name" id="name" class="form-control">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-8 col-sm-5 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="mail">mail:</label>
							<input type="mail" name="mail" id="mail" class="form-control">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-8 col-sm-5 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="tel">phone:</label>
							<input type="tel" name="tel" id="tel" class="form-control">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-8 col-sm-5 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="cell">cell phone:</label>
							<input type="tel" name="cell" id="cell" class="form-control">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-8 col-sm-5 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="note">possible notes:</label>
							<textarea name="note" id="note" class="form-control"></textarea>
						</div>
					</div>
				</div>

			</fieldset>

			<input type="hidden" name="param_1" id="param_1" value="<%=destinatario%>">
			 <input type="hidden" name="param_2" id="param_2" value="<%=mittente%>">
			  <input type="hidden" name="param_3" id="param_3" value="<%=oggetto%>"> <input type="hidden" name="param_4" id="param_4" value="<%=contenuto%>">
			  <input type="hidden" name="whatlanguage" id="whatlanguage" value="english">
			   <input type="submit" name="invia" id="invia" value="INVIA COMUNICAZIONE">
		</form>
	</div>
</body>
</html>