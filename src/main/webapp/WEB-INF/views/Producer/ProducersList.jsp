<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Liste des producteurs inscrits</title>
</head>
<body>

	<table>
        <thead>
            <tr>
            	<th>id</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>Adresse</th>
                <th>Nom l'exploitation</th>
                <th>Siret</th>      
            </tr>
        </thead>
        <tbody>
            <c:forEach var="producer" items="${producers}">
                <tr>
                	<td>${producer.producer_id}</td>
                    <td>${producer.member.lastName}</td>
                    <td>${producer.member.firstName}</td> 
                    <td>${producer.member.email}</td>
                    <td>${producer.member.address}</td>
                    <td>${producer.producerCompanyName}</td>
                    <td>${producer.producerSiret}</td>
                    <td>
                    <a href="${pageContext.request.contextPath}/producers/updateProfile/${producer.producer_id}">
                    <button type="button">Modifier</button>
                    </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
    
    <a href="${pageContext.request.contextPath}/producers">Retour à
		l'accueil</a>
</body>
</html>