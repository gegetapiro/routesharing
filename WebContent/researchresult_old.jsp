<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultato ricerca condivisione</title>
<link href="Scripts&Styles/styles/insideStyle.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<h3>Risultato utenti compatibili trovati</h3>
	<div id="tabresult">
		<%
			
			int lunghezza = Integer.parseInt(request.getAttribute("resullong").toString());
		if(lunghezza > 0){
			String[][] lamatrice = new String[lunghezza][7];
			lamatrice = (String[][]) request.getAttribute("risullistcomp");
			
			for (int i = 0; i < lunghezza; i++) {
		%>
		<div id="trlivel">
			<%
				for (int e = 0; e < 7; e++) {
			%>
			<div id="tdlivel">
				<%
					out.print(lamatrice[i][e]);
				%>
			</div>

			<%
				}
			%>
			<form action="mailform.jsp" method="post">
				<input type="hidden" id="valoremail" name="valoremail"
					value="<%=lamatrice[i][1]%>" /> <label> Invia mail a: <input type="submit" value="CONTATTA" />
				</label>
			</form>
		</div>
		<%
			}
		}else{
			out.print("nesssun utente compatibile trovato");
		}
		%>
	</div>
</body>
</html>
