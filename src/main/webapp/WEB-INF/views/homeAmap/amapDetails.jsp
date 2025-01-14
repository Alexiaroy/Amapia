<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Détails de l'Amap</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/amapformstyles.css">
</head>
<body>
<div class="container-fluid p-4">
    <div class="mb-4">
        <a href="${pageContext.request.contextPath}/${amap.linkName}/backoffice" class="text-decoration-none" style="color: #000;">&lt; Retourner au backoffice</a>
    </div>

    <div class="container-fluid p-0 col-10 col-md-4 col-lg-2">
        <h2 class="text-center mb-4">Détails de votre Amap</h2>
        <div class="line mx-auto mb-4"></div>
    </div>

    <c:if test="${not empty success}">
        <p class="text-success">${success}</p>
    </c:if>
    <c:if test="${not empty error}">
        <p class="text-danger">${error}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/${amap.linkName}/details/update" method="post">
        <div class="container-fluid p-0">
            <div class="row col-12 col-md-10 m-auto p-0">
                <div class="col-12 col-md-6">
                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <label for="name">Nom</label>
                            <input type="text" class="form-control" id="name" name="name" value="${amap.name}" required>
                        </div>
                        <div class="form-group col-md-12">
                            <label for="address">Adresse</label>
                            <input type="text" class="form-control" id="address" name="address" value="${amap.address}" required>
                        </div>
                        <div class="form-group col-md-12">
                            <label for="contactName">Nom du contact</label>
                            <input type="text" class="form-control" id="contactName" name="contactName" value="${amap.contactName}" required>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-md-6">
                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <label for="contactFirstname">Prénom du contact</label>
                            <input type="text" class="form-control" id="contactFirstname" name="contactFirstname" value="${amap.contactFirstname}" required>
                        </div>
                        <div class="form-group col-md-12">
                            <label for="contactPhoneNum">Téléphone</label>
                            <input type="text" class="form-control" id="contactPhoneNum" name="contactPhoneNum" value="${amap.contactPhoneNum}" required>
                        </div>
                        <div class="form-group col-md-12">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="${amap.email}" required>
                        </div>
                        <div class="form-group col-md-12">
                            <label for="amapSiret">SIRET</label>
                            <input type="text" class="form-control" id="amapSiret" name="amapSiret" value="${amap.amapSiret}" required>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="text-center">
            <button type="submit" class="btn col-10 col-md-4 mt-4 bg-info bg-gradient text-light">Mettre à jour</button>
        </div>
    </form>
</div>
</body>
</html>

