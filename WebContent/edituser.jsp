<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="Scripts&amp;Styles/styles/insideStyle.css" rel="stylesheet"
	type="text/css" />
<!--[if IE]>
<link type="text/css"  href="Scripts&Styles/explorer/explorerstyle.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="Scripts&Styles/explorer/IEglobalstyle.css">
<![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
			String[] alldatauser = new String[13];
			alldatauser = (String[]) request.getAttribute("risultato");
			
		%>


	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[1]); %>" size="80"
			disabled>
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[2]); %>" size="80">
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[3]); %>" size="80">
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[4]); %>" size="80">
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[5]); %>" size="80">
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[6]); %>" size="80">
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[7]); %>" size="80">
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[8]); %>" size="80">
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[9]); %>" size="80"
			disabled>
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[10]); %>" size="80"
			disabled>
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[11]); %>" size="80"
			disabled>
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[12]); %>" size="80"
			disabled>
	</div>
	<div class="smallcontainer">
		<input type="text" value="<% out.print(alldatauser[13]); %>" size="80">
	</div>




</body>
</html>