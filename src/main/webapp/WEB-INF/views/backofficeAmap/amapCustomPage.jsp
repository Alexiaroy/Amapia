<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:formatDate value="${amap.subLastPaymentDate}"
	pattern="dd MMMM yyyy" var="formattedDate" />

<h2 class="mb-5 ml-5">Bienvenue sur le backoffice !</h2>

<!-- Partie résumé avec cards -->

<div class="container-fluid mb-5">
	<div class="container col-12 row m-auto justify-content-around">

		<div href="#" class="card m-2">
			<div class="card-body text-center">
				<c:if test="${amap.subscription.subscriptionName == 'Basic'}">
					<h2 class="card-title basic-style">${amap.subscription.subscriptionName}</h2>
				</c:if>
				<c:if test="${amap.subscription.subscriptionName == 'Standard'}">
					<h2 class="card-title standard-style">${amap.subscription.subscriptionName}</h2>
				</c:if>
				<c:if test="${amap.subscription.subscriptionName == 'Premium'}">
					<h2 class="card-title premium-style">${amap.subscription.subscriptionName}</h2>
				</c:if>

				<svg class="mb-3 mt-3 black-svg" width="119" height="119"
					viewBox="0 0 119 119" fill="none"
					xmlns="http://www.w3.org/2000/svg">
			<path
						d="M59.5 0C47.732 0 36.2283 3.48961 26.4436 10.0276C16.6589 16.5655 9.03261 25.8581 4.52919 36.7303C0.0257804 47.6025 -1.15252 59.566 1.1433 71.1079C3.43912 82.6497 9.10595 93.2516 17.4272 101.573C25.7484 109.894 36.3503 115.561 47.8921 117.857C59.434 120.153 71.3975 118.974 82.2697 114.471C93.1419 109.967 102.435 102.341 108.972 92.5564C115.51 82.7717 119 71.268 119 59.5C118.982 43.7251 112.708 28.6014 101.553 17.4468C90.3986 6.29229 75.2749 0.0178342 59.5 0ZM59.5 113.87C48.7466 113.87 38.2347 110.681 29.2936 104.707C20.3525 98.7328 13.3838 90.2413 9.26861 80.3065C5.15347 70.3717 4.07676 59.4397 6.17465 48.8929C8.27253 38.3461 13.4508 28.6583 21.0546 21.0545C28.6584 13.4507 38.3462 8.2725 48.8929 6.17462C59.4397 4.07674 70.3717 5.15345 80.3065 9.26859C90.2414 13.3837 98.7328 20.3525 104.707 29.2936C110.681 38.2347 113.87 48.7466 113.87 59.5C113.854 73.9148 108.12 87.7344 97.9272 97.9272C87.7344 108.12 73.9148 113.854 59.5 113.87Z" />
			<path
						d="M62.0655 58.438V36.7373C62.0655 36.0571 61.7952 35.4046 61.3142 34.9236C60.8332 34.4426 60.1808 34.1724 59.5005 34.1724C58.8202 34.1724 58.1678 34.4426 57.6868 34.9236C57.2058 35.4046 56.9355 36.0571 56.9355 36.7373V59.5001C56.9357 60.1803 57.206 60.8325 57.6871 61.3135L74.09 77.7164C74.572 78.1919 75.2226 78.4575 75.8998 78.4552C76.5769 78.4529 77.2257 78.1829 77.7045 77.7041C78.1834 77.2253 78.4534 76.5765 78.4557 75.8994C78.4581 75.2222 78.1925 74.5716 77.717 74.0895L62.0655 58.438Z" />
			<path
						d="M59.5005 19.7971C60.1808 19.797 60.8331 19.5268 61.3142 19.0458C61.7952 18.5648 62.0654 17.9124 62.0655 17.2321V13.3308C62.0655 12.6506 61.7952 11.9982 61.3142 11.5171C60.8332 11.0361 60.1808 10.7659 59.5005 10.7659C58.8202 10.7659 58.1678 11.0361 57.6868 11.5171C57.2058 11.9982 56.9355 12.6506 56.9355 13.3308V17.2321C56.9356 17.9124 57.2058 18.5648 57.6868 19.0458C58.1679 19.5268 58.8202 19.797 59.5005 19.7971Z" />
			<path
						d="M59.5005 100.901C58.8202 100.901 58.1679 101.171 57.6868 101.652C57.2058 102.133 56.9356 102.786 56.9355 103.466V107.369C56.9355 108.049 57.2058 108.701 57.6868 109.182C58.1678 109.663 58.8202 109.934 59.5005 109.934C60.1808 109.934 60.8332 109.663 61.3142 109.182C61.7952 108.701 62.0655 108.049 62.0655 107.369V103.466C62.0654 102.786 61.7952 102.133 61.3142 101.652C60.8331 101.171 60.1808 100.901 59.5005 100.901Z" />
			<path
						d="M16.3831 57.7842H12.4819C11.8017 57.7842 11.1493 58.0544 10.6682 58.5354C10.1872 59.0165 9.91699 59.6689 9.91699 60.3491C9.91699 61.0294 10.1872 61.6818 10.6682 62.1628C11.1493 62.6439 11.8017 62.9141 12.4819 62.9141H16.3832C17.0635 62.9141 17.7159 62.6439 18.1969 62.1628C18.678 61.6818 18.9482 61.0294 18.9482 60.3491C18.9482 59.6689 18.678 59.0165 18.1969 58.5354C17.7159 58.0544 17.0634 57.7842 16.3831 57.7842Z" />
			<path
						d="M102.619 62.9141H106.52C107.2 62.9141 107.853 62.6439 108.334 62.1628C108.815 61.6818 109.085 61.0294 109.085 60.3491C109.085 59.6689 108.815 59.0165 108.334 58.5354C107.853 58.0544 107.2 57.7842 106.52 57.7842H102.619C101.938 57.7842 101.286 58.0544 100.805 58.5354C100.324 59.0165 100.054 59.6689 100.054 60.3491C100.054 61.0294 100.324 61.6818 100.805 62.1628C101.286 62.6439 101.938 62.9141 102.619 62.9141Z" />
			</svg>

				<h4 class="card-text mb-2" id="countdown"></h4>
				<p class="card-text text-secondary mb-2" id="lastPaymentDate"
					data-last-payment="${amap.subLastPaymentDate}">Dernier paiement
					le ${formattedDate}</p>
			</div>
		</div>


		<div href="#" class="card m-2">
			<div class="card-body text-center">
				<h2 class="card-title">Messages</h2>
				<svg class="mb-5 mt-5 black-svg" width="142" height="101"
					viewBox="0 0 142 101" fill="none"
					xmlns="http://www.w3.org/2000/svg">
			<path
						d="M13.4667 0C6.06436 0 0 6.06434 0 13.4667V87.5333C0 94.9356 6.06436 101 13.4667 101H127.933C135.336 101 141.4 94.9356 141.4 87.5333V13.4667C141.4 6.06434 135.336 0 127.933 0H13.4667ZM13.4667 6.73333H127.933C128.88 6.73333 129.755 6.92411 130.564 7.25937L75.5396 55.0765C72.4754 57.7373 68.8141 57.7375 65.7552 55.0765L10.8365 7.25937C11.6453 6.92411 12.5195 6.73333 13.4667 6.73333ZM6.83854 12.7302L61.3365 60.1265C66.696 64.789 74.5975 64.7815 79.9583 60.1265L134.561 12.7302C134.588 12.9777 134.667 13.2109 134.667 13.4667V87.5333C134.667 91.3218 131.722 94.2667 127.933 94.2667H13.4667C9.67816 94.2667 6.73333 91.3218 6.73333 87.5333V13.4667C6.73333 13.2109 6.81228 12.9777 6.83854 12.7302Z" />
			</svg>

				<p class="card-text text-muted">Vous n'avez pas de nouvelle
					demande de contact</p>
			</div>
		</div>

		<div href="#" class="card m-2">
			<div class="card-body text-center">
				<h2 class="card-title">Producteurs</h2>
				<h1 class="card-subtitle card-number mt-5 mb-5">${numberOfProducers}</h1>
				<p class="card-text text-muted">Producteurs inscrits</p>
			</div>
		</div>

		<div href="#" class="card m-2">
			<div class="card-body text-center">
				<h2 class="card-title">
					Adhérents
					</h5>
					<h1 class="card-subtitle card-number mt-5 mb-5">${numberOfAdherents}</h1>
					<p class="card-text text-muted">Particuliers et entreprises
						inscrites</p>
			</div>
		</div>

	</div>

