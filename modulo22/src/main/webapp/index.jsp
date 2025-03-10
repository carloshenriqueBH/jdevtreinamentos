<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeira página jsp 08/03/2025</title>
</head>
<body>
	<h1>Bem vindo ao curso da JDEV Treinamentos</h1>
	<h2>Essa é a nossa primeira página JSP!</h2>
	
	<form action="ServletLogin" method="post">
		<table>
			<tr>
				<td><label>Login:</label></td>			
				<td><input name="login" type="text"></td>			
			</tr>
			<tr>
				<td><label>Senha:</label></td>			
				<td><input name="senha" type="password"></td>			
			</tr>
			
			<tr>
				<td></td>
				<td> <input type = "submit" value="Enviar"></td>
			</tr>
		</table>	
		
	</form>
	<h4>${msg}</h4>
</body>
</html>