<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="it" ><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>pagina risposta</title>
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
	<div class="container">
		<%
			String risposta = (String) request.getAttribute("esito");
			String mail = (String) request.getAttribute("indimail");
			String pass = (String) request.getAttribute("thepassword");
			out.print(risposta);
		%>
		<h3>Ora se vuoi puoi da subito verificare se c'è qualcuno compatibile</h3>
		<form action="selectSearchpartnerlg.do" method="post">
			<fieldset>
				<legend>Verifica se c'è qualcuno che fà il tuo stesso percorso</legend>
				<div class="row">
					<div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="udmaillt">Tuo indirizzo mail:</label>
							<input type="email" name="udmaillt" id="udmaillt" value="<%=mail%>" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="passwordlt"> password:</label>
							<input type="text" name="passwordlt" id="passwordlt" value="<%=pass%>" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="diametroricerca">scegli il raggio di ricerca di:</label>
							<select name="diametroricerca" id="diametroricerca" class="form-control">
								<option value="1">Nelle vicinanze</option>
								<option value="2">all'incirca 5 km</option>
								<option value="3">da centro a periferia circa 7 km</option>
								<option value="4">da centro a paesi vicini circa 13 km</option>
								<option value="5">provincia città medio grande 70km circa</option>
							</select>
						</div>
					</div>
				</div>
				<input type="submit" value="INVIA DATI" />
			</fieldset>
		</form>
	</div>
</body>
</html>