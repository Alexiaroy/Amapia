<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Confirmation page</title>
</head>
<body>
	<h1>Inscription réussie !</h1>

	<!--Name used on the RequestMapping controller. 
	Example: @RequestMapping("/name")=> href="${pageContext.request.contextPath}/name    -->
	<a href="${pageContext.request.contextPath}/producers"> Retour à
		l'accueil</a>


	<!-- Link to the producer list of all amaps -->
	<a href="${pageContext.request.contextPath}/producers/allProducers">
		<button type="button">Afficher la liste des producteurs</button>
	</a>

</body>
</html>