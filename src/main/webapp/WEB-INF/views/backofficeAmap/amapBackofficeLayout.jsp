<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${amap.name}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/amapbackofficestyles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/amaplayoutstyles.css">  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/amaptablestyles.css">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/logoImg/${amap.id}">  
</head>
<body>

<!-- Header -->
<c:choose>
    <c:when test="${amap.bannerImgData == null && amap.bannerColor == null}">
        <header id="header" style="background-color: #DBDBDB;">
            <div class="header-content w-100">
                <c:choose>
                    <c:when test="${not empty amap}">
                        <div class="d-flex flex-row justify-content-between align-items-center p-5 w-100">
                            <div class="mr-5">
                                <h1 class="responsive-title">${amap.name.toUpperCase()}</h1>
                                <p class="responsive-text">${amap.address}</p>
                            </div>
                            <c:if test="${amap.subscription.id != 3 }">
                            <img class="responsive-img" 
                                 src="${pageContext.request.contextPath}/resources/images/amap/Logo_by_amapia.svg" 
                                 alt="LogoAmapia">
                                 </c:if>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <h2 class="text-center text-danger mt-5">Amap non trouvée</h2>
                    </c:otherwise>
                </c:choose>
            </div>
        </header>
    </c:when>

    <c:when test="${amap.bannerImgData != null}">
        <header id="header"
                style="background-color: ${amap.getBannerColor().toString()};
                       background-image: url('${pageContext.request.contextPath}/bannerImg/${amap.id}');
                       background-size: cover; 
                       background-repeat: no-repeat;">
            <div class="header-content w-100">
                <div class="d-flex flex-row justify-content-between align-items-center p-5 w-100">
                    <div class="mr-5">
                    </div>
                    <c:if test="${amap.subscription.id != 3 }">
                    <img class="responsive-img" 
                         src="${pageContext.request.contextPath}/resources/images/amap/Logo_by_amapia.svg" 
                         alt="LogoAmapia">
                         </c:if>
                </div>
            </div>
        </header>
    </c:when>

    <c:when test="${amap.bannerImgData == null && amap.bannerColor != null}">
        <header id="header"
                style="background-color: ${amap.getBannerColor().toString()};">
            <div class="header-content w-100">
                <div class="d-flex flex-row justify-content-between align-items-center p-5 w-100">
                    <div class="mr-5">
                        <h1 class="responsive-title">${amap.name.toUpperCase()}</h1>
                        <p class="responsive-text">${amap.address}</p>
                    </div>
                    <c:if test="${amap.subscription.id != 3 }">
                    <img class="responsive-img" 
                         src="${pageContext.request.contextPath}/resources/images/amap/Logo_by_amapia.svg" 
                         alt="LogoAmapia">
                         </c:if>
                </div>
            </div>
        </header>
    </c:when>
