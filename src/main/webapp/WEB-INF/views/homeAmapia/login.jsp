<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Connexion</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/loginstyles.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/globalstyles.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/amapia.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/amapiaformstyles.css"/>"
	rel="stylesheet">
</head>
<body>

	<header><jsp:include
			page="/WEB-INF/views/homeAmapia/templates/header.jsp" /></header>

	<!-- ---------------------------------- -->
	<!--         INFINITE LOGO              -->
	<!------------------------------------- -->

	<div class="wrapper">
		<img src="<c:url value='/resources/images/logo-white.svg'/>"
			class="logo-item item1" alt="Logo Amapia"> <img
			src="<c:url value='/resources/images/logo-white.svg'/>"
			class="logo-item item2" alt="Logo Amapia"> <img
			src="<c:url value='/resources/images/logo-white.svg'/>"
			class="logo-item item3" alt="Logo Amapia"> <img
			src="<c:url value='/resources/images/logo-white.svg'/>"
			class="logo-item item4" alt="Logo Amapia"> <img
			src="<c:url value='/resources/images/logo-white.svg'/>"
			class="logo-item item5" alt="Logo Amapia"> <img
			src="<c:url value='/resources/images/logo-white.svg'/>"
			class="logo-item item6" alt="Logo Amapia">
	</div>



	<div class="container mt-5 d-flex justify-content-center">
		<div class="login-box col-10 col-md-6">

			<h2 class="text-center connection">Connexion</h2>
			<hr />
			<form action="${pageContext.request.contextPath}/amap/login"
				method="post" class="mt-4">
				<div class="form-group">
					<label for="email">Adresse Email</label> <input type="email"
						name="email" id="email" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="password">Mot de passe</label> <input type="password"
						name="password" id="password" class="form-control" required>
				</div>

				<div class="button-container">
					<button class="btn-next" type="submit">Connexion</button>
				</div>
				<c:if test="${not empty error}">
					<div class="alert alert-danger mt-3">${error}</div>
				</c:if>
			</form>
			<hr />
			<p class="text-center">
				Pas encore inscrit ? <br> <a href="/AmapiaApp/amap/signup">Devenez
					membre !</a>
			</p>

		</div>
	</div>

	<jsp:include page="/WEB-INF/views/homeAmapia/templates/footer.jsp" />


	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
</body>
</html>

