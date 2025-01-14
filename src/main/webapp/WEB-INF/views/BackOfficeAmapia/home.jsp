<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/amapbackofficestyles.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/amaplayoutstyles.css">
<link href="<c:url value="/resources/css/AmapiaBONavBar.css"/>"
	rel="stylesheet">

<title>Back Office Amapia</title>
</head>
<style>
.container {
	margin-left: 100px;
}

.data-container {
	background-color: white;
	border-radius: 20px;
	width: 250px;
	height: 150px;
	box-shadow: inset 0 4px 10px rgba(0, 0, 0, 0.3);
}

.data {
	font-weight: 500;
	font-size: 50px;
	color: #99BC85;
}

.content-graphs {
	background-color: white;
	border-radius: 20px;
	width: 350px;
	height: 200px;
	padding: 10px;
}

@media ( max-width : 768px) {
	.container {
		margin-left: 20px;
	}
	.content-graphs {
		width: 270px;
		height: 200px;
	}
}
</style>
<body>
	<div
		class="container d-flex flex-column align-items-center justify-content-center">
		<h2 style="margin-bottom: 70px;">Vue d'Ensemble</h2>
		<div class="d-flex flex-wrap" style="gap: 10px;">
			<div class="data-container">
				<p class="data">${total}€</p>
				<p>Revenu mensuel</p>
			</div>
			<div class="data-container">
				<p class="data">${totalmessage}</p>
				<p>Messages Non lus</p>
			</div>
			<div class="data-container">
				<p class="data">${totalamap}</p>
				<p>Amaps Inscrites</p>
			</div>
		</div>
		<div class="d-flex flex-wrap justify-content-between"
			style="gap: 15px; margin-top: 50px; margin-left: 20px;">
			<div
				class="content-graphs d-flex flex-column align-items-center justify-content-center">
				<p class="data">${newamap}</p>
				<p>Nouvelles amaps ces 30 derniers jours</p>

			</div>
			<div class="content-graphs">
				<canvas id="datamonth" style="width: 700px; margin-top: 20px;"></canvas>
			</div>
			<div class="content-graphs">
				<canvas id="datadought" style="width: 700px"></canvas>
			</div>
		</div>
	</div>


	<div>
		<div>
			<jsp:include
				page="/WEB-INF/views/BackOfficeAmapia/templates/headerBO.jsp" />
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
	<script> 
var xValues = ["Basic", "Standard", "Premium" ];
var yValues = [${Basique}, ${Normal}, ${Premium}];
var barColors = [
  "#b91d47",
  "#00aba9",
  "#2b5797"
];

new Chart("datadought", {
  type: "doughnut",
  data: {
    labels: xValues,
    datasets: [{
      backgroundColor: barColors,
      data: yValues
    }]
  },
  options: {
    title: {
      display: true,
      text: "Répartition des abonnements"
    }
  }
});

</script>
	<script>
const x1Values = ["aout", "septembre", "octobre", "novembre", "décembre","janvier","février"];
const y1Values = [${aug}, ${sep}, ${oct}, ${nov}, ${dec},${jan}, ${fev}];

new Chart("datamonth", {
  type: "line",
  data: {
    labels: x1Values,
    
    datasets: [{
      fill: false,
      lineTension: 0,
      backgroundColor: "rgba(0,0,255,1.0)",
      borderColor: "rgba(0,0,255,0.1)",
      data: y1Values
    }]
  },
  options: {
    legend: {display: false},
    scales: {
      yAxes: [{ticks: {min: 0, max:10}}],
    }
  }
});

</script>
</body>
</html>