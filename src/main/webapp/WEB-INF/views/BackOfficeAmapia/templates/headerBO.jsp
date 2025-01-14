<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="sidebar" class="sidebar open">
    <button class="toggle-btn" onclick="toggleSidebar()">☰</button>
    <nav>
        <a href="${pageContext.request.contextPath}/BackOffice/">
            <span>🏡</span>
            <span class="sidebar-text">Accueil</span>
        </a>
        <a href="AmapList">
            <span>📋</span>
            <span class="sidebar-text">Liste des AMAPs</span>
        </a>
        <a href="OrderList">
            <span>💶</span>
            <span class="sidebar-text">Facturation</span>
        </a>
        <a href="SupportContact">
            <span>✉️</span>
            <span class="sidebar-text">Support</span>
        </a>
        <a href="http://localhost:8080/AmapiaApp/home">
            <span>➡️</span>
            <span class="sidebar-text">Déconnexion</span>
        </a>
    </nav>
</div>


<script>
function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    sidebar.classList.toggle("closed");
}

window.addEventListener("resize", function () {
    const sidebar = document.getElementById("sidebar");
    if (window.innerWidth <= 768) {
        sidebar.classList.add("closed");
    } else {
        sidebar.classList.remove("closed");
    }
});

window.addEventListener("load", function () {
    const sidebar = document.getElementById("sidebar");
    if (window.innerWidth <= 768) {
        sidebar.classList.add("closed");
    } else {
        sidebar.classList.remove("closed");
    }
});

	
</script>
