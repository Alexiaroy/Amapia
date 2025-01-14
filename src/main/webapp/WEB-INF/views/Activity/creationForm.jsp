<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création d'activité</title>


<!-- CSS file import for the datePicker  -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>

	<h1>Création d'une activité</h1>

	<!-- Don't forget to add the enctype -->
	<form enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/activities/createActivity"
		method="post">

		<p>Producer ID reçu : ${producer.producer_id}</p>

		<input type="hidden" name="producer_id"
			value="${producer.producer_id}">

		<!-- Hidden input to set the activity status to false initially -->
		<input type="hidden" name="isActive" value="false">

		<div>
			<label for="activityName">Intitulé de l'activité : </label> <input
				type="text" id="activityName" name="activityName" required>
		</div>
		<br>
		<div>
			<label for="startTime">Heure de début : </label> <input type="time"
				id="startTime" placeholder="10:00" name="startTime" required>
		</div>
		<br>
		<div>
			<label for="endTime">Heure de fin : </label> <input type="time"
				id="endTime" placeholder="12:30" name="endTime" required>
		</div>
		<br>
		<div>
			<label for="location">Lieu : </label> <input type="text"
				id="location" name="location"
				placeholder="Entrez le lieu de l'activité" required>
		</div>
		<br>
		<!-- Handle the image -->
		<div>
			<label for="imageFile">Image de l'activité : </label> <input
				type="file" id="imageFile" name="imageFile" accept=".jpg,.jpeg,.png"
				required>
		</div>
		<!-- // -->
		<br>
		<div>
			<label for="activityDescription">Description : </label> <input
				type="text" id="activityDescription" name="activityDescription"
				required>
		</div>
		<br>
		<div>
			<label for="dateTime">Date de l'événement : </label> <input
				type="text" id="datepicker" name="dateTime" required>
			<!-- changed the date type to text for the compatibility with the datePicker script (date type isn't compatible)  -->
		</div>
		<br>
		<div>
			<label for="availableSpots">Nombre de places disponibles : </label> <input
				type="number" id="availableSpots" name="availableSpots" required>
		</div>
		<br>
		<div>
			<label for="price">Prix(€)/personne :</label> <input type="number"
				step="0.01" id="price" name="price" placeholder="10.5" required>
		</div>
		<br>
		<div>
			<button type="submit">Valider</button>
		</div>
	</form>

	<script src=https://code.jquery.com/jquery-1.12.4.js></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- jQuery UI script to set the datePicker and timePicker -->
	<script>
		$(function() {
			//DatePicker initialization using the id "datepicker"
			$("#datepicker").datepicker({
				dateFormat : "yy-mm-dd", // Set the date format to day-month-year
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

