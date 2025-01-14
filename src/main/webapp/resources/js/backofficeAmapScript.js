// countdown

document.addEventListener("DOMContentLoaded", () => {
  const lastPaymentDateString = document.getElementById("lastPaymentDate").getAttribute("data-last-payment");
  const lastPaymentDate = new Date(lastPaymentDateString.replace(" ", "T"));
	
  const countdownElement = document.getElementById(`countdown`);
  
  function updateCountdown() {
    const now = new Date();
    const oneMonthLater = new Date(lastPaymentDate);
    oneMonthLater.setMonth(lastPaymentDate.getMonth() + 1);

    const timeDifference = oneMonthLater - now;

    if (timeDifference > 0) {
      const days = Math.floor(timeDifference / (1000 * 60 * 60 * 24));
      const hours = Math.floor((timeDifference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      const minutes = Math.floor((timeDifference % (1000 * 60 * 60)) / (1000 * 60));
      const seconds = Math.floor((timeDifference % (1000 * 60)) / 1000);

      countdownElement.textContent = `${days}j ${hours}h ${minutes}m ${seconds}s restants`;
    } else {
      countdownElement.textContent = "Le délai est écoulé.";
    }
  }

  updateCountdown();
  setInterval(updateCountdown, 1000);
});

// compteurs
document.addEventListener("DOMContentLoaded", () => {
  const initCharCount = (textAreaId, charCountId, maxLength) => {
    const textArea = document.getElementById(textAreaId);
    const charCount = document.getElementById(charCountId);

    if (!textArea || !charCount) {
      console.error(`Élément introuvable : ${textAreaId} ou ${charCountId}`);
      return;
    }

    const updateCharCount = () => {
      const textLength = textArea.value.length;

      // Mettre à jour le compteur
      charCount.textContent = `${textLength} / ${maxLength} caractères`;

      // Si le texte dépasse la limite, le couper
      if (textLength > maxLength) {
        textArea.value = textArea.value.substring(0, maxLength);
        charCount.textContent = `${maxLength} / ${maxLength} caractères`;
      }
    };

    // Ajouter un écouteur pour l'événement "input"
    textArea.addEventListener("input", updateCharCount);

    // Mettre à jour le compteur au chargement
    updateCharCount();
  };

  // Initialiser les compteurs
  initCharCount("news", "newsCharCount", 1000);
  initCharCount("aboutSectionText", "aboutSectionTextCharCount", 2000);
  initCharCount("subSectionText", "subSectionCharCount", 1000);
});


// Prévisualisation de l'image
function previewImage(event, previewElementId) {
    const file = event.target.files[0];
    const reader = new FileReader();

    reader.onload = function () {
        const imagePreview = document.getElementById(previewElementId);
        const img = document.createElement('img');
        img.src = reader.result;

        img.style.maxWidth = '100%';
        img.style.height = 'auto';
        img.style.objectFit = 'contain';

        imagePreview.innerHTML = '';
        imagePreview.appendChild(img);
    };

    if (file) {
        reader.readAsDataURL(file);
    }
}

// banner image input
function toggleBannerImageInput() {
  const bannerYes = document.getElementById("bannerYes").checked;
  const bannerImageSection = document.getElementById("bannerImageSection");

 if (bannerYes) {
    bannerImageSection.style.display = "block";
  } else {
    bannerImageSection.style.display = "none";
  }
}

document.addEventListener("DOMContentLoaded", function() {
  toggleBannerImageInput();
});


