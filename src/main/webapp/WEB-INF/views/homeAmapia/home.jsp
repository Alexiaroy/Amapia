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
	href="${pageContext.request.contextPath}/resources/css/globalstyles.css">
<link href="${pageContext.request.contextPath}/resources/css/amapia.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/amapiaformstyles.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/amapiabuttons.css"
	rel="stylesheet">


<title>Amapia</title>
</head>

<body>
	<header>
		<jsp:include page="/WEB-INF/views/homeAmapia/templates/header.jsp" />
	</header>

	<!-- ---------------------------------- -->
	<!--             LANDING                -->
	<!------------------------------------- -->

	<section id="landing">
		<div class="container-fluid amapia-landing">
			<div class="row align-items-center">
				<div class="col-md-6 amapia-text">
					<h1>Gérez votre AMAP En toute simplicité</h1>
					<p class="amapia-p">AMAPIA : La solution complète pour les
						Associations pour le Maintien d'une Agriculture Paysanne</p>
					<button class="btn-amapia"
						onclick="window.location.href='<c:url value="/amap/signup"/>'">Commencer</button>

				</div>
				<div class="col-md-6">
					<img src="<c:url value='/resources/images/devices-img.svg'/>"
						alt="image avec un ordinateur, une tablette et un téléphone"
						class="devices-img">
				</div>
			</div>
		</div>
	</section>

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

	<!-- ---------------------------------- -->
	<!--        ACCORDION FEATURES          -->
	<!------------------------------------- -->
	<section id="features">
		<div class="amapia-features">
			<h1 class="mb-3">Découvrez nos<br>fonctionnalités</h1>

			<div class="accordion" id="accordion-features">
				<div class="card">
					<div class="card-header" id="headingOne">
						<h5 class="mb-0">
							<button class="btn btn-link" type="button" data-toggle="collapse"
								data-target="#collapseOne" aria-expanded="true"
								aria-controls="collapseOne">Une gestion simplifiée</button>
						</h5>
					</div>

					<div id="collapseOne" class="collapse show"
						aria-labelledby="headingOne" data-parent="#accordion-features">
						<div class="card-body">Des outils adaptés pour visualiser et
							analyser vos données de manière claire et efficace, vous
							permettant de suivre vos performances et d’atteindre vos
							objectifs plus facilement.</div>
						<img src="<c:url value='/resources/images/home-amapia-image1.PNG'/>">
					</div>
				</div>

				<div class="card">
					<div class="card-header" id="headingTwo">
						<h5 class="mb-0">
							<button class="btn btn-link collapsed" type="button"
								data-toggle="collapse" data-target="#collapseTwo"
								aria-expanded="false" aria-controls="collapseTwo">Personnalisation de votre amap</button>
						</h5>
					</div>
					<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
						data-parent="#accordion-features">
						<div class="card-body">Un système simplifié pour créer un site web de votre amap à votre image.
						Offrant une vue d'ensemble claire de l'état d'avancement de votre personnalisation ainsi que la possibilité de voir votre site à tout moment.</div>
						<img src="<c:url value='/resources/images/home-amapia-image2.PNG'/>">
					</div>
				</div>
				<div class="card">
					<div class="card-header" id="headingThree">
						<h5 class="mb-0">
							<button class="btn btn-link collapsed" type="button"
								data-toggle="collapse" data-target="#collapseThree"
								aria-expanded="false" aria-controls="collapseThree">
								Un site clair et intuitif</button>
						</h5>
					</div>
					<div id="collapseThree" class="collapse"
						aria-labelledby="headingThree" data-parent="#accordion-features">
						<div class="card-body">Créez une interface claire et intuitive pour vos adhérents. 
						Ils pourront naviguer à travers les différentes pages que vous aurez personnalisé afin d'en apprendre plus sur votre amap.</div>
						<img src="<c:url value='/resources/images/home-amapia-image3.PNG'/>">

					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ---------------------------------- -->
	<!--           SUBSCRIPTIONS            -->
	<!------------------------------------- -->

	<section id="subscriptions">
		<div class="amapia-subscriptions">
			<h1 class="mb-3">Nos Forfaits</h1>

			<div id="step1" style="display: block;">
				<input type="hidden" name="subscriptionName" value="Basique" /> <input
					type="hidden" name="subscriptionPrice" value="20" />

				<div class="cards bg-color-linear">
					<div class="card">
						<label class="label-title-sub color-id-1"> Basic </label>
						<div>
							<div class="ribbon">
								<p class="price">19.99€</p>
								<img id="ribbon-img" alt="ribbon"
									src="<c:url value='/resources/images/ribbon-1.svg'/>" />
							</div>
						</div>
						<div class="list-items">
							<p>✓ Vente de paniers maraîchers</p>
							<p>✓ Espace Producteur</p>
							<p>✓ Espace Administrateur AMAP</p>
						</div>
					</div>

					<div class="card">
						<label class="label-title-sub color-id-2"> Standard </label>
						<div>
							<div class="ribbon">
								<p class="price">29.99€</p>
								<img id="ribbon-img" alt="ribbon"
									src="<c:url value='/resources/images/ribbon-2.svg'/>" />
							</div>
						</div>
						<div class="list-items">
							<p>✓ Vente de paniers maraîchers</p>
							<p>✓ Vente de produits non maraîchers</p>
							<p>✓ Suivi de commande</p>
							<p>✓ Espace Acheteur</p>
							<p>✓ Espace Producteur</p>
							<p>✓ Espace Administrateur AMAP</p>
						</div>
					</div>

					<div class="card">
						<label class="label-title-sub color-id-3"> Premium </label>
						<div>
							<div class="ribbon">
								<p class="price">39.99€</p>
								<img id="ribbon-img" alt="ribbon"
									src="<c:url value='/resources/images/ribbon-3.svg'/>" />
							</div>
						</div>
						<div class="list-items">
							<p>✓ Vente de paniers maraîchers</p>
							<p>✓ Vente de produits non maraîchers</p>
							<p>✓ Inscription aux ateliers</p>
							<p>✓ Suivi de commande</p>
							<p>✓ Espace Acheteur</p>
							<p>✓ Espace Producteur</p>
							<p>✓ Espace Administrateur AMAP</p>
							<p>✓ Plage personnalisable supplémentaire</p>
							<p>✓ Absence du tampon Amapia</p>
						</div>
					</div>
				</div>

				<div class="carousel-mobile bg-color-linear px-0">
					<div id="carouselExampleIndicators" class="carousel slide px-0"
						data-ride="carousel">
						
						<div>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<div class="card mx-auto" style="max-width: 300px;">
										<label class="label-title-sub color-id-1"> Basic </label>
										<div>
											<div class="ribbon">
												<p class="price">19.99€</p>
												<img id="ribbon-img" alt="ribbon"
													src="<c:url value='/resources/images/ribbon-1.svg'/>" />
											</div>
										</div>
										<div class="list-items mt-100">
											<p>✓ Vente de paniers maraîchers</p>
											<p>✓ Espace Producteur</p>
											<p>✓ Espace Administrateur AMAP</p>
										</div>
									</div>
								</div>

								<div class="carousel-item">
									<div class="card mx-auto" style="max-width: 300px;">
										<label class="label-title-sub color-id-2"> Standard </label>
										<div>
											<div class="ribbon">
												<p class="price">29.99€</p>
												<img id="ribbon-img" alt="ribbon"
													src="<c:url value='/resources/images/ribbon-2.svg'/>" />
											</div>
										</div>
										<div class="list-items">
											<p>✓ Vente de paniers maraîchers</p>
											<p>✓ Vente de produits non maraîchers</p>
											<p>✓ Suivi de commande</p>
											<p>✓ Espace Acheteur</p>
											<p>✓ Espace Producteur</p>
											<p>✓ Espace Administrateur AMAP</p>
										</div>
									</div>
								</div>

								<div class="carousel-item">
									<div class="card mx-auto" style="max-width: 300px;">
										<label class="label-title-sub color-id-3"> Premium </label>
										<div>
											<div class="ribbon">
												<p class="price">39.99€</p>
												<img id="ribbon-img" alt="ribbon"
													src="<c:url value='/resources/images/ribbon-3.svg'/>" />
											</div>
										</div>
										<div class="list-items">
											<p>✓ Vente de paniers maraîchers</p>
											<p>✓ Vente de produits non maraîchers</p>
											<p>✓ Inscription aux ateliers</p>
											<p>✓ Suivi de commande</p>
											<p>✓ Espace Acheteur</p>
											<p>✓ Espace Producteur</p>
											<p>✓ Espace Administrateur AMAP</p>
											<p>✓ Plage personnalisable supplémentaire</p>
											<p>✓ Absence du tampon Amapia</p>
										</div>
									</div>
								</div>
							</div>
							<a class="carousel-control-prev"
								href="#carouselExampleIndicators" role="button"
								data-slide="prev"> <span class="carousel-control-prev-icon"
								aria-hidden="true"></span> <span class="sr-only">Previous</span>
							</a> <a class="carousel-control-next"
								href="#carouselExampleIndicators" role="button"
								data-slide="next"> <span class="carousel-control-next-icon"
								aria-hidden="true"></span> <span class="sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- ---------------------------------- -->
	<!--             CONTACT                -->
	<!------------------------------------- -->
	<section id="contact">
		<div class="amapia-features">
			<h1 class="mb-3">Contact</h1>
		
		</div>
		<div class="container d-flex align-items-center min-vh-100 p-1 p-md-5">
			<div class="contact-wrapper row w-100">
				<!-- Content for desktop view -->
				<div
					class="col-lg-6 d-none d-lg-flex flex-column justify-content-center align-items-start contact-sidebar">
					<h2>Discutons ensemble de vos projets</h2>

					<div class="contact-info">
						<img src="<c:url value='/resources/images/email-icon.svg'/>"
							class="contact-icon" alt="icône de courrier électronique">
						<p>contact.amapia@gmail.com</p>
					</div>

					<div class="contact-info">
						<img src="<c:url value='/resources/images/location-icon.svg'/>"
							class="contact-icon" alt="icône de localisation sur la carte">
						<p>18 Avenue des Ternes 75017 Paris, France</p>
					</div>
					<div class="contact-info">
						<img src="<c:url value='/resources/images/phone-icon.svg'/>"
							class="contact-icon" alt="icône de téléphone">
						<p>+33 01 15 46 23 78</p>
					</div>
				</div>


				<!-- Contact Form -->
				<div class="col-12 col-lg-6">
						
					<div class="amapia-contact">
						<h2 class="text-left">Nous contacter </h2>
						<form class="contact-form" action="home" method="post">
						<button type="button" id="fill-message"
			class="btn btn-light btn-sm ml-3">B</button>
							<div class="form-group">
								<label for="nom">Votre nom</label> <input type="text"
									class="form-control" id="nom" placeholder="Entrez votre nom"
									required>
							</div>
							<div class="form-group">
								<label for="prenom">Votre prénom</label> <input type="text"
									class="form-control" id="prenom"
									placeholder="Entrez votre prénom" required>
							</div>
							<div class="form-group">
								<label for="email">Votre email</label> <input type="email"
									class="form-control" id="email"
									placeholder="Entrez votre email" required name="email">
							</div>
							<div class="form-group">
								<label for="message">Votre message</label>
								<textarea class="form-control" id="message" rows="4"
									placeholder="Écrivez votre message" name="message"
									style="resize: none;" required></textarea>
							</div>
							<button type="submit" class="btn-amapia">
								<img src="<c:url value='/resources/images/send-icon.svg'/>"
									class="send-icon send-button" alt="Send icon"> Envoyer
							</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="/WEB-INF/views/homeAmapia/templates/footer.jsp" />

	<!-- ---------------------------------- -->
	<!--             SCRIPTS                -->
	<!------------------------------------- -->


	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>

	<script>
	document.addEventListener("DOMContentLoaded", function() {
	    const burgerButton = document.querySelector(".navbar-toggler");
	    const normalLogo = document.getElementById("normal-logo");
	    const burgerLogo = document.getElementById("burger-logo");
	    const navbarMenu = document.getElementById("navbarNav");

	    burgerButton.addEventListener("click", function() {
	        // Vérifie si le menu est déjà ouvert
	        if (navbarMenu.classList.contains("show")) {
	            // Ferme le menu
	            navbarMenu.classList.remove("show");
	            burgerButton.setAttribute("aria-expanded", "false");
	            normalLogo.classList.remove("d-none");
	            burgerLogo.classList.add("d-none");
	        } else {
	            // Ouvre le menu
	            navbarMenu.classList.add("show");
	            burgerButton.setAttribute("aria-expanded", "true");
	            normalLogo.classList.add("d-none");
	            burgerLogo.classList.remove("d-none");
	        }
	    });

	    // Fermeture du menu si l'on clique en dehors
	    document.addEventListener("click", function (e) {
	        if (!navbarMenu.contains(e.target) && !burgerButton.contains(e.target)) {
	            if (navbarMenu.classList.contains("show")) {
	                navbarMenu.classList.remove("show");
	                burgerButton.setAttribute("aria-expanded", "false");
	                normalLogo.classList.remove("d-none");
	                burgerLogo.classList.add("d-none");
	            }
	        }
	    });

	    document.getElementById('fill-message').addEventListener('click', function() {
	        document.getElementById('nom').value = 'Muller';
	        document.getElementById('prenom').value = 'Lisa';
	        document.getElementById('email').value = 'lisa-muller@gmail.com';
	        document.getElementById('message').value = 'Bonjour, Je suis utilisateur d’Amapia et j’aimerais en savoir plus sur votre plateforme. Votre solution m’intéresse beaucoup, et je souhaite connaître vos projets pour l’avenir. Prévoyez-vous des mises à jour ou de nouvelles fonctionnalités prochainement ? Merci d’avance.';
	    });
	});

	</script>
</body>

</html>