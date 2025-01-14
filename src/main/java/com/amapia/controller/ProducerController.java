package com.amapia.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amapia.entity.Amap;
import com.amapia.entity.Basket;
import com.amapia.entity.Member;
import com.amapia.entity.Producer;
import com.amapia.entity.Subscription;
import com.amapia.service.AmapAccountService;
import com.amapia.service.BasketService;
import com.amapia.service.MemberService;
import com.amapia.service.ProducerService;
import com.amapia.service.SubscriptionService;

/**
 * This class handles user interactions with the interface (and so the database)
 * regarding the producers only for now. It bounds the back-end to the front-end and will be optimized later.
 * 
 * ProducerController allows a producer to register through a form and get redirected to the homePage afterward.
 * 
 * @author Siham
 * 
 * TODO: Retrieve producer by ID if needed in the next implementation phase.
 * 		 Producer producer = producerService.findById(id);
 * 		 Currently unused, but kept for future logic.
 */

@Controller
@RequestMapping("/")
public class ProducerController {

	@Autowired
	private AmapAccountService amapAccountService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private ProducerService producerService;
	@Autowired
	private SubscriptionService subService;
	@Autowired
	private BasketService basketService;

//	/*Redirects the user to the home page*/
//	@GetMapping
//	public String redirectToHome(@PathVariable String linkName) {
//		return "redirect:/{linkName}/home";
//	}

	/*Request to get the registration form*/
	@GetMapping("/{linkName}/producers/register")
	public String registerFormProducer(@PathVariable String linkName, Model model) {
		Amap amap = amapAccountService.findByLinkName(linkName);
		model.addAttribute("amap", amap);
		model.addAttribute("member", new Member());		// Empty member for the form
		model.addAttribute("producer", new Producer()); // Empty producer for the form
		return "Producer/RegistrationForm"; // Redirection to the form
	}
	
	/*Request to get the list of all the registered producers*/
	@GetMapping("/{linkName}/allProducers")
	public String ShowAllProducersList(@PathVariable String linkName,Model model) {
		Amap amap = amapAccountService.findByLinkName(linkName);
		 model.addAttribute("producers", producerService.findAll()); // List of  existing producers for a specific amap
		 return "Producer/ProducersList"; // Redirection to the view List located in views/Producer/ProducersList
	}
	
	
	/*Request to redirect the user to the update form view using their id*/
	 @GetMapping("/{linkName}/{producer_id}/updateProfile")
	    public String showUpdateForm(@PathVariable String linkName,@PathVariable Long producer_id, Model model) {
		 Amap amap = amapAccountService.findByLinkName(linkName);
		 Producer producer = producerService.findById(producer_id);
		 model.addAttribute("producer", producer);
		 
	        return "Producer/UpdateProducer"; 
	    }
	 
	 /*PostMethod to implement in order to submit the updated form and save changes*/
	 
	 @PostMapping("/{linkName}/{producer_id}/updateProfile")
	 public String updateProducer(@PathVariable String linkName,@PathVariable Long producer_id,
			    @RequestParam Long id,
			    @RequestParam Long amapId,
			    @RequestParam String lastName, 
			    @RequestParam String firstName, 
			    @RequestParam String address,
			    @RequestParam String producerCompanyName,
			    @RequestParam String producerSiret, 
			    Model model) {
		
		 
		 Amap amap = amapAccountService.findById(amapId);
		 Member member = memberService.findById(id);
		 Producer producer = producerService.findById(producer_id);
		 model.addAttribute("producer", producer);
		
		 member.setAmap(amap);
		 member.setFirstName(firstName);
		 member.setLastName(lastName); 
		 member.setAddress(address);
		 producer.setProducerCompanyName(producerCompanyName);
		 producer.setProducerSiret(producerSiret);
		  
		 memberService.save(member);
		 producerService.save(producer);
		 
		 return "redirect:/{linkName}/allProducers";
	 }
	
	 
	 /*Request to send the form data to the database to create and save a new producer. */
	@PostMapping("/{linkName}/register")
	
