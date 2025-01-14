<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <script src="https://js.stripe.com/v3/"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> 
    <script> 
    $(function(){
      $("#paymentform").load("checkout.jsp"); 
    });
    </script> 
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Inscription Amap</title>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
	<link href="<c:url value="/resources/css/globalstyles.css"/>"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/signup.css">
		<link href="<c:url value="/resources/css/loginstyles.css"/>"
	rel="stylesheet">
	<link href="checkout.html" rel="import">
	
</head>
<style>
.bg-color-linear {
	background-image:
		url('${pageContext.request.contextPath}/resources/images/bg-cards.svg');
}
</style>
<body>

<!-- HEADER -->
<header><jsp:include
			page="/WEB-INF/views/homeAmapia/templates/header.jsp" /></header>

	<div class="signup-page">

		<h2 class="mb-5">Inscription</h2>

		<ul class="nav">
			<li class="nav-item"><a
				class="nav-link ${step == 1 ? 'active color-green' : ''} ${step != 1 ? 'disabled' : ''}"
				href="#">Étape 1</a></li>
			<li class="nav-item"><a
				class="nav-link ${step == 2 ? 'active color-green' : ''} ${step != 2 ? 'disabled' : ''}"
				href="#">Étape 2</a></li>
			<li class="nav-item"><a
				class="nav-link ${step == 3 ? 'active color-green' : ''} ${step != 3 ? 'disabled' : ''}"
				href="#">Étape 3</a></li>
		</ul>

		<form action="${pageContext.request.contextPath}/amap/signup"
			method="post">
			<input type="hidden" name="step" value="${step}" />



			<!-- STEP ONE -->
			<div id="step1" style="display: ${step == 1 ? 'block' : 'none'};">
				<input type="hidden" name="subscriptionName"
					value="${subscriptionName}" /> <input type="hidden"
					name="subscriptionPrice" value="${subscriptionPrice}" />

				<h3 class="my-5">Étape 1 : Sélectionnez un forfait</h3>
				<div class="cards bg-color-linear">
					<c:forEach var="subscription" items="${subscriptions}">
						<c:if
							test="${subscription.id == 1 || subscription.id == 2 || subscription.id == 3}">
							<div class="card">
								<label class="label-title-sub color-id-${subscription.id}">
									<input type="radio" name="subscriptionId"
									value="${subscription.id}" /> ${subscription.subscriptionName}
								</label>
								<div>
									<div class="ribbon">
										<p class="price">${subscription.price}€</p>
										<img id="ribbon-img" alt="ribbon"
											src="${pageContext.request.contextPath}/resources/images/ribbon-${subscription.id}.svg" />
									</div>


								</div>
								<div class="list-items">
									<c:choose>
										<c:when test="${subscription.id == 1}">
											<p>✓ Vente de paniers maraîchers</p>
											<p>✓ Espace Producteur</p>
											<p>✓ Espace Administrateur AMAP</p>
										</c:when>
										<c:when test="${subscription.id == 2}">
											<p>✓ Vente de paniers maraîchers</p>
											<p>✓ Vente de produits non maraîchers</p>
											<p>✓ Suivi de commande</p>
											<p>✓ Espace Acheteur</p>
											<p>✓ Espace Producteur</p>
											<p>✓ Espace Administrateur AMAP</p>
										</c:when>
										<c:when test="${subscription.id == 3}">
											<p>✓ Vente de paniers maraîchers</p>
											<p>✓ Vente de produits non maraîchers</p>
											<p>✓ Inscription aux ateliers</p>
											<p>✓ Suivi de commande</p>
											<p>✓ Espace Acheteur</p>
											<p>✓ Espace Producteur</p>
											<p>✓ Espace Administrateur AMAP</p>
											<p>✓ Plage personnalisable supplémentaire</p>
											<p>✓ Absence du tampon Amapia</p>
										</c:when>
										<c:otherwise>
											<p>Aucun élément disponible</p>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>

				<div class="carousel-mobile bg-color-linear px-0">
					<div id="carouselExampleIndicators" class="carousel slide px-0"
						data-ride="carousel">

						<div>
							<div class="carousel-inner">
								<c:forEach var="subscription" items="${subscriptions}"
									varStatus="status">
									<c:if
										test="${subscription.id == 1 || subscription.id == 2 || subscription.id == 3}">
										<div class="carousel-item ${status.first ? 'active' : ''}">
											<div class="card mx-auto" style="max-width: 300px;">
												<label class="label-title-sub color-id-${subscription.id}">
													<input type="radio" name="subscriptionId"
													value="${subscription.id}" />
													${subscription.subscriptionName}
												</label>
												<div>
													<div class="ribbon">
														<p class="price">${subscription.price}€</p>
														<img id="ribbon-img" alt="ribbon"
															src="${pageContext.request.contextPath}/resources/images/ribbon-${subscription.id}.svg" />
													</div>
												</div>

												<div class="list-items">
													<c:choose>
														<c:when test="${subscription.id == 1}">
															<p>✓ Vente de paniers maraîchers</p>
															<p>✓ Espace Producteur</p>
															<p>✓ Espace Administrateur AMAP</p>
														</c:when>
														<c:when test="${subscription.id == 2}">
															<p>✓ Vente de paniers maraîchers</p>
															<p>✓ Vente de produits non maraîchers</p>
															<p>✓ Suivi de commande</p>
															<p>✓ Espace Acheteur</p>
															<p>✓ Espace Producteur</p>
															<p>✓ Espace Administrateur AMAP</p>
														</c:when>
														<c:when test="${subscription.id == 3}">
															<p>✓ Vente de paniers maraîchers</p>
															<p>✓ Vente de produits non maraîchers</p>
															<p>✓ Inscription aux ateliers</p>
															<p>✓ Suivi de commande</p>
															<p>✓ Espace Acheteur</p>
															<p>✓ Espace Producteur</p>
															<p>✓ Espace Administrateur AMAP</p>
															<p>✓ Plage personnalisable supplémentaire</p>
															<p>✓ Absence du tampon Amapia</p>
														</c:when>
														<c:otherwise>
															<p>Aucun élément disponible</p>
														</c:otherwise>
													</c:choose>
												</div>
											</div>
										</div>
									</c:if>
								</c:forEach>
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

				<div class="button-container">
					<button class="btn-next mb-5" type="submit">Continuer</button>
				</div>

			</div>

			<!-- STEP 2 -->


			<div id="step2" style="display: ${step == 2 ? 'block' : 'none'};">
				<h3 class="my-5">Étape 2 : Vos informations <button type="button" id="fill-info-button" class="btn btn-primary btn-sm">B</button></h3>
				    
				
				<div class="form-signup col-12 col-md-9 m-auto">
					<div class="form-group-signup">
						<label>Nom de l'amap <br /> <input class="input-signup"
							type="text" name="name" id="name" value="${amap.name}" /></label> <label>Adresse<br />
							<input id="address" class="input-signup" type="text" name="address"
							value="${amap.address}" /></label>
					</div>

					<div class="form-group-signup">
						<label>Nom du responsable<br /> <input
							class="input-signup" id="contactName" type="text" name="contactName"
							value="${amap.contactName}" /></label> <label>Prénom du
							responsable<br /> <input id="contactFirstname" class="input-signup" type="text"
							name="contactFirstname" value="${amap.contactFirstname}" />
						</label>
					</div>

					<div class="form-group-signup">
						<label>SIRET<br /> <input class="input-signup" id="amapSiret"
							type="text" name="amapSiret" value="${amap.amapSiret}" /></label> <label>Téléphone<br />
							<input class="input-signup" type="text" name="contactPhoneNum" id="contactPhoneNum"
							value="${amap.contactPhoneNum}" /></label>
					</div>
					<div class="form-group-signup">
						<label>Email <br>
						<input class="input-signup" type="email" name="email" id="email"
							value="${amap.email}" /></label> <label> Mot de passe <br>
						<c:choose>
								<c:when
									test="${amap.password != null && !amap.password.isEmpty()}">
									<input type="hidden" name="password" value="${amap.password}" />
									<span>(déjà défini)</span>
								</c:when>
								<c:otherwise>
									<input class="input-signup" type="password" name="password" />
								</c:otherwise>
							</c:choose>
						</label>
					</div>
				</div>


				<div class="button-container">
					<button type="button" class="button-previous" id="btn-step1">Retour</button>
					<button class="btn-next" type="submit">Suivant</button>

				</div>
			</div>


			<!-- STEP 3  -->


			<div id="step3" style="display: ${step == 3 ? 'block' : 'none'};">
				<h3 class="my-5">Étape 3 : Paiement</h3>

				<!-- Payment page  -->
				<jsp:include page="/WEB-INF/views/checkout.jsp" />

				<input type="hidden" name="subscriptionId" value="${subscriptionId}" />

			</div>
		</form>
	</div>

	<!-- 	FOOTER -->
	<jsp:include page="/WEB-INF/views/homeAmapia/templates/footer.jsp" />
	

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
	});
	
	function navigateToStep(step) {
        document.getElementById('step1').style.display = step === 1 ? 'block' : 'none';
        document.getElementById('step2').style.display = step === 2 ? 'block' : 'none';
        document.getElementById('step3').style.display = step === 3 ? 'block' : 'none';

        // Mettre à jour les classes des étapes dans la barre de navigation
        const navLinks = document.querySelectorAll('.nav-link');
        navLinks.forEach((link, index) => {
            if (index + 1 === step) {
                link.classList.add('active');
                link.classList.remove('disabled');
            } else {
                link.classList.remove('active');
                link.classList.add('disabled');
            }
        });

        // Mettre à jour la valeur de l'étape actuelle dans le formulaire
        document.querySelector('input[name="step"]').value = step;
    }

    document.addEventListener("DOMContentLoaded", function () {

        
        let step = ${step != null ? step : 1};

        const step2Form = document.getElementById('form-step-2');
        const step3Form = document.getElementById('form-step-3');
        const subscriptionCards = document.querySelector('.subscription-cards');
        const step1Nav = document.querySelector('.nav-item:nth-child(1) .nav-link');
        const step2Nav = document.querySelector('.nav-item:nth-child(2) .nav-link');
        const step3Nav = document.querySelector('.nav-item:nth-child(3) .nav-link');
        const buttons = document.querySelectorAll('.subscribe-btn');
        const hiddenInput = document.getElementById('subscriptionId');

        document.getElementById("btn-step1").addEventListener("click", function () {
            navigateToStep(1);
        });

        document.getElementById("btn-step2").addEventListener("click", function () {
            navigateToStep(2);
        });

        document.querySelectorAll('.subscribe-btn').forEach(button => {
            button.addEventListener('click', function () {
                const subscriptionId = this.getAttribute('data-subscription-id');
                const subscriptionName = this.parentNode.querySelector('h4').textContent;

                document.getElementById('subscriptionId').value = subscriptionId;
                document.getElementById('subscriptionName').value = subscriptionName;

                document.querySelector('.subscription-cards').style.display = 'none';
                document.getElementById('form-step-2').style.display = 'block';
            });
        });
                

        buttons.forEach(button => {
            button.addEventListener('click', function () {
                const subscriptionId = this.getAttribute('data-subscription-id');
                
                hiddenInput.value = subscriptionId; 
                subscriptionCards.style.display = 'none';
                step2Form.style.display = 'block';
                updateNavSteps(2);
            });
        });

        document.getElementById('next-step').addEventListener('click', function () {
            step2Form.style.display = 'none';
            step3Form.style.display = 'block';
            updateNavSteps(3);
        });

        
        function updateNavSteps(currentStep) {
            if (currentStep === 2) {
                step1Nav.classList.remove('active');
                step1Nav.classList.add('disabled');
                step2Nav.classList.remove('disabled');
                step2Nav.classList.add('active');
            } else if (currentStep === 3) {
                step2Nav.classList.remove('active');
                step2Nav.classList.add('disabled');
                step3Nav.classList.remove('disabled');
                step3Nav.classList.add('active');
            }
        }
    });

    document.getElementById('fill-info-button').addEventListener('click', function() {
        document.getElementById('name').value = 'Stratamap';
        document.getElementById('address').value = '15 rue de Paris, 77174 Villeneuve-le-Comte';
        document.getElementById('contactName').value = 'Muller';
        document.getElementById('contactFirstname').value = 'Lisa';
        document.getElementById('amapSiret').value = '45678123456777';
        document.getElementById('contactPhoneNum').value = '0102030405';
        document.getElementById('email').value = 'lisa-muller@gmail.com';
    });

    
    </script>
</body>
</html>