</div>


<h2 class="mb-5 px-3 px-md-5 mr-2 ">Vous pouvez modifier vos informations de compte en cliquant sur <a class="btn btn-primary text-light" href="${pageContext.request.contextPath}/${amap.linkName}/details">modifier mes informations</a></h2>



<!-- Partie custom -->
<div class="px-3 px-md-5 mb-5">


<c:if test="${amap.subscription.id == 3}">

	<hr class="my-5" />

	<h2 class="mb-5">Partagez votre actualité du mois ou de la
		semaine.</h2>

	<form
		action="${pageContext.request.contextPath}/${amap.linkName}/backoffice/saveNews"
		method="post">
		<textarea class="form-control" id="news" name="news" rows="10"
			placeholder="Entrez votre texte ici..." required
			style="resize: none;">${amap.news}</textarea>
		<p id="newsCharCount">0 / 1000 caractères</p>
		<button class="btn btn-primary" type="submit">Enregistrer</button>
	</form>


</c:if>

<hr class="my-5" />

<h2 class="my-5">Complétez les informations relatives à  votre
	AMAP afin que vos utilisateurs puissent en savoir plus sur vous !</h2>

<c:set var="progresswidth" value="0"/>

<c:if test="${amap.logoText != null}">
    <c:set var="progresswidth" value="${progresswidth + 15}"/>
