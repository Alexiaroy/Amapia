<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Liste des Commandes</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/amaptablestyles.css">
</head>
<body>
	<header><jsp:include
			page="/WEB-INF/views/BackOfficeAmapia/templates/headerBO.jsp" /></header>
<div class="container-fluid">
	<div class="col-10 m-auto">
	    <h2 class="text-center mb-4">Liste des commandes</h2>
	
	    <table class="table text-center table-hover">
	        <thead class="bg-primary">
	            <tr class="text-white">
	                <th>Id de la commande</th>
	                <th>Prix</th>

	            </tr>
	        </thead>
	        <tbody>
	       
	            <c:forEach var="order" items="${orders}">
	           
	                <tr>	      
	                    <td>${order.order_id}</td>
	                    <td>${order.price}</td>			
	 
	                </tr>
	         
	            </c:forEach>
	        </tbody>
	    </table>
	</div>
</div>
</body>
</html>