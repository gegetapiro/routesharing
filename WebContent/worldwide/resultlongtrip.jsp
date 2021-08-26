<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en" ><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>pagina risposta</title>
<!-- Fogli di stile -->
<link href="../assets/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="../assets/css/stili-custom.css" rel="stylesheet" media="screen">
<!-- Modernizr -->
<script src="../assets/js/modernizr.custom.js"></script>
<!-- respond.js per IE8 -->
<!--[if lt IE 9]>
		<script src="../js/respond.min.js"></script>
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
		<h3>Now if you want, you can check out immediately if there is someone compatible</h3>
		<form action="../selectSearchpartnerlg.do" method="post">
			<fieldset>
				<legend>Check if there is someone who does your own path</legend>
				<div class="row">
					<div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="udmaillt">Your mail:</label>
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
							<label for="diametroricerca">Choose the search radius:</label>
							<select name="diametroricerca" id="diametroricerca" class="form-control">
								<option value="1">Nearby</option>
								<option value="2">approximately 5 km</option>
								<option value="3">From center to periphery, about 7 km</option>
								<option value="4">From center to neighboring countries, about 13 km</option>
								<option value="5">Great middle city province 70 km circa</option>
							</select>
						</div>
					</div>
				</div>
				<input type="hidden" name="whatlanguage" id="whatlanguage" value="english">
				<input type="submit" value="SEND DATA" />
			</fieldset>
		</form>
	</div>
</body>
</html>