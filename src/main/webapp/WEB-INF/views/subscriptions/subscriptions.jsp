<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	<div class="d-flex flex-wrap justify-content-center" style="gap: 30px; margin-bottom: 100px;">
		<c:forEach var="basket" items="${baskets}">
		<div class="card" style="width: 18rem;">
		  <img src="${pageContext.request.contextPath}/basketImage/${basket.id}" style="height: 300px; object-fit:cover;" class="card-img-top" alt="${basket.imageName}">
		   <h5 class="card-title p-3">${basket.name}</h5>
		  <div class="card-body d-flex flex-column justify-content-end">
		    <p class="card-text">${basket.price} €</p>
		  </div>
		</div>
		</c:forEach>
	</div>

</div>
