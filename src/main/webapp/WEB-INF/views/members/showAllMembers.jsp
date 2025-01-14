<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Membres</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/amaptablestyles.css">
</head>
<body>

<div class="container-fluid p-4">

<div class="container-fluid mb-5">
	<div class="col-10 m-auto mb-5">
	    <h2 class="text-center mb-5">Liste des membres</h2>
	
	    <table class="table text-center table-hover">
	        <thead class="bg-primary">
	            <tr class="text-white">
	                <th>Prénom</th>
	                <th>Nom</th>
	                <th>Email</th>
	                <th>Type</th>
	                <th>Status du compte</th>
	                <th>Modifier</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach var="member" items="${members}">
	                <tr>
	                    <td>${member.firstName}</td>
	                    <td>${member.lastName}</td>
	                    <td>${member.email}</td>
	                    <td>${member.memberType.toString()}</td>
	                    <td>
						    <span class="status-circle ${member.accountStatus ? 'green' : 'red'}"></span>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/${amap.linkName}/update/${member.member_id}">modif</a>
						</td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	</div>
</div>
</div> 
</body>
</html>
