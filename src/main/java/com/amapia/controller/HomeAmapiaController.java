package com.amapia.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amapia.entity.Amap;

import com.amapia.entity.Subscription;
import com.amapia.entity.Support;
import com.amapia.entity.Member;
import com.amapia.entity.Volunteer;
import com.amapia.repository.SupportRepository;
import com.amapia.service.AmapAccountService;
import com.amapia.service.MemberService;
import com.amapia.service.VolunteerService;

@Controller
@RequestMapping("/")
public class HomeAmapiaController {

	private final AmapAccountService amapAccountService;
	private final SupportRepository suprepo;
	public HomeAmapiaController(AmapAccountService amapAccountService, SupportRepository suprepo) {
		this.amapAccountService = amapAccountService;
		this.suprepo = suprepo;
	}

	@GetMapping
	public String redirectToHome() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	private String home(Model model) {

		return "homeAmapia/home";
	}
	
	
	@PostMapping("/home")
	private String Message(Model model, @RequestParam("email") String email, @RequestParam("message") String message, HttpServletRequest request) {
		System.out.println(email);
		System.out.println(4);
	Support support = new Support();
	support.setIsRead(false);
	support.setDate(new Date());
	support.setMessage(message);
	support.setEmail(email);
	suprepo.save(support);
	return "homeAmapia/home";
	}
}
