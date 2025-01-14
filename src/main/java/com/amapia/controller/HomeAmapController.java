package com.amapia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amapia.entity.Activity;
import com.amapia.entity.Amap;
import com.amapia.entity.Basket;
import com.amapia.entity.Member;
import com.amapia.entity.Producer;
import com.amapia.entity.Product;
import com.amapia.service.ActivityService;
import com.amapia.service.AmapAccountService;
import com.amapia.service.BasketService;
import com.amapia.service.MemberService;
import com.amapia.service.ProducerService;
import com.amapia.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeAmapController {
	
	private final AmapAccountService amapAccountService;
	private final MemberService memberService;
    private final ProductService productService;
    private final ActivityService activityService;
    private final BasketService basketService;
    private final ProducerService producerService;

    public HomeAmapController(AmapAccountService amapAccountService, MemberService memberService, ProductService productService, ActivityService activityService, BasketService basketService, ProducerService producerService) {
        this.amapAccountService = amapAccountService;
        this.memberService = memberService;
        this.productService = productService;
        this.activityService = activityService;
        this.basketService = basketService;
        this.producerService = producerService;
    }

	
    @GetMapping("/{linkName}")
    private String amapHome(@PathVariable String linkName, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (session != null) ? (Member) session.getAttribute("member") : null;

        Amap amap = amapAccountService.findByLinkName(linkName);

        if (amap != null) {
            model.addAttribute("amap", amap);

            List<Product> lastTwoProducts = productService.getLastTwoProductsByAmap(amap);
            List<Basket> lastTwoBaskets = basketService.getLastTwoBasketsByAmap(amap);
            List<Activity> lastTwoActivities = activityService.getLastTwoActivitiesByAmap(amap);

            model.addAttribute("lastTwoProducts", lastTwoProducts);
            model.addAttribute("lastTwoBaskets", lastTwoBaskets);
            model.addAttribute("lastTwoActivities", lastTwoActivities);
        }

        model.addAttribute("content", "homeAmap/home");
        return "homeAmap/amapMainLayout";
    }


	@GetMapping("/{linkName}/about")
	public String showAbout(@PathVariable String linkName, Model model) {
		Amap amap = amapAccountService.findByLinkName(linkName);
	    
	    if (amap != null) {
	        model.addAttribute("amap", amap);
	    }
	    model.addAttribute("content", "homeAmap/about");
	    return "homeAmap/amapMainLayout";
	}

	@GetMapping("/{linkName}/store")
	public String showStore(@PathVariable String linkName, Model model) {
		Amap amap = amapAccountService.findByLinkName(linkName);
	    
		if (amap != null) {
	        List<Product> products = productService.getProductsByAmap(amap);
	        	        
	        model.addAttribute("amap", amap);
	        model.addAttribute("products", products);
	    } else {
	        System.out.println("AMAP introuvable pour le lien : " + linkName);
	    }
	    model.addAttribute("content", "store/store");
	    return "homeAmap/amapMainLayout";
	}
	
	@GetMapping("/{linkName}/subscriptions")
	public String showSubscriptions(@PathVariable String linkName, Model model) {
	    Amap amap = amapAccountService.findByLinkName(linkName);

	    if (amap != null) {
	        List<Basket> baskets = basketService.getBasketsByAmap(amap);
	        model.addAttribute("amap", amap);
	        model.addAttribute("baskets", baskets);
	    }
	    model.addAttribute("content", "subscriptions/subscriptions");
	    return "homeAmap/amapMainLayout";
	}


	
	@GetMapping("/{linkName}/activities")
	public String showActivities(@PathVariable String linkName, Model model) {
Amap amap = amapAccountService.findByLinkName(linkName);
	    
	    if (amap != null) {
	        model.addAttribute("amap", amap);
	    }
	    List<Activity> availableActivities = activityService.getActivitiesByAmap(amap);
	    for (Activity activity : availableActivities) {
			String formattedDuration = activityService.formatDuration(activity); 
			activity.setFormattedDuration(formattedDuration);
	    }
	    model.addAttribute("activities", availableActivities);
	    model.addAttribute("content", "activities/activities");
	    return "homeAmap/amapMainLayout";
	}
	
	@GetMapping("/{linkName}/my_account")
	public String showMyAccount(@PathVariable String linkName, Model model) {
		Amap amap = amapAccountService.findByLinkName(linkName);
	    
	    if (amap != null) {
	        model.addAttribute("amap", amap);
	    }
	    model.addAttribute("content", "account/myAccount");
	    return "homeAmap/amapMainLayout";
	}
	
	@GetMapping("/{linkName}/details")
	public String showAmapDetails(@PathVariable String linkName, Model model) {
	    Amap amap = amapAccountService.findByLinkName(linkName);
	    if (amap != null) {
	        model.addAttribute("amap", amap);
	    } else {
	        model.addAttribute("error", "Amap introuvable !");
	    }
	    return "homeAmap/amapDetails";
	}
	
	@PostMapping("/{linkName}/details/update")
	public String updateAmapDetails(
	        @PathVariable String linkName,
	        HttpServletRequest request,
	        Model model) {
	    
	    Amap amap = amapAccountService.findByLinkName(linkName);
	    if (amap != null) {
	        amap.setName(request.getParameter("name"));
	        amap.setAddress(request.getParameter("address"));
	        amap.setContactName(request.getParameter("contactName"));
	        amap.setContactFirstname(request.getParameter("contactFirstname"));
	        amap.setContactPhoneNum(request.getParameter("contactPhoneNum"));
	        amap.setEmail(request.getParameter("email"));
	        amap.setAmapSiret(request.getParameter("amapSiret"));
	        amapAccountService.save(amap);

	        model.addAttribute("amap", amap); 
	        model.addAttribute("success", "Informations mises à jour avec succès !");
	    } else {
	        model.addAttribute("error", "Amap introuvable !");
	    }

	    return "homeAmap/amapDetails";
	}

	@GetMapping("/productImage/{id}")
	@ResponseBody
	public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
	    Product product = productService.getProductById(id);
	    if (product != null && product.getImageData() != null) {
	        HttpHeaders headers = new HttpHeaders();
	        
	        String fileType = product.getImageType().toLowerCase();
	        if (fileType.equals("png")) {
	            headers.setContentType(MediaType.IMAGE_PNG);
	        } else {
	            headers.setContentType(MediaType.IMAGE_JPEG);
	        } 
	        
	        return new ResponseEntity<>(product.getImageData(), headers, HttpStatus.OK);
	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping("/activityImage/{activity_id}")
	@ResponseBody
	public ResponseEntity<byte[]> getImage1(@PathVariable Long activity_id) {

		Activity activity = activityService.findById(activity_id);

		if (activity != null && activity.getImageData() != null) {
			HttpHeaders headers = new HttpHeaders(); 

			String fileType = activity.getImageType().toLowerCase();
			if (fileType.equals("png")) {
				headers.setContentType(MediaType.IMAGE_PNG);
			} else {
				headers.setContentType(MediaType.IMAGE_JPEG);
			}

			return new ResponseEntity<>(activity.getImageData(), headers, HttpStatus.OK);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping("/basketImage/{basket_id}")
	@ResponseBody
	public ResponseEntity<byte[]> getImage3(@PathVariable Long basket_id) {

		Basket basket = basketService.getBasketById(basket_id);

		if (basket != null && basket.getImageData() != null) {
			HttpHeaders headers = new HttpHeaders(); 

			String fileType = basket.getImageType().toLowerCase();
			if (fileType.equals("png")) {
				headers.setContentType(MediaType.IMAGE_PNG);
			} else {
				headers.setContentType(MediaType.IMAGE_JPEG);
			}

			return new ResponseEntity<>(basket.getImageData(), headers, HttpStatus.OK);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	


	
}