</c:if>

<c:if test="${amap.logoImgData != null}">
    <c:set var="progresswidth" value="${progresswidth + 15}"/>
</c:if>

<c:if test="${amap.aboutSectionTitle != null}">
    <c:set var="progresswidth" value="${progresswidth + 10}"/>
</c:if>

<c:if test="${amap.aboutSectionText != null}">
    <c:set var="progresswidth" value="${progresswidth + 20}"/>
</c:if>

<c:if test="${amap.aboutSectionImgData != null}">
    <c:set var="progresswidth" value="${progresswidth + 10}"/>
</c:if>

<c:if test="${amap.subSectionTitle != null}">
    <c:set var="progresswidth" value="${progresswidth + 10}"/>
</c:if>

<c:if test="${amap.subSectionText != null}">
    <c:set var="progresswidth" value="${progresswidth + 20}"/>
</c:if>


<div class="my-5 progress">
    <div id="progressBar" class="progress-bar progress-bar-striped progress-bar-animated"
        role="progressbar" aria-valuenow="${progresswidth}" aria-valuemin="0" aria-valuemax="100" 
        style="width: ${progresswidth}%;"
    >
        ${progresswidth}%
    </div>
</div>


	<h5 class="my-5">Étape 1 : Indiquez à  vos adhérents comment
		fonctionne le système d'abonnement au panier et de distribution chez
		vous.</h5>
		
	<button type="button" class="btn btn-secondary mt-3" id="autoFillButtonAbout">B</button>	
	<form
		action="${pageContext.request.contextPath}/${amap.linkName}/backoffice/saveAboutSection"
		method="POST" enctype="multipart/form-data">
		<div class="row">

			<div class="col-md-4">
				<label for="aboutSectionTitle" class="form-label">Titre de
					la section :</label> <input type="text" id="aboutSectionTitle"
					name="aboutSectionTitle" class="form-control mb-3"
					value="${amap.aboutSectionTitle}" required> <label
					for="amapfile" class="form-label mt-3">Image :</label>
				<div class="image-preview mt-3" id="amapImagePreview">
					<c:if test="${amap.aboutSectionImgData != null}">
						<img id="existingImage1"
							src="${pageContext.request.contextPath}/aboutSectionImg/${amap.id}"
							alt="Aperçu de l'image"
							style="display: block;">
					</c:if>
				</div>
				<input type="file" id="amapfile" name="amapfile" accept=".jpg,.jpeg,.png"
					class="form-control image-picker" onchange="previewImage(event, 'amapImagePreview')">

			</div>

			<div class="col-md-8">
				<label for="aboutSectionText" class="form-label">Description
					:</label>
				<textarea class="form-control" id="aboutSectionText"
					name="aboutSectionText" rows="18"
					placeholder="Entrez votre texte ici..." required
					style="resize: none;">${amap.aboutSectionText}</textarea>
				<p id="aboutSectionTextCharCount">0 / 2000 caractères</p>
			</div>

		</div>

		<button class="btn btn-primary mt-3" type="submit">Enregistrer</button>
	</form>







	<h5 class="my-5">Étape 2 : Indiquez à vos adhérents comment
		fonctionne le système d'abonnement au panier et de distribution chez
		vous.</h5>

	<button type="button" class="btn btn-secondary mt-3" id="autoFillButtonSub">B</button>
	<form
		action="${pageContext.request.contextPath}/${amap.linkName}/backoffice/saveSubSection"
		method="post">

		<label for="subSectionTitle" class="form-label">Titre de la
			section :</label> <input type="text" id="subSectionTitle"
			name="subSectionTitle" class="form-control mb-3"
			value="${amap.subSectionTitle}" required> <label
			for="subSectionText" class="form-label">Description :</label>
		<textarea class="form-control" id="subSectionText"
			name="subSectionText" rows="10"
			placeholder="Entrez votre texte ici..." required
			style="resize: none;">${amap.subSectionText}</textarea>
		<p id="subSectionCharCount">0 / 1000 caractères</p>
		<button class="btn btn-primary" type="submit">Enregistrer</button>
	</form>







	<h5 class="my-5">Étape 3 : Choisissez votre thème et votre image
		de banière.</h5>

	<form action="${pageContext.request.contextPath}/${amap.linkName}/backoffice/saveBannerColorLogo"
		method="post" enctype="multipart/form-data">

		<div class="row">

			<div class="col-md-3 pr-md-5">


				<!-- Image Logo -->
				<label for="logofile" class="form-label mt-3">Logo :</label>
				<div class="image-preview mt-3 mx-auto" id="logoImagePreview">
					<c:if test="${amap.logoImgData != null}">
						<img id="existingImage2"
							src="${pageContext.request.contextPath}/logoImg/${amap.id}"
							style="display: block;">
					</c:if>
				</div>
				<input type="file" id="logofile" name="logofile" accept=".jpg,.jpeg,.png"
					class="form-control image-picker"
					onchange="previewImage(event, 'logoImagePreview')">

				
			</div>

			<!-- theme bannerColor -->
			<div class="col-md-9 px-md-5">

				<!-- Label Logo -->
				<label for="logoText" class="form-label mt-4">Nom qui apparaîtra
					à côté ou sous le logo :</label> <input type="text" id="logoText"
					name="logoText" class="form-control col-md-4 mb-3" value="${amap.logoText}"
					maxlength="10">
					
				<label for="bannerColor" class="form-label mt-5">Thèmes :</label>
				
				<div class="row">
					<div class="col-md-3">
						<div class="form-check m-3">
							<input class="form-check-input" type="radio" name="bannerColor"
								value="DEFAULT"
								<c:if test="${amap.bannerColor == null || amap.bannerColor == 'DEFAULT'}">checked</c:if> />
							<div class="color-div" style="background-color: #DBDBDB;"></div>
						</div>
						<div class="form-check m-3">
							<input class="form-check-input" type="radio" name="bannerColor"
								value="RED"
								<c:if test="${amap.bannerColor == 'RED'}">checked</c:if> />
							<div class="color-div" style="background-color: #FFC0C0;"></div>
						</div>
						<div class="form-check m-3">
							<input class="form-check-input" type="radio" name="bannerColor"
								value="YELLOW"
								<c:if test="${amap.bannerColor == 'YELLOW'}">checked</c:if> />
							<div class="color-div" style="background-color: #F2E0A5;"></div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-check m-3">
							<input class="form-check-input" type="radio" name="bannerColor"
								value="GREEN"
								<c:if test="${amap.bannerColor == 'GREEN'}">checked</c:if> />
							<div class="color-div" style="background-color: #BFF5B2;"></div>
						</div>
						<div class="form-check m-3">
							<input class="form-check-input" type="radio" name="bannerColor"
								value="LIGHTBLUE"
								<c:if test="${amap.bannerColor == 'LIGHTBLUE'}">checked</c:if> />
							<div class="color-div" style="background-color: #C0F1FF;"></div>
						</div>
						<div class="form-check m-3">
							<input class="form-check-input" type="radio" name="bannerColor"
								value="BLUE"
								<c:if test="${amap.bannerColor == 'BLUE'}">checked</c:if> />
							<div class="color-div" style="background-color: #CAE1FF;"></div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-check m-3">
							<input class="form-check-input" type="radio" name="bannerColor"
								value="PINK"
								<c:if test="${amap.bannerColor == 'PINK'}">checked</c:if> />
							<div class="color-div" style="background-color: #FCC0FB;"></div>
						</div>
						<div class="form-check m-3">
							<input class="form-check-input" type="radio" name="bannerColor"
								value="BROWN"
								<c:if test="${amap.bannerColor == 'BROWN'}">checked</c:if> />
							<div class="color-div" style="background-color: #DBBC9D;"></div>
						</div>
					</div>

				</div>
			</div>


		</div>


