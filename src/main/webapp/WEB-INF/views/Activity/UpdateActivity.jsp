<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification d'une activité</title>

<!-- Adding script and CSS file import for the datePicker  -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>
	<h1>Modifier une activité</h1>

	<!-- Don't forget to add the enctype -->
	<form enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/activities/updateActivity"
		method="post" accept-charset="UTF-8">

		<p>Producer ID reçu : ${activity.producer.producer_id}</p>
		<p>Activity ID reçu : ${activity.activity_id}</p>

		<input type="hidden" name="producer_id"
			value="${activity.producer.producer_id}"> <input
			type="hidden" name="activity_id" value="${activity.activity_id}">

		<div>
			<label for="activityName">Intitulé de l'activité : </label> <input
				type="text" id="activityName" name="activityName"
				value="${activity.activityName}" required>
		</div>
		<br>
		<div>
			<label for="startTime">Heure de début : </label> <input type="time"
				id="startTime" name="startTime" value="${activity.startTime}"
				required>
		</div>
		<br>
		<div>
			<label for="endTime">Heure de fin : </label> <input type="time"
				id="endTime" name="endTime" value="${activity.endTime}" required>
		</div>
		<br>
		<div>
			<label for="location">Lieu : </label> <input type="text"
				id="location" name="location" value="${activity.location}" required>
		</div>
		<br>
		<!-- Display current image if it exists -->
		<div>
			<label>Image actuelle :</label><br> <img
				src="${pageContext.request.contextPath}/activities/activityImage/${activity.activity_id}"
				alt="Current Image" style="max-width: 300px; max-height: 200px;" />
		</div>
		<!-- Upload a new image -->
		<div>
			<label for="imageFile">Nouvelle image (optionnel): </label> <input
				type="file" id="imageFile" name="imageFile" accept=".jpg,.jpeg,.png" />
		</div>
		<!-- // -->
		<br>
		<div>
			<label for="activityDescription">Description : </label> <input
				type="text" id="activityDescription" name="activityDescription"
				value="${activity.activityDescription}" required>
		</div>
		<br>
		<div>
			<label for="dateTime">Date de l'événement : </label> <input
				type="text" id="datepicker" name="dateTime"
				value="${activity.dateTime}" required>
			<!-- changed the date type to text for the compatibility with the datePicker script (date type isn't compatible)  -->
		</div>
		<br>
		<div>
			<label for="availableSpots">Nombre de places disponibles : </label> <input
				type="number" id="availableSpots" name="availableSpots"
				value="${activity.availableSpots}" required>
		</div>
		<br>
		<div>
			<label for="price">Prix(€)/personne :</label> <input type="number"
				step="0.01" id="price" name="price" value="${activity.price}" placeholder="10.5"
				required>
		</div>
		<br>
		<div>

			<button type="submit">Enregistrer les modifications</button>
		</div>
	</form>

	<!-- jQuery UI script to set the datePicker and timePicker -->
	<script>
		$(function() {
			//DatePicker initialization using the id "datepicker"
			$("#datepicker").datepicker({
				dateFormat : "yy-mm-dd", // Set the date format to year-month-day
				minDate : new Date(2025, 0, 1), // Minimum selectable date: 01-01-2025 (0 is the starting point indexation for the month list January = index(0))
				maxDate : new Date(2025, 11, 31), // Maximum selectable date: 31-12-2025
				showButtonPanel : true, // Show extra buttons like "Today" and "Close"
				changeMonth : true, // Allow user to select a different month
				changeYear : true
			// Allow user to select a different year
			});

		});
	</script>

</body>
</html>