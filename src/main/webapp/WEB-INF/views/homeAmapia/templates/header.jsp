<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top top-navbar">
	  <div class="container d-flex align-items-center">
	    <!-- logo -->
	    <a class="navbar-logo" href="<c:url value='/home'/>">
	      <img id="normal-logo" class="d-none d-lg-block" src="<c:url value='/resources/images/logo-color.svg'/>" alt="logo"> <!-- logo normal, visible sur les grands écrans -->
	      <img id="burger-logo" class="d-block d-lg-none" src="<c:url value='/resources/images/logo-icon-color.svg'/>" alt="logo"> <!-- logo burger, visible sur les petits écrans -->
	    </a>
	
	    <!-- burger menu -->
	    <button class="navbar-toggler ml-auto" type="button" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		  <span class="navbar-toggler-icon"></span>
		</button>
	
	    <!-- nav -->
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav mx-auto">
	        <li class="nav-item"><a class="nav-link" href="<c:url value='/home'/>">Accueil</a></li>
	        <li class="nav-item"><a class="nav-link" href="#features">Fonctionnalités</a></li>
	        <li class="nav-item"><a class="nav-link" href="#subscriptions">Forfaits</a></li>
	        <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
	        <!-- Connexion for smaller screens -->
	        <li class="nav-item d-lg-none"><a class="nav-link" href="<c:url value='/amap/login' />">Connexion</a></li>
	      </ul>
	    </div>
	
	    <!-- connexion -->
	    <a class="nav-link connexion-link d-none d-lg-block" href="<c:url value='/amap/login' />">Connexion</a>
	
	  </div>
	</nav>
</div>

