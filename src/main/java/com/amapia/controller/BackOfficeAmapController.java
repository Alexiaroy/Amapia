package com.amapia.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amapia.entity.Amap;
import com.amapia.entity.Member;
import com.amapia.entity.Subscription;
import com.amapia.repository.SubscriptionRepository;
import com.amapia.service.AmapAccountService;
import com.amapia.service.MemberService;


import com.amapia.service.OrderService;




@Controller
@RequestMapping("/")
public class BackOfficeAmapController {
    private final AmapAccountService amapAccountService;
	@Autowired
	private SubscriptionRepository subRepository;
    private final MemberService memberService;



    private OrderService orderService;
    
    public BackOfficeAmapController(AmapAccountService amapAccountService,MemberService memberService, OrderService orderService) {
        this.amapAccountService = amapAccountService;
        this.memberService= memberService;
        this.orderService= orderService;  
    }
    
	@GetMapping("/{linkName}/BackOfficeAmap")
	private String amapBackOffice(@PathVariable String linkName, Model model) {
		Amap amap = amapAccountService.findByLinkName(linkName);
		model.addAttribute("amap", amap);
		
		return "backofficeAmap/BackOfficeAmap";
	}

	@PostMapping("/{linkName}/BackOfficeAmap")
    public String CancelSubscription(@PathVariable String linkName,Model model ,@RequestParam String action) {
	
		Amap amap = amapAccountService.findByLinkName(linkName); 
		Subscription Sub=subRepository.findAll().get(3);
		System.out.println(Sub.getSubscriptionName());
    

    	amap.setSubscription(Sub);
    	amapAccountService.save(amap);
    	model.addAttribute("amap", amap);
    	return "backofficeAmap/BackOfficeAmap";
    }


	@GetMapping("/{linkName}/OrderList")
	private String amapBackOfficeOrderList(@PathVariable String linkName, Model model) {
		Amap amap = amapAccountService.findByLinkName(linkName);
		model.addAttribute("orders", orderService.findAllByAmapId(amap.getId()));
		model.addAttribute("amap", amap);
		
		return "backofficeAmap/OrderList";
	}
	
	@GetMapping("/{linkName}/backoffice")
	public String signupForm(@PathVariable String linkName, Model model) {
		Amap amap = amapAccountService.findByLinkName(linkName);
		
		if (amap != null) {
			model.addAttribute("amap", amap);
		}
		model.addAttribute("content", "backofficeAmap/amapCustomPage");
		long numberOfProducers = memberService.getNumberOfProducers(amap);
		model.addAttribute("numberOfProducers", numberOfProducers);
		long numberOfEnterprises = memberService.getNumberOfEnterprises(amap);
		long numberOfIndividuals = memberService.getNumberOfIndividuals(amap);
		long numberOfAdherents = numberOfEnterprises + numberOfIndividuals;
		model.addAttribute("numberOfAdherents", numberOfAdherents);
		return "backofficeAmap/amapBackofficeLayout";
	}

	@GetMapping("/{linkName}/members")
	public String showActivities(@PathVariable String linkName, Model model) {
		Amap amap = amapAccountService.findByLinkName(linkName);
	    
	    if (amap != null) {
	    	List<Member> members = memberService.findAllByAmapId(amap.getId());
			model.addAttribute("members", members);
			model.addAttribute("amap", amap);
	    }
	    model.addAttribute("content", "members/showAllMembers");
	    
	    return "backofficeAmap/amapBackofficeLayout";
	}

}