	/*The @RequestParam allows the program to retrieve the input information given by the user through the form*/
	public String saveProducer(@PathVariable String linkName,@RequestParam Long amapId,@RequestParam String lastName, @RequestParam String firstName, @RequestParam String email,
			@RequestParam String password,@RequestParam String pwdConfirmation,/*,@RequestParam String phoneNumber,*/ @RequestParam String address,@RequestParam String producerCompanyName,
			@RequestParam String producerSiret, Model model) {
		

		/*Password verification method*/
		if(!password.equals(pwdConfirmation)) {
			model.addAttribute("errorMessage","Les mots de passe ne sont pas identiques. Merci de réessayer.");
			return "Producer/RegistrationForm";
		}
		
		// Find the amap based on it's registered id
		Amap amap = amapAccountService.findById(amapId);
	
		// Set Member attributes with user input from the form
		Member member = new Member();
		member.setAmap(amap);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setEmail(email);
	  /*member.setPhoneNumber(phoneNumber);*/
		member.setPassword(password);
		member.setAddress(address);
		member.setDateCreated(new Date());
		member.setDateLastModified(new Date());
		
		
		// Set producer attributes with user input from the form
		Producer producer = new Producer();
		producer.setProducerCompanyName(producerCompanyName); 
		producer.setProducerSiret(producerSiret); 
		member.setProducer(producer);

		memberService.save(member);
		
		
		return "Producer/confirmation"; // Redirection to a confirmation page 
	}
	/////////// Gestion des abonnements paniers 
	
	@GetMapping("/{linkName}/{producer_id}/CreateBasket")
	public String showCreateSubscription(@PathVariable String linkName,@PathVariable Long producer_id, Model model) {
		 Producer producer = producerService.findById(producer_id);
		 model.addAttribute("producer", producer);
		return "Producer/CreateBasket";
		
	}
//	@PostMapping("/{linkName}/{producer_id}//CreateBasket")
//	public String CreateBasket(@PathVariable String linkName,@PathVariable Long producer_id, Model model,@RequestParam Long amapId,@RequestParam String BasketName, @RequestParam double price,@RequestParam String Description,@RequestParam int stock  ) {
//		 Producer producer = producerService.findById(producer_id);
//		 model.addAttribute("producer", producer);	 
//		 Basket basket = new Basket();
//		 basket.setProducer(producer);
//			basket.setStock(stock);
//			basket.setActive(true);
//			basket.setDescription(Description);
//			basket.setName(BasketName);
//			basket.setPrice(price);
//			basket.setPublished(true);
//		 basketService.save(basket);
//	
//		 return "Producer/confirmation";
//	}
	
//	 @GetMapping("/{linkName}/{producer_id}/{basket_id}/UpdateBasket")
//	    public String showBasketUpdateForm(@PathVariable String linkName,@PathVariable Long producer_id, @PathVariable Long basket_id, Model model) {
//		 Producer producer = producerService.findById(producer_id);
//		 Optional<Basket> basket = basketService.getBasketById(basket_id);
//		 Basket basketA = basket.get();
//		 model.addAttribute("producer", producer);
//		 model.addAttribute("basket", basketA);
//	        return "Producer/UpdateBasket"; 
//	    }
//		@PostMapping("/{linkName}/{producer_id}/{Basket_id}/UpdateBasket")
//		public String UpdateBasket(@PathVariable String linkName,@PathVariable Long producer_id, @PathVariable Long basket_id, Model model,@RequestParam String BasketName, @RequestParam double price,@RequestParam String description,@RequestParam int stock  ) {
//		
//			Basket basket = new Basket();
//			basket.setActive(true);
//			basket.setDescription(description);
//			basket.setName(BasketName);
//			basket.setPrice(price);
//			 Producer producer = producerService.findById(producer_id);
//			basket.setProducer(producer);
//			basket.setStock(stock);
//			basket.setPublished(true);
//			basketService.updateBasket(basket_id, basket);
//			 return "Producer/confirmation";
//		}
		 @GetMapping("/{linkName}/{producer_id}/ShowBaskets")
		    public String showSubList(@PathVariable String linkName,@PathVariable Long producer_id, Model model) {
			 Producer producer = producerService.findById(producer_id);

			 model.addAttribute("producer", producer);
			 model.addAttribute("baskets",  basketService.getPublishedBasketsByProducerId(producer_id));
		        return "Producer/ShowBaskets"; 
		    }
//		 @PostMapping("/{linkName}/{producer_id}/ShowBaskets")
//		 public String CancelBasket(@PathVariable String linkName,@PathVariable Long producer_id, Model model, @RequestParam Long basket_id) {
//			 Producer producer = producerService.findById(producer_id);
//			 Optional<Basket> basket = basketService.getBasketById(basket_id);
//			 Basket basketA = basket.get();
//			 basketA.setPublished(false);
//			 return "Producer/ShowBaskets"; 
//		 }

}
