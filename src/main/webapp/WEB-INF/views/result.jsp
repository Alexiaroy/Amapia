<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns='http://www.w3.org/1999/xhtml'
	xmlns:th='http://www.thymeleaf.org'>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Paiement</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/signup.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<style>
._success {
	box-shadow: 0 15px 25px #00000019;
	padding: 45px;
	text-align: center;
	margin: 40px auto;
	border-bottom: solid 4px #28a745;
}

._success i {
	font-size: 55px;
	color: #28a745;
}

._success h2 {
	margin-bottom: 12px;
	font-size: 40px;
	font-weight: 500;
	line-height: 1.2;
	margin-top: 10px;
}

._success p {
	margin-bottom: 0px;
	font-size: 18px;
	color: #495057;
	font-weight: 500;
}
</style>
<body>
	<h3 th:if='${error}' th:text='${error}' style='color: red;'></h3>
	<div th:unless='${error}'>
		<h3 style='color: green;'>Paiement validé !</h3>
	</div>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-5">
				<div class="message-box _success">
					<i class="fa fa-check-circle" aria-hidden="true"></i>
					<h2>Votre paiement a bien été pris en compte</h2>
					<p>Merci pour votre paiement. Vous pouvez désormais vous
						connecter à votre espace amap et personnaliser vos différentes
						sections.</p>
				</div>
			</div>
		</div>

		<div class="button-container">
			<a class="button-previous" style="text-decoration: none"
				href="${pageContext.request.contextPath}/home">Menu principal</a> <a
				class="btn-next" style="text-decoration: none"
				href="${pageContext.request.contextPath}/amap/login">Connexion</a>
		</div>
	</div>
</body>
</html>