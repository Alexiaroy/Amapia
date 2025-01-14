<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<div class="mx-auto my-5 col-12 col-md-6 text-center py-5"
	style="background-color: #F9F8F1; border-radius: 20px;">
	<h4>
		Détails de la carte
		<button type="button" id="fill-card-info"
			class="btn btn-primary btn-sm ml-3">B</button>
	</h4>
	<div class="m-auto my-5 col-12" style="background-color: #F9F8F1;">
		<div class="mt-5 mb-2 container text-left">
			<div class="container mt-5">

				<div class="mb-3">
					<label for="card-name" class="form-label">Nom du
						propriétaire</label> <input id="card-name" class="form-control"
						placeholder="Entrez le nom du propriétaire" />
				</div>

				<div class="mb-3">
					<label for="card-number-element" class="form-label">Numéro
						de carte</label>
					<div id="card-number-element" class="StripeElement form-control"></div>
				</div>

				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="card-expiry-element" class="form-label">Date
							d'expiration</label>
						<div id="card-expiry-element" class="StripeElement form-control"></div>
					</div>
					<div class="col-md-6 mb-3">
						<label for="card-cvc-element" class="form-label">CVC</label>
						<div id="card-cvc-element" class="StripeElement form-control"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="card-errors" role="alert" class="text-danger m-auto"></div>

	<div class="mt-5">
		<hr class="col-6 m-auto mb-5">
		<div class="mt-5">
			<p>Forfait sélectionné : ${subscriptionName}</p>
			<p>Prix : ${subscriptionPrice} €</p>
		</div>
	</div>

	<div class="p-0 mt-5 mt-md-0">
		<button type="button" class="button-previous my-0" id="btn-step2">Retour</button>

		<button class="btn-next p-0" type="submit">Payer</button>
	</div>
</div>

<script>
   // Set your publishable key
   var stripe = Stripe('pk_test_51QXlJBEDYGlSY25e7hxHnozgTOhtSJ0TIFkRZPY6OIEsUJHPcRoJZ5yadfFlR21LEwWPJ3fXL1uNl5GXqreAxMHU00A9qrzewW');

   // Create an instance of Elements
   var elements = stripe.elements();

   const style = {
      base: {
        fontSize: '16px',
        color: '#495057',
        fontFamily: 'Arial, sans-serif',
        '::placeholder': { color: '#6c757d' }
      }
    };
   
    // Create an instance of the card Element
    const cardNumber = elements.create('cardNumber', { style });
	const cardExpiry = elements.create('cardExpiry', { style });
	const cardCvc = elements.create('cardCvc', { style });
	
	cardNumber.mount('#card-number-element');
	cardExpiry.mount('#card-expiry-element');
	cardCvc.mount('#card-cvc-element');


   // Handle real-time validation errors from the card Element
   [cardNumber, cardExpiry, cardCvc].forEach(element => {
	    element.on('change', function (event) {
	        const errorElement = document.getElementById('card-errors');
	        if (event.error) {
	            errorElement.textContent = event.error.message;
	        } else {
	            errorElement.textContent = '';
	        }
	    });
	});

   document.getElementById('fill-card-info').addEventListener('click', function() {
       document.getElementById('card-name').value = 'MME LISA MULLER';
   });

   // Handle form submission
   var form = document.getElementById('payment-form');
   form.addEventListener('submit', function (event) {
       event.preventDefault();

       stripe.createToken(card).then(function (result) {
           if (result.error) {
               // Inform the user if there was an error
               var errorElement = document.getElementById('card-errors');
               errorElement.textContent = result.error.message;
           } else {
               // Send the token to your server
               stripeTokenHandler(result.token);
           }
       });
   });

   // Submit the token to your server
   function stripeTokenHandler(token) {
       var form = document.getElementById('payment-form');
       var hiddenInput = document.createElement('input');
       hiddenInput.setAttribute('type', 'hidden');
       hiddenInput.setAttribute('name', 'token');
       hiddenInput.setAttribute('value', token.id);
       form.appendChild(hiddenInput);

       // Submit the form
       form.submit();
   }
</script>


