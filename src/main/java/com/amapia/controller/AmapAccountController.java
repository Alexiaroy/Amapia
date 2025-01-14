package com.amapia.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.amapia.entity.Admin;
import com.amapia.entity.Amap;
import com.amapia.entity.ChargeRequest;
import com.amapia.entity.Order;
import com.amapia.entity.SignupSession;
import com.amapia.entity.Subscription;
import com.amapia.entity.ChargeRequest.Currency;
import com.amapia.service.AdminService;
import com.amapia.service.AmapAccountService;
import com.amapia.service.OrderService;
import com.amapia.service.StripeService;
import com.amapia.service.SubscriptionService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
@RequestMapping("/amap")
public class AmapAccountController {
	@Autowired
	private StripeService paymentsService;
	private final AmapAccountService amapAccountService;
	private final SubscriptionService subscriptionService;
	private final OrderService orderService;
	private final AdminService adminService;

	public AmapAccountController(AmapAccountService amapAccountService, SubscriptionService subscriptionService,
			OrderService orderService, AdminService adminService) {
		this.amapAccountService = amapAccountService;
		this.subscriptionService = subscriptionService;
		this.orderService = orderService;
		this.adminService = adminService;
	}

	@GetMapping("/signup")
	public String signupForm(Model model, HttpSession session) {
		SignupSession signupSession = (SignupSession) session.getAttribute("signupSession");
		if (signupSession == null) {
			signupSession = new SignupSession();
			session.setAttribute("signupSession", signupSession);
		}
		model.addAttribute("step", 1);
		model.addAttribute("subscriptions", subscriptionService.findAll());
		model.addAttribute("signupSession", signupSession);
		model.addAttribute("amap", new Amap());
		return "homeAmapia/signup";
	}

	@PostMapping("/signup")
	public String handleFormSubmission(@RequestParam(required = false) Integer step,
			@RequestParam(required = false) Long subscriptionId,
			@RequestParam(required = false) String subscriptionName,
			@RequestParam(required = false) BigDecimal subscriptionPrice, HttpServletRequest request,
			HttpSession session, @RequestParam(required = false) String password, @ModelAttribute Amap amap,
			@ModelAttribute Order order, Model model, ChargeRequest chargeRequest) throws StripeException {
		SignupSession signupSession = (SignupSession) session.getAttribute("signupSession");
		if (signupSession == null) {
			signupSession = new SignupSession();
			session.setAttribute("signupSession", signupSession);
		}

		if (step == 1) {

			Subscription subscription = subscriptionService.findById(subscriptionId);

			model.addAttribute("subscriptions", subscriptionService.findAll());
			model.addAttribute("subscriptionId", subscriptionId);
			model.addAttribute("subscriptionName", subscription.getSubscriptionName());
			model.addAttribute("subscriptionPrice", subscription.getPrice());
			model.addAttribute("amap", amap);
			model.addAttribute("step", 1);
			model.addAttribute("step", 2);
			return "homeAmapia/signup";
		}

		if (step == 2) {

			if (subscriptionId == null) {
				model.addAttribute("subscriptions", subscriptionService.findAll());
				model.addAttribute("step", 1);
				return "homeAmapia/signup";
			}
			model.addAttribute("amap", amap);
			signupSession.setPassword(password);
			model.addAttribute("subscriptionId", subscriptionId);
			model.addAttribute("subscriptionName", subscriptionName);
			model.addAttribute("subscriptionPrice", subscriptionPrice);
			model.addAttribute("step", 2);
			model.addAttribute("step", 3);

			return "homeAmapia/signup";
		}

		if (step == 3) {
			Subscription subscription = subscriptionService.findById(subscriptionId);
			order = orderService.GenerateOrderSubAmapia(subscriptionPrice.doubleValue());
			// Si erreur
			if (subscriptionId == null) {
				model.addAttribute("error", "Erreur : aucun forfait sélectionné.");
				model.addAttribute("subscriptions", subscriptionService.findAll());
				model.addAttribute("step", 1);
				return "homeAmapia/signup";
			}

			model.addAttribute("subscriptions", subscriptionService.findAll());
			model.addAttribute("subscriptionId", subscriptionId);
			model.addAttribute("subscriptionName", subscriptionName);
			model.addAttribute("subscriptionPrice", subscriptionPrice);
			model.addAttribute("amap", amap);
			amap.setPassword(signupSession.getPassword());
			model.addAttribute("step", 1);
			model.addAttribute("step", 2);
			model.addAttribute("step", 3);
			amap.setSubscription(subscription);
			amap.setSubLastPaymentDate(new Date());
			amap.setDateCreated(new Date());
			
			order.setAmap(amap);
			order.setStatus(true);
			amapAccountService.save(amap);
			orderService.save(order);
			String linkName = amap.getLinkName();

			chargeRequest.setDescription("Example charge");
			chargeRequest.setCurrency(Currency.EUR);
			Charge charge = paymentsService.charge(chargeRequest);
			model.addAttribute("id", charge.getId());
			model.addAttribute("status", charge.getStatus());
			model.addAttribute("chargeId", charge.getId());
			model.addAttribute("balance_transaction", charge.getBalanceTransaction());

			return "redirect:homeAmapia/login";
		}

		return "homeAmapia/signup";
	}

	@GetMapping("/login")
	public String loginForm() {

		return "homeAmapia/login";
	}

	@PostMapping("/login")
	public String handleLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		if ("contact.amapia@gmail.com".equalsIgnoreCase(email.trim())) {
			Admin admin = adminService.authenticate(email, password);
			if (admin != null) {
				return "redirect:/BackOffice/";
			}
		}else {
			

		if (email == null || email.isEmpty()) {
			model.addAttribute("error", "Veuillez entrer un email.");
			return "homeAmapia/login";
		}

		if (password == null || password.isEmpty()) {
			model.addAttribute("error", "Veuillez entrer un mot de passe.");
			return "homeAmapia/login";
		}

		Amap amap = amapAccountService.authenticate(email, password);

		if (amap != null) {

			HttpSession session = request.getSession();
			session.setAttribute("amap", amap);
			return "redirect:/" + amap.getLinkName() + "/backoffice";
		}
		
		}

		model.addAttribute("error", "Email ou mot de passe incorrect.");
		return "homeAmapia/login";
	}

	@GetMapping("/amaplogout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/home";
	}

	@ExceptionHandler(StripeException.class)
	public String handleError(Model model, StripeException ex) {
		model.addAttribute("error", ex.getMessage());
		return "result";
	}

}
