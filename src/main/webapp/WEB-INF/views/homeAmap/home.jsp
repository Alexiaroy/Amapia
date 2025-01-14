<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${amap.subscription.id == 3 }">
	<c:if test="${amap.news !=null}">
		<hr class="my-5">
		<div>
			<p class="text-center mx-2 mx-md-5" style="font-size: 20px;" id="newsText">${amap.news}</p>
		</div>
		<hr class="my-5">
	</c:if>
</c:if>
<div></div>
<c:choose>
	<c:when test="${not empty amap}">

		<div id="carouselExampleCaptions" class="carousel slide carousel-dark"
			style="margin-bottom: 100px;" data-bs-ride="carousel">

			<div class="carousel-inner">
				<!-- Slide 1 : Products -->
				<c:if test="${amap.subscription.id != 1}">
					<div class="carousel-item">
						<div
							class="d-flex align-items-center justify-content-center slide-responsive"
							style="gap: 2rem;">
							<c:choose>
								<c:when test="${not empty lastTwoProducts}">
									<div class="carousel-text">
										<h5>Les produits du moment</h5>
										<p>Les produits affichés sont ceux qui ont été ajoutés
											récemment à la boutique. Si vous souhaitez voir la liste
											complète des produits que nous proposons, rendez-vous dans la
											section "La Boutique".</p>
										<a href="#" class="btn btn-primary">Voir tous les produits</a>
									</div>
									<div class="cards d-flex cards-container">
										<c:forEach var="product" items="${lastTwoProducts}">
											<div class="card product-card">
												<img
													src="${pageContext.request.contextPath}/productImage/${product.id}"
													class="card-img-top" alt="${product.name}"
													style="height: 150px; object-fit: cover;">
												<div class="card-body">
													<h5 class="card-title">${product.name}</h5>
													<p class="card-text">${product.price}€</p>
												</div>
											</div>
										</c:forEach>
									</div>
								</c:when>
								<c:otherwise>
									<div style="height: 200px;"
										class="d-flex flex-column align-items-center justify-content-center">
										<p class="text-center" style="font-size: 20px;">Cette AMAP
											n'a pas encore de produits disponibles. Revenez bientôt pour
											découvrir les nouveautés !</p>
										<br>
										<p>De belles surprises vous attendent prochainement.</p>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:if>
				<!-- Slide 2 : Activities -->
				<c:if test="${amap.subscription.id == 3}">
					<div class="carousel-item">
						<div
							class="d-flex align-items-center justify-content-center slide-responsive"
							style="gap: 2rem;">
							<c:choose>
								<c:when test="${not empty lastTwoActivities}">
									<div class="carousel-text">
										<h5>Les activités du moment</h5>
										<p>Les activités affichées sont celles qui auront bientôt
											lieu. Si vous souhaitez voir la liste complète des activités
											que nous proposons, rendez-vous dans la section "Les
											Activités".</p>
										<a href="#" class="btn btn-primary">Voir toutes les
											activités</a>
									</div>
									<div class="cards d-flex cards-container">
										<c:forEach var="activity" items="${lastTwoActivities}">
											<div class="card product-card">
												<img
													src="${pageContext.request.contextPath}/activityImage/${activity.activity_id}"
													class="card-img-top" alt="${activity.activityName}"
													style="height: 150px; object-fit: cover;">
												<div class="card-body">
													<h5 class="card-title">${activity.activityName}</h5>
													<p class="card-text">${activity.price}€</p>
												</div>
											</div>
										</c:forEach>
									</div>
								</c:when>
								<c:otherwise>
									<div style="height: 200px;"
										class="d-flex flex-column align-items-center justify-content-center">
										<p class="text-center" style="font-size: 20px;">Cette AMAP
											n'a pas encore d'activités disponibles. Revenez bientôt pour
											découvrir les nouveautés !</p>
										<br>
										<p>De belles surprises vous attendent prochainement.</p>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:if>
				<!-- Slide 3 : Baskets -->
				<div class="carousel-item active">
					<div
						class="d-flex align-items-center justify-content-center slide-responsive"
						style="gap: 2rem;">
						<c:choose>
							<c:when test="${not empty lastTwoBaskets}">
								<div class="carousel-text">
									<h5>Les paniers du moment</h5>
									<p>Les paniers affichés sont ceux qui ont été ajoutés
										récemment. Si vous souhaitez voir la liste complète des
										abonnements que nous proposons, rendez-vous dans la section
										"Les Paniers".</p>
									<a href="#" class="btn btn-primary">Voir tous les paniers</a>
								</div>
								<div class="cards d-flex cards-container">
									<c:forEach var="basket" items="${lastTwoBaskets}">
										<div class="card product-card">
											<img
												src="${pageContext.request.contextPath}/basketImage/${basket.id}"
												class="card-img-top" alt="${basket.name}"
												style="height: 150px; object-fit: cover;">
											<div class="card-body">
												<h5 class="card-title">${basket.name}</h5>
												<p class="card-text">${basket.price}€</p>
											</div>
										</div>
									</c:forEach>
								</div>
							</c:when>
							<c:otherwise>
								<div style="height: 200px;"
									class="d-flex flex-column align-items-center justify-content-center">
									<p class="text-center" style="font-size: 20px;">Cette AMAP
										n'a pas encore de paniers disponibles. Revenez bientôt pour
										découvrir les nouveautés !</p>
									<br>
									<p>De belles surprises vous attendent prochainement.</p>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<c:if test="${amap.subscription.id != 1}">

				<div class="carousel-indicators"
					style="position: relative; bottom: -10px;">
					<button type="button" data-bs-target="#carouselExampleCaptions"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleCaptions"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleCaptions"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
			</c:if>
			<c:if test="${amap.subscription.id != 1}">

				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</c:if>
		</div>


	</c:when>
	<c:otherwise>
		<h2 class="text-center text-danger mt-5">Amap non trouvée</h2>
	</c:otherwise>
</c:choose>

	<script>
		// Change \n into <br>
		let newsText = `${amap.news}`;

		let formattednewsText = newsText.replace(/\n/g, '<br>');

		document.getElementById('newsText').innerHTML = formattednewsText;
	</script>
