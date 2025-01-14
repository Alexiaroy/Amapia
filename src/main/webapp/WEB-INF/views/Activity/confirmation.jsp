<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation page</title>
</head>
<body>
	<h1>Ajout d'activité réussie !</h1>

	<!--Name used on the RequestMapping controller. 
	Example: @RequestMapping("/name")=> href="${pageContext.request.contextPath}/name    -->
	<a href="${pageContext.request.contextPath}/activities"> Retour à
		l'accueil</a>


	<!-- Link to the activities list of a producer -->
	<a href="${pageContext.request.contextPath}/activities/activitiesList">
		<button type="button">Afficher la liste des activités</button>
	</a>

</body>
</html>