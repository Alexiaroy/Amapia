<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	<div class="d-flex flex-wrap justify-content-center" style="gap: 30px; margin-bottom: 100px;">
		<c:forEach var="product" items="${products}">
		<div class="card" style="width: 18rem;">
		  <img src="${pageContext.request.contextPath}/productImage/${product.id}" style="height: 300px; object-fit:cover;" class="card-img-top" alt="${product.imageName}">
		   <h5 class="card-title p-3">${product.name}</h5>
		  <div class="card-body d-flex flex-column justify-content-end">
		    <p class="card-text">${product.price} €</p>
		  </div>
		</div>
		</c:forEach>
	</div>
</div>