</c:choose>

        <!-- Navbar for computers -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light" id="navbar">
         	<div class="container-fluid">
         	
	         	<a class="navbar-brand" href="#">
	         	
		         	<c:choose>
				        <c:when test="${amap.logoImgData != null}">
				            <img  class="mr-2" src="${pageContext.request.contextPath}/logoImg/${amap.id}" width="auto" height="45">
				        </c:when>
				        <c:otherwise>
				            <img  class="mr-2" src="${pageContext.request.contextPath}/resources/images/amap/defaultLogo.PNG" alt="LogoAmap" width="30" height="30">
				        </c:otherwise>
				    </c:choose>
			    
			      	<span>${amap.logoText}</span>
			    </a>
			    
			    <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
				  <ul class="navbar-nav">
				    <li class="nav-item pl-2 pr-2">
				      <a class="nav-link" href="${pageContext.request.contextPath}/${linkName}/backoffice">Accueil</a>
				    </li>
				    <li class="nav-item pl-2 pr-2">
				      <a class="nav-link" href="${pageContext.request.contextPath}/${linkName}/members">Les membres</a>
				    </li>
				    <li class="nav-item pl-2 pr-2">
				      <a class="nav-link" href="${pageContext.request.contextPath}/${linkName}/messages">Messages</a>
				    </li>
				    <c:choose>
						<c:when test="${amap.bannerColor != null}">
							<div id="nav-marker" style="background-color: ${amap.getBannerColor().toString()};"></div>
						</c:when>
						<c:otherwise>
							<div id="nav-marker" style="background-color: #DBDBDB;"></div>
						</c:otherwise>
					</c:choose>
				  </ul>
				</div>

			    
			    <div class="d-flex svg-nav">
			    
	        		<a class="nav-link"
							href="${pageContext.request.contextPath}/${linkName}">
							<svg width="30" height="30" viewBox="0 0 30 30" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path d="M14.8259 0C23.0134 0 29.651 6.63838 29.651 14.8259C29.651 17.6316 28.8716 20.255 27.5175 22.492L26.2752 21.7058C27.366 19.8934 28.0396 17.8004 28.1612 15.5611H24.3712C24.321 17.1575 24.1087 18.6893 23.7606 20.1147L22.447 19.2842C22.7013 18.1102 22.8574 16.8604 22.9001 15.5611H15.5611V20.5896C16.429 20.6016 17.2827 20.6338 18.1184 20.6863L18.474 22.1829C17.5265 22.1154 16.5536 22.0742 15.5611 22.0599V28.1252C16.9497 27.9143 18.2452 27.1109 19.3495 25.8716L20.0239 28.714C18.4065 29.3202 16.6548 29.6518 14.8259 29.6518C6.63763 29.6518 0 23.0134 0 14.8259C0 6.63838 6.63763 0 14.8259 0ZM1.49062 14.0907H5.28055C5.34506 12.036 5.67739 10.0885 6.22503 8.33605C5.27379 8.16425 4.36382 7.9647 3.50261 7.7404C2.33757 9.59936 1.61665 11.7659 1.49062 14.0907ZM6.75091 14.0907H14.0907V9.06222C11.9512 9.03297 9.80491 8.87843 7.68639 8.5731C7.147 10.2355 6.81692 12.1042 6.75091 14.0907ZM15.5611 14.0907H22.9001C22.8349 12.1042 22.504 10.2355 21.9654 8.5731C19.8469 8.87843 17.7006 9.03297 15.5611 9.06222V14.0907ZM24.3712 14.0907H28.1612C28.0351 11.7659 27.3142 9.59936 26.1484 7.7404C25.2872 7.9647 24.3772 8.16425 23.4267 8.33605C23.9736 10.0885 24.3067 12.036 24.3712 14.0907ZM14.0907 15.5611H6.75091C6.81692 17.5476 7.147 19.4163 7.68639 21.0787C9.80491 20.7733 11.9512 20.6188 14.0907 20.5896V15.5611ZM5.28055 15.5611H1.49062C1.61665 17.8859 2.33757 20.0524 3.50261 21.9114C4.36382 21.6871 5.27379 21.4875 6.22503 21.3157C5.67739 19.5633 5.34506 17.6166 5.28055 15.5611ZM15.5611 1.52662V7.59186C17.5243 7.56411 19.4913 7.42832 21.4373 7.16351C20.3757 4.6849 18.39 1.95648 15.5611 1.52662ZM14.0907 28.1252V22.0599C12.1267 22.0877 10.1605 22.2235 8.21452 22.489C9.27603 24.9676 11.2618 27.6953 14.0907 28.1252ZM14.0907 7.59186V1.52662C11.2618 1.95648 9.27603 4.6849 8.21452 7.16351C10.1605 7.42832 12.1267 7.56411 14.0907 7.59186ZM20.285 2.6339C21.4313 3.8687 22.2985 5.37657 22.9264 6.9332C23.7306 6.79442 24.5018 6.63538 25.2354 6.45833C23.9121 4.81393 22.2122 3.49811 20.285 2.6339ZM9.36605 27.0179C8.21977 25.7831 7.3533 24.276 6.72465 22.7186C5.92045 22.8581 5.15001 23.0171 4.41633 23.1934C5.73966 24.8378 7.43882 26.1537 9.36605 27.0179ZM6.72465 6.9332C7.3533 5.37657 8.21977 3.8687 9.36605 2.6339C7.43882 3.49811 5.73966 4.81393 4.41633 6.45833C5.15001 6.63538 5.92045 6.79442 6.72465 6.9332Z" fill="black"/>
							<path fill-rule="evenodd" clip-rule="evenodd" d="M25.2295 25.1701L27.567 28.4454C27.606 28.5009 27.5933 28.5774 27.5385 28.6164L25.6316 29.9773C25.5768 30.0163 25.5003 30.0035 25.4605 29.9487L23.1229 26.6727L21.4988 27.8317C21.4275 27.8827 21.3285 27.846 21.3083 27.7605L19.2963 19.2789C19.2708 19.1723 19.3885 19.0891 19.4808 19.1468L26.8476 23.8077C26.9211 23.8542 26.9241 23.96 26.8529 24.011L25.2295 25.1701Z" fill="black"/>
							</svg>
							<span class="infobox">Voir le site</span>
						</a>
						
	        		<a class="nav-link"
							href="${pageContext.request.contextPath}/amap/amaplogout">
							<svg width="26" height="30" viewBox="0 0 26 30" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path d="M13.9655 30H1.55172C0.698284 30 0 29.3017 0 28.4483V1.55172C0 0.698284 0.698284 0 1.55172 0H13.9655C14.819 0 15.5172 0.698284 15.5172 1.55172V6.72414C15.5172 7.00862 15.2845 7.24138 15 7.24138C14.7155 7.24138 14.4828 7.00862 14.4828 6.72414V1.55172C14.4828 1.26724 14.25 1.03448 13.9655 1.03448H1.55172C1.26724 1.03448 1.03448 1.26724 1.03448 1.55172V28.4483C1.03448 28.7328 1.26724 28.9655 1.55172 28.9655H13.9655C14.25 28.9655 14.4828 28.7328 14.4828 28.4483V23.2759C14.4828 22.9914 14.7155 22.7586 15 22.7586C15.2845 22.7586 15.5172 22.9914 15.5172 23.2759V28.4483C15.5172 29.3017 14.819 30 13.9655 30Z" fill="black"/>
							<path d="M25.3448 15.5172H4.65518C4.3707 15.5172 4.13794 15.2845 4.13794 15C4.13794 14.7155 4.3707 14.4827 4.65518 14.4827H24.0982L18.7758 9.16037C18.5741 8.95865 18.5741 8.63277 18.7758 8.43107C18.9775 8.22937 19.3034 8.22934 19.5051 8.43107L25.712 14.638C25.862 14.788 25.9034 15.0104 25.8258 15.2018C25.7482 15.3931 25.5568 15.5224 25.3499 15.5224L25.3448 15.5172Z" fill="black"/>
							<path d="M19.1379 21.7241C19.0034 21.7241 18.8741 21.6723 18.7707 21.5741C18.569 21.3723 18.569 21.0465 18.7707 20.8448L24.9776 14.6379C25.1793 14.4361 25.5052 14.4361 25.7069 14.6379C25.9086 14.8396 25.9086 15.1655 25.7069 15.3672L19.5 21.5741C19.3965 21.6775 19.2672 21.7241 19.1327 21.7241H19.1379Z" fill="black"/>
							</svg>
							 <span class="infobox">Déconnexion</span>
				    </a>
			    </div>
			    
			    
			    
	        </ul>
	    </nav>
	    
	    <!-- Navbar for tablet and mobile -->
	    <nav class="m-0 p-0 navbar navbar-light bg-light navbar-expand fixed-bottom" id="navbar-mobile">
		    <ul class="navbar-nav nav-justified  w-100">
		        <li class="nav-item">
				      <a class="nav-link active" href="${pageContext.request.contextPath}/${linkName}/backoffice">
				      <div class="nav-item-container m-auto">
				      <svg width="44" height="44" viewBox="0 0 44 44" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path d="M16.7411 27.1779H27.2588C27.7065 27.1933 28.0667 27.5648 28.0667 28.0176V41.8111H15.9352V28.0176C15.9352 27.5648 16.2935 27.1934 16.7411 27.1779ZM22.0165 2.18965V2.19624H22.023C22.023 2.19185 22.0252 2.19185 22.0274 2.19185C22.1671 2.19185 22.3003 2.22702 22.4139 2.29076L41.3493 11.8199C41.6135 11.9584 41.7947 12.2398 41.7947 12.5607L41.8253 40.9715C41.8253 41.4265 41.4672 41.7958 41.0196 41.8112L30.2397 41.8134V27.9979C30.2309 26.3471 28.9077 25.0107 27.2701 24.9909H16.7305C15.0929 25.0106 13.7697 26.3471 13.761 27.9979V41.8134H2.98106C2.53344 41.7958 2.17535 41.4265 2.17535 40.9715C2.17535 40.9693 2.23649 12.5607 2.23649 12.5607C2.23649 12.2398 2.41772 11.9584 2.68193 11.8199L21.6436 2.27557C21.7571 2.21842 21.8838 2.18985 22.017 2.18985L22.0165 2.18965ZM22.0165 0.0003177V0.00691158H22.0077C22.0055 0.00251558 22.0034 0.0025153 21.999 0.0025153C21.5557 0.0025153 21.1278 0.0684611 20.75 0.244312L1.67039 9.8455C0.711852 10.3467 0.0392887 11.371 0.0305686 12.5338L0 40.9907C0.0109174 42.6415 1.33193 43.978 2.96957 44H41.0304C42.6681 43.978 43.9913 42.6415 44 40.9907V12.5338C43.9913 11.371 43.3187 10.3467 42.358 9.8455L23.3963 0.301147C22.9858 0.0879256 22.5122 0.0003177 22.0165 0.0003177Z"/>
						</svg>
						<span>Accueil</span>
						</div>
				      </a>
				      
				    </li>
				    <li class="nav-item">
				      <a class="nav-link" href="${pageContext.request.contextPath}/${linkName}/members">
				      	<div class="nav-item-container m-auto">
				      	<svg width="51" height="37" viewBox="0 0 51 37" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path d="M20.3432 17.7191C22.5235 18.4939 24.4821 19.7512 26.0888 21.3643C28.859 24.1488 30.5776 27.9923 30.5776 32.2181V35.7979C30.5776 36.4623 30.0427 37 29.3817 37H1.19594C0.534942 37 0 36.4623 0 35.7979V32.2181C0 27.9922 1.72068 24.1486 4.49083 21.3643C6.09758 19.7492 8.05422 18.4918 10.2365 17.7191C9.73411 17.3817 9.26833 16.9974 8.84122 16.5701C7.19172 14.912 6.17073 12.6202 6.17073 10.0891C6.17073 7.55813 7.19172 5.26631 8.84122 3.60815C10.4928 1.95009 12.7707 0.923801 15.2887 0.923801C17.8067 0.923801 20.0867 1.95009 21.7363 3.60815C23.3878 5.26825 24.4068 7.55802 24.4068 10.0891C24.4068 12.6201 23.3858 14.9119 21.7363 16.5701C21.3112 16.9974 20.8434 17.3838 20.341 17.7191H20.3432ZM38.4632 12.8287C39.893 12.8287 41.1906 12.2461 42.1283 11.3015C43.0659 10.359 43.6456 9.05875 43.6456 7.61946C43.6456 6.18222 43.0659 4.87786 42.1283 3.93536C41.1906 2.99287 39.895 2.40815 38.4632 2.40815C37.0333 2.40815 35.7378 2.99083 34.7981 3.93536C33.8605 4.87786 33.2808 6.18018 33.2808 7.61946C33.2808 9.05671 33.8605 10.359 34.7981 11.3015C35.7357 12.244 37.0313 12.8287 38.4632 12.8287ZM43.8183 13.0025C43.5702 13.2519 43.3058 13.483 43.0251 13.6956C44.6461 14.3355 46.1065 15.3107 47.3187 16.5271C49.5905 18.8108 51 21.9614 51 25.4266V28.3073C51 28.9717 50.4651 29.5094 49.8041 29.5094H35.4693C34.8084 29.5094 34.2734 28.9717 34.2734 28.3073C34.2734 27.6449 34.8083 27.1051 35.4693 27.1051H48.6081V25.4246C48.6081 22.6217 47.4671 20.072 45.6284 18.224C43.7877 16.3737 41.2535 15.2268 38.4629 15.2268C36.9903 15.2268 35.5931 15.5417 34.3361 16.11C33.0222 16.7029 31.8548 17.5677 30.9049 18.6328C30.4656 19.1256 29.7131 19.1685 29.2249 18.7269C28.7348 18.2853 28.6921 17.5309 29.1314 17.0382C30.3029 15.7236 31.7449 14.6543 33.3639 13.9224C33.5429 13.8427 33.7239 13.765 33.9049 13.6935C33.6243 13.4808 33.3558 13.2478 33.1077 12.9963C31.7368 11.6184 30.8887 9.71706 30.8887 7.6134C30.8887 5.51173 31.7368 3.61041 33.1077 2.23047C34.4785 0.852528 36.37 0 38.4628 0C40.5536 0 42.4452 0.852528 43.818 2.23047C45.1888 3.60842 46.0369 5.50974 46.0369 7.6134C46.0369 9.71508 45.1888 11.6164 43.818 12.9963L43.8183 13.0025ZM15.2931 16.8502C17.1521 16.8502 18.8341 16.0937 20.0504 14.8691C21.2687 13.6445 22.0212 11.9558 22.0212 10.0871C22.0212 8.21854 21.2687 6.52777 20.0504 5.30521C18.8321 4.08266 17.1521 3.32622 15.2931 3.32622C13.4342 3.32622 11.7521 4.08266 10.5359 5.30521C9.31962 6.52981 8.56709 8.22058 8.56709 10.0871C8.56709 11.9558 9.31962 13.6465 10.5359 14.8691C11.7541 16.0937 13.4362 16.8502 15.2931 16.8502ZM24.4008 23.0611C22.0618 20.71 18.8379 19.2523 15.2931 19.2523C11.7481 19.2523 8.52226 20.71 6.18547 23.0611C3.84649 25.4122 2.39636 28.6528 2.39636 32.216V34.5957H28.1943V32.216C28.1943 28.6525 26.7441 25.41 24.4052 23.0611H24.4008Z" fill="black"/>
						</svg>
						<span>Membres</span>
						</div>
				      </a>
				    </li>
				    <li class="nav-item">
				      <a class="nav-link" href="${pageContext.request.contextPath}/${linkName}/messages">
				      <div class="nav-item-container m-auto">
				      	<svg width="51" height="35" viewBox="0 0 51 35" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path d="M51 5.93274C51 2.66234 48.3329 0 45.0535 0C42.5124 0 40.3557 1.60657 39.505 3.84776H4.26915C1.91359 3.84776 0 5.75621 0 8.10544V30.76C0 33.0981 1.91359 35 4.26915 35H42.877C45.2215 35 47.1285 33.0981 47.1285 30.76V11.4707C49.3824 10.6266 51 8.47147 51 5.93274ZM39.1625 5.34652C39.1426 5.54265 39.1029 5.73217 39.1029 5.93274C39.1029 7.0258 39.4211 8.03515 39.9403 8.91665L25.3056 20.8921C24.298 21.7185 22.8329 21.7185 21.8231 20.8921L3.14256 5.59148C3.48727 5.43721 3.86731 5.34686 4.26951 5.34686L39.1625 5.34652ZM1.97565 32.2898C1.67955 31.8535 1.50277 31.3246 1.50277 30.7604V8.1059C1.50277 7.53733 1.67513 7.01283 1.97122 6.5743L17.6667 19.4288L1.97565 32.2898ZM4.26932 33.5019C3.87158 33.5019 3.49592 33.4137 3.15119 33.2639L18.8512 20.3959L20.8686 22.0487C21.6508 22.6878 22.6054 23.0095 23.5644 23.0095C24.5234 23.0095 25.478 22.6878 26.2602 22.0487L28.2799 20.3959L43.9906 33.2616C43.6503 33.4137 43.2725 33.5018 42.8769 33.5018L4.26904 33.4996L4.26932 33.5019ZM45.6258 30.7604C45.6258 31.3223 45.4535 31.8468 45.1618 32.281L29.4641 19.4265L40.8439 10.1178C41.9223 11.1955 43.4116 11.8654 45.0556 11.8654C45.2523 11.8654 45.4379 11.8258 45.6301 11.8081L45.6279 30.7606L45.6258 30.7604ZM45.0535 10.367C42.6008 10.367 40.6076 8.37923 40.6076 5.93302C40.6076 3.48687 42.6007 1.49904 45.0535 1.49904C47.5041 1.49904 49.4995 3.48681 49.4995 5.93302C49.4973 8.37697 47.5041 10.367 45.0535 10.367Z"/>
						</svg>
						<span>Messages</span>
						</div>
				      </a>
				    </li>
				    <li class="nav-item">
				      <a class="nav-link" href="${pageContext.request.contextPath}/${linkName}">
				      <div class="nav-item-container m-auto">
				      <svg width="39" height="39" viewBox="0 0 39 39" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path d="M19.2737 0C29.9175 0 38.5464 8.62991 38.5464 19.2737C38.5464 22.9211 37.5331 26.3315 35.7728 29.2397L34.1578 28.2176C35.5758 25.8614 36.4516 23.1405 36.6096 20.2294H31.6826C31.6173 22.3047 31.3413 24.2962 30.8888 26.1491L29.1812 25.0695C29.5118 23.5433 29.7146 21.9185 29.7702 20.2294H20.2294V26.7665C21.3578 26.7821 22.4676 26.824 23.554 26.8923L24.0163 28.8379C22.7846 28.7501 21.5197 28.6965 20.2294 28.6779V36.5628C22.0346 36.2887 23.7188 35.2442 25.1544 33.6331L26.0311 37.3283C23.9285 38.1163 21.6513 38.5474 19.2737 38.5474C8.62893 38.5474 0 29.9175 0 19.2737C0 8.62991 8.62893 0 19.2737 0ZM1.9378 18.3179H6.86472C6.94859 15.6468 7.38062 13.115 8.09255 10.8369C6.85594 10.6135 5.67298 10.3541 4.5534 10.0625C3.03885 12.4792 2.10164 15.2957 1.9378 18.3179ZM8.77619 18.3179H18.3179V11.7809C15.5366 11.7429 12.7464 11.542 9.99232 11.1451C9.29112 13.3062 8.86201 15.7355 8.77619 18.3179ZM20.2294 18.3179H29.7702C29.6854 15.7355 29.2553 13.3062 28.5551 11.1451C25.801 11.542 23.0108 11.7429 20.2294 11.7809V18.3179ZM31.6826 18.3179H36.6096C36.4457 15.2957 35.5085 12.4792 33.993 10.0625C32.8734 10.3541 31.6905 10.6135 30.4548 10.8369C31.1658 13.115 31.5988 15.6468 31.6826 18.3179ZM18.3179 20.2294H8.77619C8.86201 22.8119 9.29112 25.2412 9.99232 27.4023C12.7464 27.0054 15.5366 26.8045 18.3179 26.7665V20.2294ZM6.86472 20.2294H1.9378C2.10164 23.2517 3.03885 26.0682 4.5534 28.4848C5.67298 28.1932 6.85594 27.9338 8.09255 27.7105C7.38062 25.4323 6.94859 22.9016 6.86472 20.2294ZM20.2294 1.98462V9.86944C22.7816 9.83335 25.3387 9.65683 27.8685 9.31257C26.4885 6.09038 23.9071 2.54343 20.2294 1.98462ZM18.3179 36.5628V28.6779C15.7648 28.714 13.2087 28.8905 10.6789 29.2358C12.0589 32.458 14.6403 36.0039 18.3179 36.5628ZM18.3179 9.86944V1.98462C14.6403 2.54343 12.0589 6.09038 10.6789 9.31257C13.2087 9.65683 15.7648 9.83335 18.3179 9.86944ZM26.3705 3.42407C27.8607 5.02932 28.9881 6.98955 29.8043 9.01318C30.8498 8.83276 31.8523 8.626 32.8061 8.39585C31.0858 6.25812 28.8759 4.54755 26.3705 3.42407ZM12.1759 35.1233C10.6857 33.5181 9.55931 31.5588 8.74206 29.5342C7.6966 29.7156 6.69503 29.9223 5.74124 30.1515C7.46157 32.2893 9.67049 33.9998 12.1759 35.1233ZM8.74206 9.01318C9.55931 6.98955 10.6857 5.02932 12.1759 3.42407C9.67049 4.54755 7.46157 6.25812 5.74124 8.39585C6.69503 8.626 7.6966 8.83276 8.74206 9.01318Z"/>
						<path fill-rule="evenodd" clip-rule="evenodd" d="M32.7983 32.7213L35.8372 36.9792C35.8879 37.0513 35.8713 37.1508 35.8001 37.2015L33.3211 38.9706C33.2499 39.0213 33.1504 39.0047 33.0987 38.9335L30.0599 34.6747L27.9485 36.1814C27.8558 36.2477 27.7271 36.1999 27.7007 36.0888L25.0851 25.0627C25.052 24.9242 25.2051 24.8159 25.3251 24.891L34.9019 30.9502C34.9975 31.0107 35.0014 31.1482 34.9087 31.2145L32.7983 32.7213Z"/>
						</svg>
				      <span>Site</span>
				      </div>
				      </a>
				    </li>
				    <c:if test="${not empty sessionScope.amap}">
				    <li class="nav-item">
						<a class="nav-link"
							href="${pageContext.request.contextPath}/amap/amaplogout">
							<div class="nav-item-container m-auto">
								<svg width="35" height="41" viewBox="0 0 35 41" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path d="M18.8985 40.9999H2.09984C0.944938 40.9999 0 40.055 0 38.9001V2.50291C0 1.34801 0.944938 0.403076 2.09984 0.403076H18.8985C20.0534 0.403076 20.9984 1.34801 20.9984 2.50291V9.50237C20.9984 9.88734 20.6834 10.2023 20.2984 10.2023C19.9134 10.2023 19.5985 9.88734 19.5985 9.50237V2.50291C19.5985 2.11794 19.2835 1.80297 18.8985 1.80297H2.09984C1.71486 1.80297 1.39989 2.11794 1.39989 2.50291V38.9001C1.39989 39.285 1.71486 39.6 2.09984 39.6H18.8985C19.2835 39.6 19.5985 39.285 19.5985 38.9001V31.9006C19.5985 31.5156 19.9134 31.2007 20.2984 31.2007C20.6834 31.2007 20.9984 31.5156 20.9984 31.9006V38.9001C20.9984 40.055 20.0534 40.9999 18.8985 40.9999Z" fill="black"/>
								<path d="M34.2973 21.4013H6.29951C5.91454 21.4013 5.59956 21.0864 5.59956 20.7014C5.59956 20.3164 5.91454 20.0014 6.29951 20.0014H32.6103L25.4079 12.7991C25.1349 12.5261 25.1349 12.0851 25.4079 11.8121C25.6809 11.5392 26.1219 11.5392 26.3948 11.8121L34.7942 20.2115C34.9971 20.4145 35.0531 20.7154 34.9481 20.9744C34.8432 21.2334 34.5842 21.4084 34.3042 21.4084L34.2973 21.4013Z" fill="black"/>
								<path d="M25.898 29.8008C25.716 29.8008 25.541 29.7308 25.401 29.5978C25.128 29.3248 25.128 28.8839 25.401 28.6109L33.8004 20.2116C34.0733 19.9386 34.5143 19.9386 34.7873 20.2116C35.0602 20.4846 35.0603 20.9255 34.7873 21.1985L26.3879 29.5978C26.2479 29.7378 26.073 29.8008 25.891 29.8008H25.898Z" fill="black"/>
								</svg>
								<span>Déconnexion</span>
							</div>
						</a></li>
				    </c:if>
				    
				    <c:choose>
						<c:when test="${amap.bannerColor != null}">
							<div id="mobile-nav-marker" style="background-color: ${amap.getBannerColor().toString()};"></div>
						</c:when>
						<c:otherwise>
							<div id="mobile-nav-marker" style="background-color: #DBDBDB;"></div>
						</c:otherwise>
					</c:choose>
		    </ul>
		</nav>

    <!-- Body -->
    <main class="container-fluid border">
    	<div class="mt-5">
        	<jsp:include page="/WEB-INF/views/${content}.jsp" />
        </div>
    </main>

    <!-- Footer -->
    
    <footer class="d-flex align-items-center justify-content-center" style="background-color: ${amap.bannerColor != null ? amap.bannerColor.toString() : '#DBDBDB'};">
        
        <div class="d-flex justify-content-between align-items-center w-100 h-100">
		    
		            <div class="logo-footer mb-5 col-md-3">
		                <div class="d-flex flex-column align-items-center">
		                <c:choose>
						        <c:when test="${amap.logoImgData != null}">
						            <img  class="mr-2" src="${pageContext.request.contextPath}/logoImg/${amap.id}" width="auto" height="150">
						        </c:when>
						        <c:otherwise>
						            <img  class="mr-2" src="${pageContext.request.contextPath}/resources/images/amap/defaultLogo.PNG" alt="LogoAmap" width="auto" height="150">
						        </c:otherwise>
						    </c:choose>
				    
		                    <h2 class="mt-2 text-dark">${amap.logoText}</h2>
		                </div>
		            </div>
		            
		            <div class="container-fluid col-12 col-md-9 p-5">
		            
				        <div class="col-12 row m-auto">
				            
				            <div class="col-md-3 mx-auto mb-3 width-250 text-centered">
				                <h5 class="text-dark mb-3">Coordonnées</h5>
				                <address>
				                    ${amap.address}<br>
				                    +33 ${amap.contactPhoneNum}<br>
				                    <a href="mailto:amaply-contact@gmail.com" class="text-dark">${amap.email}</a>
				                </address>
				            </div>
				            <div class="col-md-3 mx-auto mb-3 width-250 text-centered">
				                <h5 class="text-dark mb-3">Navigation</h5>
				                <ul class="list-unstyled">
				                	<li><a href="${pageContext.request.contextPath}/${linkName}/backoffice" class="text-dark">Accueil</a></li>
				                    <li><a href="${pageContext.request.contextPath}/${linkName}/members" class="text-dark">Les membres</a></li>
				                    <li><a href="${pageContext.request.contextPath}/${linkName}/statistics" class="text-dark">Statistiques</a></li>
				                    <li><a href="${pageContext.request.contextPath}/${linkName}/messages" class="text-dark">Messages</a></li>
				                    <li><a href="${pageContext.request.contextPath}/${linkName}" class="text-dark">Voir le site</a></li>
				                </ul>
				            </div>
				            <div class="col-md-3 mx-auto mb-3 width-250 text-centered">
				                <h5 class="text-dark mb-3">Des questions ?</h5>
				                <ul class="list-unstyled">
				                    <li><a href="#" class="text-dark">FAQ</a></li>
				                    <li><a href="#" class="text-dark">Conditions d'utilisation</a></li>
				                    <li><a href="#" class="text-dark">Conditions générales de vente</a></li>
				                    <li><a href="#" class="text-dark">Mentions légales</a></li>
				                </ul>
				            </div>
				            
				        </div>
				        <hr class="text-dark col-9">
				        <div class="text-center text-dark">
		            		<h6>Copyright © 2024 - Tous droits réservés</h6>
		        		</div>
		        	</div>
		        
		</div>
        
    </footer>
  
    <script src="${pageContext.request.contextPath}/resources/js/homeAmapScript.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/backofficeAmapScript.js"></script>
</body>
</html>
