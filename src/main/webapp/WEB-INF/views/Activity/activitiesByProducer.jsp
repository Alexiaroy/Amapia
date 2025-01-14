<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Liste des activités</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/amaptablestyles.css">
</head>
<body>
	<div>
		<a href="${pageContext.request.contextPath}/activities/createActivity">
			<button type="button">Ajouter une nouvelle activité</button>
		</a>
	</div>
	<br>
	<table>
		<thead>
			<tr>
				<th>Image</th>
				<th>Intitulé de l'activité</th>
				<th>Heure de début</th>
				<th>Durée</th>
				<th>Desription</th>
				<th>Lieu de l'activité</th>
				<th>Date</th>
				<th>Nombre de places disponibles</th>
				<th>Nombre d'inscrits</th>
				<th>Places restantes</th>
				<th>Site d'exploitation</th>
				<th> Prix(€)/personne </th>
				<th>Statut de l'activité</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="activity" items="${activities}">
				<tr>
					<td>
					<img
						src="${pageContext.request.contextPath}/activities/activityImage/${activity.activity_id}"
						alt="${activity.activityName}"
						style="max-width: 100px; max-height: 100px;" />
					</td>
					<td>${activity.activityName}</td>
					<td>${activity.startTime}</td>
					<td>${activity.formattedDuration}</td>
					<td>${activity.activityDescription}</td>
					<td>${activity.location}</td>
					<td>${activity.dateTime}</td>
					<td>${activity.availableSpots}</td>
					<td>${activity.registeredMembers}</td>
					<td>${activity.remainingSpots}</td>
					<td>${activity.producer.producerCompanyName}</td>
					<td>${activity.price}</td>
					<td><span
						class="status-circle ${activity.isActive ? 'green' : 'red'}"></span>
					</td>
					<td><a
						href="${pageContext.request.contextPath}/activities/updateActivity/${activity.producer.producer_id}/${activity.activity_id}">
							<button type="button">Modifier</button>
					</a></td>
					<td><a
						href="${pageContext.request.contextPath}/activities/deleteActivity/${activity.producer.producer_id}/${activity.activity_id}">
							<button type="button">Supprimer</button>
					</a></td>
					<td>
						<!-- If the activity is active otherwise, if the activity isn't active -->
						<c:choose>
							<c:when test="${activity.isActive}">
								<form
									action="${pageContext.request.contextPath}/activities/desactivateActivity/${activity.producer.producer_id}/${activity.activity_id}"
									method="post">
									<button type="submit">Retirer l'activité</button>
								</form>
							</c:when>
							<c:otherwise>
								<form
									action="${pageContext.request.contextPath}/activities/activateActivity/${activity.producer.producer_id}/${activity.activity_id}"
									method="post">
									<button type="submit">Proposer l'activité</button>
								</form>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>