<div class="col-md-12 p-0 mt-5">
  <label for="bannerChoice" class="form-label mt-4">Souhaitez-vous ajouter une image de bannière ?</label>
  <div class="d-flex">
    <!-- Option Oui -->
    <div class="form-check mr-5">
      <input class="form-check-input" type="radio" name="bannerChoice" id="bannerYes" value="yes"
        <c:if test="${amap.bannerChoice == true}">checked</c:if>
        onclick="toggleBannerImageInput()">
      <label class="form-check-label" for="bannerYes">Oui</label>
    </div>
    <!-- Option Non -->
    <div class="form-check">
      <input class="form-check-input" type="radio" name="bannerChoice" id="bannerNo" value="no"
        <c:if test="${amap.bannerChoice == false}">checked</c:if>
        onclick="toggleBannerImageInput()">
      <label class="form-check-label" for="bannerNo">Non</label>
    </div>
  </div>
</div>

<!-- Section de l'image de bannière, visible uniquement si "Oui" est sélectionné -->
<div id="bannerImageSection" style="display: none;">
  <label for="bannerfile" class="form-label mt-5">Image de bannière (optionnel) :</label>
  <div class="image-preview mt-3" id="bannerImagePreview">
	<c:if test="${amap.bannerImgData != null}">
	    <img id="existingImage3" src="${pageContext.request.contextPath}/bannerImg/${amap.id}"
	      style="display: block;">
    </c:if>
  </div>
  <input type="file" id="bannerfile" name="bannerfile" accept=".jpg,.jpeg,.png"
    class="form-control image-picker" onchange="previewImage(event, 'bannerImagePreview')">
