<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Liste des produits</h2>

<c:if test="${not empty successMessage}">
    <div style="color: green; margin-bottom: 20px;">
        ${successMessage}
    </div>
</c:if>

<div id="product-list">
    <c:forEach var="product" items="${products}">
        <p>${product.name} - ${product.price}€</p>
    </c:forEach>
</div>

<div id="product-form" style="margin-top: 20px;">
    <h3>Créer un produit</h3>
    <form action="${pageContext.request.contextPath}/products/create" method="post" enctype="multipart/form-data">
        <label>Nom :</label>
        <input type="text" name="name" required /><br />
        <label>Description :</label>
        <textarea name="description" required></textarea><br />
        <label>Prix :</label>
        <input type="number" name="price" step="0.01" required /><br />
        <label>Stock :</label>
        <input type="number" name="stock" required /><br />
        <label>Image :</label>
        <input type="file" name="imageFile" /><br />
        <button type="submit">Créer</button>
    </form>
</div>
