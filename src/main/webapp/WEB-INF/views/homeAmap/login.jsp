<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/signup.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5 d-flex justify-content-center">
	<div class="w-50">
	    <h2 class="text-center">Connexion</h2>
	    <hr style="max-width: 50px;"/>
		<br>
		<form action="${pageContext.request.contextPath}/${linkName}/login"
				method="post" class="mt-4">
				<div class="form-group">
				
					<label for="email">Email</label> <input type="email" id="email" class="form-control"
						name="email" required> 
				</div>
				<div class="form-group">
					<label for="password">Mot de passe</label> <input type="password" id="password" class="form-control" name="password"
					required> 
				</div>
				<div class="button-container">
					<button type="submit">Se connecter</button>
				</div>
	
					<c:if test="${not empty error}">
						<div class="alert alert-danger mt-3">
						${error}
						</div>
					</c:if>
					
					
					<hr style="max-width: 50px;"/>
				<p class="text-center">Pas encore inscrit ? <br><a href="">Devenez membre !</a></p>
				
				

		</form>

		</div>

</div>

</body>
</html>
