<%@page import="javax.swing.text.html.HTMLDocument.Iterator"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>tutti gli utenti</title>
</head>
<body>
	<style type="text/css">
#casella {
	padding: 10px;
	margin: 10px;
	border-style: solid;
	border-color: blue;
	border-width: 1px;
}

#casellaint {
	width: 100px;
	margin-left: 4px;
	margin-right: 4px;
}
</style>
	<h1>tutti gli utenti</h1>
	<a href="webMasterView.jsp">torna a scelta</a>
	<%
		int count = 0;
		String[][] alldata = (String[][]) request.getAttribute("tuttidati");
	%>
	<h1><%=alldata.length%></h1>
	<%
		for (int i = 0; i < alldata.length; i++) {
	%>
	<br />

	<div id="casella">
		<%
			for (int e = 1; e <= 14; e++) {
		%>

		&nbsp;<%=alldata[i][e]%>&nbsp;
		<%
			}
		%>
	</div>



	<%
		}
	%>
	<br />
	<br />
	<a href="webMasterView.jsp">torna a scelta</a>
</body>
</html>