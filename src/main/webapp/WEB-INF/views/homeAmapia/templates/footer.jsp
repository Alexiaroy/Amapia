<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<footer>
    <div class="container mt-5">
        <div class="row">
            <!-- Logo column -->
            <div class="col-12 col-lg-3 footer-logo">
                <img class="logo-img" src="<c:url value='/resources/images/logo-footer.svg'/>" alt="logo">
            </div>

            <!-- Coordinates column -->
            <div class="col-12 col-lg-3 footer-coordinates">
                <h3>Coordonnées</h3>
                <p>18 Avenue des Ternes 75017 Paris, France</p>
                <p>+33 01 15 46 23 78</p>
                <p>contact.amapia@gmail.com</p>
            </div>

            <!-- Navigation column -->
            <div class="col-12 col-lg-3 footer-nav">
                <h3>Navigation</h3>
                <a href="#">Accueil</a> <a href="#">Les fonctionnalités</a> <a href="#">Les forfaits</a> <a href="#">Contact</a>
            </div>

            <!-- Info column -->
            <div class="col-12 col-lg-3 footer-info">
                <h3>Des questions ?</h3>
                <a href="#">FAQ</a> <a href="#">Conditions générales</a> <a href="#">Mentions légales</a>
            </div>
        </div>
        <hr>

        <!-- Copyright section -->
        <div class="text-center footer-info">
            <p>Copyright © 2024 - Tous droits réservés</p>
        </div>
    </div>
</footer>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
