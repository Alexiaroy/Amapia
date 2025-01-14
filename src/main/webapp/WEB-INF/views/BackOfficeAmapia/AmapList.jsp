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
    href="${pageContext.request.contextPath}/resources/css/amapbackofficestyles.css">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/amaplayoutstyles.css">
<link href="<c:url value='/resources/css/AmapiaBONavBar.css'/>"
    rel="stylesheet">
<title>Liste des Amaps</title>

<style>
.table-container {
    width: 100%;
    overflow-x: auto;
    margin-left: 190px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

table th, table td {
    text-align: left;
    padding: 10px;
    border: 1px solid #ddd;
    background-color: white;
}

.cards {
    display: none;
}

@media (max-width: 768px) {
    table {
        display: none; 
    }
    .cards {
        display: flex;
        flex-direction: column;
        gap: 15px;
        margin-left: 40px;
    }
    .card {
        border: 1px solid #ddd;
        border-radius: 8px;
        box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        background-color: #fff;
    }
    .card-header {
        display: flex;
        flex-direction: column;
        margin-bottom: 10px;
    }
    .card-header h5 {
        margin: 0;
        font-size: 16px;
        font-weight: bold;
    }
    .card-header small {
        margin-top: 5px;
        font-size: 12px;
        color: gray;
    }
    .card-body {
        font-size: 14px;
    }
}
</style>
</head>
<body>

    <div class="container d-flex flex-column align-items-center justify-content-center">
        <h2 class="text-center mb-5">Liste des Amaps</h2>

        <!-- Desktop -->
        <div class="table-container">
            <table class="table">
                <thead>
                    <tr>
                        <th>Nom de l'Amap</th>
                        <th>Email</th>
                        <th>Contact</th>
                        <th>Abonnement</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="amap" items="${amaps}">
                        <tr>
                            <td>${amap.name}</td>
                            <td>${amap.email}</td>
                            <td>${ amap.contactFirstname } ${amap.contactName}</td>
                            <td>${amap.subscription.subscriptionName}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Mobile -->
        <div class="cards">
            <c:forEach var="amap" items="${amaps}">
                <div class="card">
                    <div class="card-header">
                        <h5>${amap.name}</h5>
                        <small>${amap.email}</small>
                    </div>
                    <div class="card-body">
                        <p>Contact: ${ amap.contactFirstname } ${amap.contactName}</p>
                        <p>Abonnement: ${amap.subscription.subscriptionName}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <jsp:include
        page="/WEB-INF/views/BackOfficeAmapia/templates/headerBO.jsp" />

</body>
</html>
