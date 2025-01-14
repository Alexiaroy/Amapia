<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modification profil</title>
</head>
<body>
	<h1>Modifier son profil</h1>

	<form action="${pageContext.request.contextPath}/producers/updateProfile/${producer.producer_id}"
		method="post"> 
		
	<input type="hidden" name="amapId" value="${producer.member.amap.id}">
	<input type="hidden" name="id" value="${producer.member.member_id}">
   
		
		<div>
			<label for="lastName">Nom : </label> <input type="text"
				id="lastName" name="lastName"  value="${producer.member.lastName}" required>
		</div>
		<br>
		<div>
			<label for="firstName">Prénom : </label> <input type="text"
				id="firstName" name="firstName" value="${producer.member.firstName}" required>
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
				id="address" name="address" value="${producer.member.address}" required >
		</div>
		<br>
		<div>
			<label for="producerCompanyName">Nom l'exploitation : </label> <input
				type="text" id="producerCompanyName" name="producerCompanyName" value="${producer.producerCompanyName}" required>
		</div>
		<br>
		<div>
			<label for="producerSiret">SIRET : </label> <input type="text"
				id="producerSiret" name="producerSiret" value="${producer.producerSiret}" required>
		</div>
		<br>
		<div>
			<button type="submit">Enregistrer les modifications</button>
		</div>
	</form>

</body>
</html>