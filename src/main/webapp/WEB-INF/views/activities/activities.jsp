<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	<div class="d-flex flex-wrap justify-content-center" style="gap: 30px; margin-bottom: 100px;">
		<c:forEach var="activity" items="${activities}">
			<div class="card" style="width: 18rem; margin-left: 5px;">
				<img src="${pageContext.request.contextPath}/activityImage/${activity.activity_id}" style="height: 350px; object-fit:cover;" class="card-img-top" alt="...">
				<h5 class="card-title p-3">${activity.activityName}</h5>
				<div class="card-body d-flex flex-column justify-content-end">
					<p class="card-text">${activity.price} €</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>