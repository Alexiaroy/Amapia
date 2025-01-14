<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Formulaire d'inscription producteur</title>
</head>
<body>
	<h1>Formulaire d'inscription producteur</h1>

	<form action="${pageContext.request.contextPath}/producers/register"
		method="post">

		<input type="hidden" name="amapId" value="${amap.id}">
		<div>
			<label for="lastName">Nom : </label> <input type="text"
				id="lastName" name="lastName" required>
		</div>
		<br>
		<div>
			<label for="firstName">Prénom : </label> <input type="text"
				id="firstName" name="firstName" required>
		</div>
		<br>
		<div>
			<label for="email">Email: </label> <input type="email" id="email"
				name="email" required>
		</div>
		<br>
		<div>
			<label for="password">Mot de passe:</label> <input type="password"
				id="password" name="password" required>
		</div>
		<br>
		<div>
			<label for="pwdConfirmation">Confirmer le mot de passe :</label> 
			<input type="password" id="pwdConfirmation" name="pwdConfirmation" required>
		</div>
		<br>
		
<!-- phone number section (don't forget to adapt the name and add the "required" at the end) -->
		<div>
			<label for="phoneNumber">Numéro de téléphone : </label> <input
				type="text" id="phoneNumber" name="phoneNumber" >
		</div>
<!-- ************************************************************************************* -->
		<br>
		<div>
			<label for="address">Adresse : </label> <input type="text"
				id="address" name="address" required>
		</div>
		<br>
		<div>
			<label for="producerCompanyName">Nom l'exploitation : </label> <input
				type="text" id="producerCompanyName" name="producerCompanyName" required>
		</div>
		<br>
		<div>
			<label for="producerSiret">SIRET : </label> <input type="text"
				id="producerSiret" name="producerSiret" required>
		</div>
		<br>
		<div>
			<button type="submit">S'inscrire</button>
		</div>
	</form>

</body>
</html>