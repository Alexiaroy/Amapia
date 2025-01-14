package com.amapia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.ModelAttribute;


import org.springframework.web.bind.annotation.ModelAttribute;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.SessionAttribute;

import org.springframework.web.servlet.ModelAndView;

import com.amapia.entity.Amap;


import com.amapia.entity.Login;

import com.amapia.entity.Member;
import com.amapia.service.AmapAccountService;
import com.amapia.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class LoginController {


	private final AmapAccountService amapAccountService;
    private final MemberService memberService;
    
    public LoginController(AmapAccountService amapAccountService, MemberService memberService) {
    	this.amapAccountService = amapAccountService;
    	this.memberService = memberService;

    }

    @GetMapping("/{linkName}/login")
    public String showAmapLoginPage(@PathVariable String linkName, Model model) {
    	model.addAttribute("linkName", linkName);
        return "homeAmap/login";
    }

    @PostMapping("/{linkName}/login")
    public String amapLogin(
    		@PathVariable String linkName, 
    		@RequestParam("email") String email, 
    		@RequestParam("password") String password, 
    		Model model, 
    		HttpServletRequest request) {
    	
    	Amap amap = amapAccountService.findByLinkNameWithMembers(linkName);
        Member member = memberService.authenticate(email, password, amap);

        if (member != null) {
        	request.getSession().setAttribute("member", member);
        	model.addAttribute("linkName", linkName);
            return "redirect:/" + linkName;
        } else {
            model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
            model.addAttribute("linkName", linkName);
            return "homeAmap/login";
        }
    }
    
    public boolean isUserLoggedIn(HttpServletRequest request) {
        Member member = (Member) request.getSession().getAttribute("member");
        return member != null;
    }


	  }	



	  
