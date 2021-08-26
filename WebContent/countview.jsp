<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>visita precedente</h2>
	<%
		String[] lastvi;
		lastvi = (String[]) request.getAttribute("lastvisit");
	%>
	<h2>
		<%
			out.println(" Ultima lettura: " + lastvi[1] + " Gli accessi erano " + lastvi[0]);
		%>
	</h2>
	<h1>accessi routesharing</h1>

	<%
		String[][] allip;
		allip = (String[][]) request.getAttribute("tuttiip");
	%>
	<h2><%=allip.length%></h2>
	<%
		for (int i = 0; i < allip.length; i++) {
	%>
	<br>
	<%
		out.println(" id: " + allip[i][0]);
			out.println(" ip: " + allip[i][1]);
			out.println(" data: " + allip[i][2]);
	%>
	</br>
	<%
		}
	%>

</body>
</html>