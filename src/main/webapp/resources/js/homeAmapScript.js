// Fixed navbar
document.addEventListener("DOMContentLoaded", () => {
    const header = document.getElementById("header");
    const navbar = document.getElementById("navbar");
    const main = document.querySelector("main");
    const headerHeight = header.offsetHeight;

    window.addEventListener("scroll", () => {
        if (window.scrollY >= headerHeight) {
            navbar.classList.add("fixed");
            if (main) {
                main.style.marginTop = `${navbar.offsetHeight}px`;
            }
        } else {
            navbar.classList.remove("fixed");
            if (main) {
                main.style.marginTop = '0';
            }
        }
    });
});

function setupNavMarker(navSelector, markerSelector) {
  const marker = document.querySelector(markerSelector);
  const items = document.querySelectorAll(`${navSelector} .nav-link`);

  function updateMarkerPosition(link) {
    const navItem = link.closest('.nav-item');
    let translateX = 0;
    let currentItem = navItem.previousElementSibling;

    while (currentItem) {
      translateX += currentItem.offsetWidth;
      currentItem = currentItem.previousElementSibling;
    }

    marker.style.transform = `translateX(${translateX}px)`;
    marker.style.width = `${navItem.offsetWidth}px`;
  }

  function setActiveLinkBasedOnUrl() {
    const currentUrl = window.location.pathname;
    items.forEach(link => {
      if (link.getAttribute("href") === currentUrl) {
        link.classList.add("active");
        updateMarkerPosition(link);
      } else {
        link.classList.remove("active");
      }
    });
  }

  function handleResize() {
    const activeLink = document.querySelector(`${navSelector} .nav-link.active`);
    if (activeLink) {
      updateMarkerPosition(activeLink);
    }
  }

  // Initial setup
  setActiveLinkBasedOnUrl();

  items.forEach(link => {
    link.addEventListener("click", function (e) {
      items.forEach(item => item.classList.remove("active"));
      e.target.classList.add("active");
      updateMarkerPosition(e.target);
    });
  });

  window.addEventListener("resize", handleResize);
}

// Setup for both desktop and mobile
document.addEventListener("DOMContentLoaded", () => {
  setupNavMarker("#navbar", "#nav-marker");
  setupNavMarker("#navbar-mobile", "#mobile-nav-marker");
});


