
<main class="container-fluid border" style="height: 1000px; background-color: #FAFAFA;">
    <div class="d-flex" style="height: 100%;">
        <!-- Sidebar -->
        <div class="sidebar" id="sidebar">
            <ul>
                <li><a href="#" onclick="loadContent('${pageContext.request.contextPath}/account/infoProducer')">Mes informations</a></li>
                <li><a href="#" onclick="loadContent('${pageContext.request.contextPath}/account/listBaskets')">Mes paniers</a></li>
                <li><a href="#" onclick="loadContent('${pageContext.request.contextPath}/products')">Mes produits</a></li>
                <li><a href="#" onclick="loadContent('${pageContext.request.contextPath}/activities/activitiesList')">Mes ateliers</a></li>
            </ul>
        </div>

        <!-- Main Content -->
        <div class="main-content" id="main-content">
            <div class="toggle-btn-container">
                <button class="toggle-btn" onclick="toggleSidebar()">></button>
            </div>
            <div id="dynamic-content">
                <p>Bienvenue sur votre espace personnel.</p>
            </div>
        </div>
    </div>
</main>


<script>
    // Fonction pour basculer la barre latérale
    function toggleSidebar() {
        const sidebar = document.getElementById('sidebar');
        const mainContent = document.getElementById('main-content');
        const toggleBtnContainer = document.querySelector('.toggle-btn-container');

        sidebar.classList.toggle('active');
        mainContent.classList.toggle('sidebar-active');
        toggleBtnContainer.classList.toggle('sidebar-active');
    }

    // Fonction pour charger le contenu dynamique dans la div #dynamic-content
    function loadContent(url) {
        const dynamicContent = document.getElementById('dynamic-content');

        // Afficher un message de chargement
        dynamicContent.innerHTML = '<p>Chargement...</p>';

        // Effectuer une requête fetch pour récupérer le contenu
        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Erreur HTTP ! statut : ${response.status}`);
                }
                return response.text();
            })
            .then(data => {
                // Injecter le contenu dans la div #dynamic-content
                dynamicContent.innerHTML = data;
            })
            .catch(error => {
                console.error('Erreur lors du chargement du contenu :', error);
                dynamicContent.innerHTML = '<p>Une erreur est survenue. Veuillez réessayer.</p>';
            });
    }
</script>

<a class="btn btn-danger" href="${pageContext.request.contextPath}/${linkName}/deconnection">Déconnection</a>
   
<a href="${pageContext.request.contextPath}/activities/activitiesList" class="button">
    Gestion des activités
</a>  

