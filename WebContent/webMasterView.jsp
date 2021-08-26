<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accesso per vista tutti utenti</title>
</head>
<body>
	<form action="selectCheckpassword.do" method="post">
		<label>user <input type="text" name="user"></label> <br /><br />
         <label>password <input type="password" name="password"></label><br /><br />
         <label>passaggi per lavoro <input type="radio" name="sceltadb" id="sceltadb" value="db_1" checked></label>
         <label>passaggi unatantum <input type="radio" name="sceltadb" id="sceltadb" value="db_2"></label><br /><br />
          <input type="submit" value="INVIA">
	</form>

</body>
</html>