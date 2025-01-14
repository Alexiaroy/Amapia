<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Formulaire de création d'abonnement</title>
</head>
<body>
	<h1>Formulaire de création d'abonnement </h1>

	<form action="producers/${producer.producer_id}/CreateBasket"
		method="post">

		<input type="hidden" name="amapId" value="${amap.id}">
		<input type="hidden" name="producerId" value="${producer.producer_id}">
		<div>
			<label for="basketName">Nom : </label> <input type="text"
				id="basketName" name="basketnName" required>
		</div>
		<br>
		<div>
			<label for="price">Prix : </label> <input type="number"
				id="price" name="price" required>
		</div>
		<br>
		<div>
			<label for="description">Description: </label> <input type="text" id="description"
				name="description" required>
		</div>
			<div>
			<label for="stock">Stock: </label> <input type="number" id="stock"
				name="stock" required>
		</div>
		<br>
		<div>
			<select name="type" id="type-select" required>
  <option value="">--Choisissez un type--</option>
  <option value="fruit">Fruit</option>
  <option value="veggie">Légume</option>
  <option value="mix">Mixte</option>

</select>

		</div>
		
		<div>
			<button type="submit">Soumettre</button>
		</div>
	</form>

</body>
</html>