</div>

		<button class="btn btn-primary my-5" type="submit">Enregistrer</button>
	</form>
	
</div>


<script>
  document.getElementById('autoFillButtonAbout').addEventListener('click', function() {
    document.getElementById('aboutSectionTitle').value = "Notre amap c'est ...";
    document.getElementById('aboutSectionText').value = "Fondée en 2018, notre AMAP résolument tournée vers l’avenir. Nous unissons innovation et tradition pour bâtir une agriculture durable et solidaire. Située en périphérie urbaine, Agrinov connecte les citadins aux agriculteurs locaux à travers des produits cultivés avec soin et respect de l’environnement.\n\n"
		+ "Notre mission est de répondre aux besoins alimentaires d’aujourd’hui tout en préservant les ressources pour demain. Chaque panier Agrinov est une promesse : celle d’une alimentation saine, de saison et produite dans une logique de circuit court. Nos partenaires agricoles, sélectionnés pour leurs pratiques écoresponsables, s’engagent à cultiver et élever dans des conditions favorables à la biodiversité.\n\n"
		+ "Rejoindre Agrinov, c’est faire partie d’une initiative collaborative où chaque adhérent est acteur de la transition écologique. Participez à nos rencontres, nos ateliers éducatifs, et ensemble, construisons un avenir alimentaire innovant et respectueux des générations futures.";
  });
  document.getElementById('autoFillButtonSub').addEventListener('click', function() {
	    document.getElementById('subSectionTitle').value = "Fonctionnement des abonnements paniers";
	    document.getElementById('subSectionText').value = "L’abonnement chez nous se veut flexible et adapté à votre mode de vie. Vous pouvez choisir parmi plusieurs tailles de paniers et personnaliser votre abonnement selon vos besoins : panier standard, spécial fruits, ou encore panier végétarien. L’engagement est saisonnier (3 mois) avec des options de retrait hebdomadaires ou mensuelles.\n\n"
		    + "Les paniers sont disponibles tous les samedis matin de 9h à 12h dans notre point de retrait principal, situé près de la ferme pédagogique d’Agrinov. Un mail de rappel vous est envoyé la veille pour vous assurer de ne pas oublier votre panier. Si vous êtes indisponible, nous offrons la possibilité de reporter votre retrait ou de le faire livrer à un voisin solidaire.\n\n"
		    + "En rejoignant Agrinov, vous accédez à une alimentation locale, fraîche et savoureuse, tout en participant activement à un modèle agricole innovant et responsable.";
	  });
</script>
