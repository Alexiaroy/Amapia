package com.amapia.controller;
import com.amapia.entity.Amap;

import com.amapia.entity.Member;
import com.amapia.entity.Order;
import com.stripe.Stripe;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class PaymentController {

    @Value("${stripe.currency}")
    private String currency;
    String stripePublicKey = "pk_test_51QXlJBEDYGlSY25e7hxHnozgTOhtSJ0TIFkRZPY6OIEsUJHPcRoJZ5yadfFlR21LEwWPJ3fXL1uNl5GXqreAxMHU00A9qrzewW";



    
    @GetMapping("/checkout") 
    public String checkout(ModelMap map,HttpServletRequest request,@ModelAttribute Amap amap,@ModelAttribute Order order,@ModelAttribute Member member ){
    	
    	 map.addAttribute("amount", order.getPrice()); 
    	    map.addAttribute("stripePublicKey", "pk_test_51QXlJBEDYGlSY25e7hxHnozgTOhtSJ0TIFkRZPY6OIEsUJHPcRoJZ5yadfFlR21LEwWPJ3fXL1uNl5GXqreAxMHU00A9qrzewW");
    	    map.addAttribute("currency", "EUR");
    	    map.addAttribute("id", order.getOrder_id());

    	    return "/checkout";
    }
    
    
    
    

}