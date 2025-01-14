<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/amapbackofficestyles.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/amaplayoutstyles.css">
<link href="<c:url value='/resources/css/AmapiaBONavBar.css'/>"
	rel="stylesheet">
<title>Support Client</title>

<style>
.table-container {
	width: 100%;
	overflow-x: auto;
	margin-left: 190px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

table th, table td {
	text-align: left;
	padding: 10px;
	border: 1px solid #ddd;
	background-color: white;
}

.cards {
	display: none;
}

@media ( max-width : 768px) {
	table {
		display: none;
	}
	.cards {
		display: flex;
		flex-direction: column;
		margin-left: 40px;
		gap: 15px;
	}
	.card {
		border: 1px solid #ddd;
		border-radius: 8px;
		box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
		background-color: #fff;
	}
	.card-header {
		display: flex;
		flex-direction: column;
		margin-bottom: 10px;
	}
	.card-header h5 {
		margin: 0;
		font-size: 16px;
		font-weight: bold;
	}
	.card-header small {
		margin-top: 5px;
		font-size: 12px;
		color: gray;
	}
	.card-body {
		font-size: 14px;
	}
}
</style>
</head>
<body>

	<div
		class="container d-flex flex-column align-items-center justify-content-center">
		<h2 class="text-center mb-5">Support Client</h2>

		<!-- Desktop -->
		<div class="table-container">
			<table class="table">
				<thead>
					<tr>
						<th>Email</th>
						<th>Message</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="support" items="${supports}">
						<tr>
							<td>${support.email}</td>
							<td>${support.message}</td>
							<td>${support.date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- Mobile -->
		<div class="cards">
			<c:forEach var="support" items="${supports}">
				<div class="card">
					<div class="card-header">
						<h5>${support.email}</h5>
						<small>${support.date}</small>
					</div>
					<div class="card-body">
						<p>${support.message}</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<jsp:include
		page="/WEB-INF/views/BackOfficeAmapia/templates/headerBO.jsp" />

</body>
</html>

