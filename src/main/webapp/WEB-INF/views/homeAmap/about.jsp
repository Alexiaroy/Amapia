<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<c:if test="${amap.aboutSectionTitle !=null }">
		<h2 class="text-center" style="margin: 50px 0 60px 0">${amap.aboutSectionTitle}</h2>
	</c:if>
	<div class="d-flex justify-content-evenly align-items-center flex-wrap">
		<c:if test="${amap.aboutSectionImgData !=null }">
			<img style="max-width: 500px; min-width: 200px; height: auto;"
				src="${pageContext.request.contextPath}/aboutSectionImg/${amap.id}">
		</c:if>
		<c:if test="${amap.aboutSectionText !=null }">
			<p class="mt-5 mt-md-0" style="width: 500px;" id="aboutSectionText">${amap.aboutSectionText}</p>
		</c:if>
	</div>
	<hr>
	<div
		class="d-flex flex-column align-items-center justify-content-start" style="margin-bottom : 100px;">
		<c:if test="${amap.subSectionTitle !=null }">
			<h3 class="text-center" style="margin: 50px 0 30px 0">${amap.subSectionTitle}</h3>
		</c:if>
		<c:if test="${amap.subSectionText !=null }">
			<p class="text-center" id="subSectionText">${amap.subSectionText}</p>
		</c:if>
	</div>
</div>


<script>
	// Change \n into <br>
	let subSectionText = `${amap.subSectionText}`;
	let aboutSectionText = `${amap.aboutSectionText}`;

	let formattedaboutSectionText = aboutSectionText.replace(/\n/g, '<br>');
	let formattedsubSectionText = subSectionText.replace(/\n/g, '<br>');

	document.getElementById('aboutSectionText').innerHTML = formattedaboutSectionText;
	document.getElementById('subSectionText').innerHTML = formattedsubSectionText;
</script>
