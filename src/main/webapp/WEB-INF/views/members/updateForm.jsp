<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="fr">
<html>

<html lang="en">


<head>
<meta charset="UTF-8">
<title>Inscription entreprise</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/amapformstyles.css">

<script>
    function validateForm(event) {
        const password = document.getElementById("password").value;
        const confirmPassword = document.getElementById("confirmPassword").value;
        const errorMessage = document.getElementById("passwordError");

        if (password !== confirmPassword) {
            errorMessage.textContent = "Les mots de passe ne correspondent pas.";
            errorMessage.style.display = "block";
            event.preventDefault();
        } else {
            errorMessage.style.display = "none";
        }
    }
</script>

</head>
<body>

<div class="container-fluid p-4">

<div class="mb-4">
   <a href="${pageContext.request.contextPath}/${amap.linkName}/members" class="text-decoration-none" style="color: #000;">&lt; Retourner à la liste des membres</a>
</div>

<div class="container-fluid p-0">      

<div class="container-fluid p-0 col-10 col-md-4 col-lg-2">
<h2 class="text-center mb-4">Inscription</h2>
<div class="line mx-auto mb-4"></div>
</div>

<form action="${pageContext.request.contextPath}/${amap.linkName}/update_${signupType.toLowerCase()}/${member.member_id}" method="post" onsubmit="validateForm(event)">


<div class="container-fluid p-0">		
<div class="row col-12 col-md-10 m-auto p-0">
        <!-- Left part -->
        <div class="col-12 col-md-6">
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="firstName">Nom</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" value="${member.firstName}" required>
                </div>
                <div class="form-group col-md-12">
                    <label for="lastName">Prénom</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${member.lastName}" required>
                </div>
                <div class="form-group col-md-12">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email" value="${member.email}" required>
                </div>
                
            </div>
        </div>

        <!-- Right part -->
        <div class="col-12 col-md-6">
            <div class="form-row">
            	<div class="form-group col-md-12">
                    <label for="address">Adresse</label>
                    <input type="text" class="form-control" id="address" name="address" value="${member.address}" required>
                </div>
                <div class="form-group col-md-12">
                    <label for="phoneNumber">Numéro de téléphone</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${member.phoneNumber}" required>
                </div>
            	<!-- If it is an enterprise signup -->
            	<c:if test="${signupType == 'ENTERPRISE'}">
	            	<div class="form-group col-md-12">
	                    <label for="companyName">Nom de l'entreprise</label>
	                    <input type="text" class="form-control" id="companyName" name="companyName" value="${enterprise.companyName}" required>
	                </div>
	                <div class="form-group col-md-12">
	                    <label for="numberOfEmployees">Nombre d'employés</label>
	                    <input type="number" class="form-control" id="numberOfEmployees" name="numberOfEmployees" value="${enterprise.numberOfEmployees}" required>
	                </div>
                </c:if>
               <!-- If it is a producer signup -->
            	<c:if test="${signupType == 'PRODUCER'}">
	            	<div class="form-group col-md-12">
	                    <label for="producerCompanyName" class="form-label">Nom de l'entreprise</label>
	                    <input type="text" class="form-control" id="producerCompanyName" name="producerCompanyName" value="${producer.producerCompanyName}" required>
	                </div>
	                <div class="form-group col-md-12">
	                    <label for="producerSiret" class="form-label">Siret</label>
	                    <input type="text" class="form-control" id="producerSiret" name="producerSiret" value="${producer.producerSiret}" required>
	                </div>
                </c:if>
                <!-- If it is a volunteer signup -->
            	<c:if test="${signupType == 'VOLUNTEER'}">
				    <label class="form-label">Actif :</label>
				    <div class="form-check">
				        <input type="radio" id="activeYes" name="active" 
				            value="true" 
				            ${volunteer.isActive() ? 'checked' : ''} 
				            class="form-check-input">
				        <label for="activeYes" class="form-check-label">Oui</label>
				    </div>
				    <div class="form-check">
				        <input type="radio" id="activeNo" name="active" 
				            value="false" 
				            ${!volunteer.isActive() ? 'checked' : ''} 
				            class="form-check-input">
				        <label for="activeNo" class="form-check-label">Non</label>
				    </div>
				</c:if>
            </div>
        </div>
    </div>
</div>

<div class="text-center">   
	<button type="submit" class="btn btn-primary col-10 col-md-4 mt-4">Valider</button>
</div>
</form>
</div>  
</div> 
</body>
</html>