<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Back Office</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-4.0.0/css/bootstrap.min.css">
</head>
<body>
<form action="#"action="@{/${linkName}/BackOfficeAmap}" method="post">
    <button type="submit" name="action" id="action" value="delete"> Supprimer l'abonnement</button>
    
</form>

</body>
</html>