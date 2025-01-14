<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mise à jour du panier</title>
</head>
<body>
	<h1>Formulaire de mmise à jour du panier </h1>

	<form action="${pageContext.request.contextPath}/${producer.producer_id}/${basket.basket_id}/Updatebasket"
		method="post">

		<input type="hidden" name="amapId" value="${amap.id}">
		<input type="hidden" name="producerId" value="${producer.producer_id}">
		<div>
			<label for="basketName">Nom : </label> <input type="text"
				id="basketnName" name="subscriptionName" value="${basket.basketName}" required>
		</div>
		<br>
		<div>
			<label for="price">Prix : </label> <input type="number"
				id="price" name="price" value="${basket.price}"required>
		</div>
		<br>
		<div>
			<label for="description">Description: </label> <input type="text" id="description"
				name="description" required>
		</div>
		<br>
		<div>
			<select  name="type" id="basketType" required>
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