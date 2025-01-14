<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Liste des Paniers</title>
</head>
<body>
<div class="container-fluid">
	<div class="col-10 m-auto">
	    <h2 class="text-center mb-4">Liste des commandes</h2>
	
	    <table class="table text-center table-hover">
	        <thead class="bg-primary">
	            <tr class="text-white">
	                <th>Nom du panier</th>
	                <th>Prix</th>
	                <th>Description</th>

	            </tr>
	        </thead>
	        <tbody>
	       
	            <c:forEach var="basket" items="${baskets}">
	           
	                <tr>	      
	                    <td>${basket.name}</td>
	                    <td>${basket.price}</td>
	                    <td>${basket.description}</td>				
	 
	                </tr>
	         
	            </c:forEach>
	        </tbody>
	    </table>
	</div>
</div>
</body>
</html>