<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en" ><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../Scripts&Styles/styles/insideStyle.css">
<!-- Fogli di stile -->
<link href="../assets/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="../assets/css/stili-custom.css" rel="stylesheet" media="screen">
<!-- Modernizr -->
<script src="../assets/js/modernizr.custom.js"></script>
<!-- respond.js per IE8 -->
<!--[if lt IE 9]>
		<script src="../js/respond.min.js"></script>
		<![endif]-->
<title>Result registration to route-sharing</title>
</head>
<body>
	<div class="container">
		<h1>answer page</h1>
		<%
			String risposta = (String) request.getAttribute("esito");
			out.print(risposta);
			String partial = risposta.substring(17, 24);
			if (partial.equals("fallito")) {
		%>
		<h4>some problems retry</h4>
		<%
			} else {

				String mail = (String) request.getAttribute("indimail");
				String pass = (String) request.getAttribute("thepassword");
		%>
		<h4>Now if you want, you can check out immediately if there is someone compatible</h4>
		<form action="../selectSearchpartner.do" method="post">
			<fieldset>
				<h6>Check if there is someone who does your own path</h6>
				<div class="row">
					<div class="col-xs-8 col-sm-5 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="udmail">Your mail: </label>
							<input type="text" name="udmail" id="udmail" value="<%=mail%>" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-8 col-sm-5 col-md-4 col-lg-3">
						<div class="form-group">
							<label for="password">password: </label>
							<input type="text" name="password" id="password" value="<%=pass%>" class="form-control" />
						</div>
					</div>
				</div>
			</fieldset>
			<input type="hidden" name="whatlanguage" id="whatlanguage" value="english">
			<input type="submit" value="SEND DATA" />
		</form>
		<%
			}
		%>
	</div>
</body>
</html>