package com.amapia.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.amapia.entity.Amap;
import com.amapia.entity.Support;
import com.amapia.repository.SupportRepository;
import com.amapia.service.AmapAccountService;
import com.amapia.service.OrderService;
import com.amapia.service.SubscriptionService;

@Controller
@RequestMapping("/BackOffice")
public class BackOfficeAmapiaController {
	private final AmapAccountService amapAccountService;
	private final OrderService orderService;
	private final SupportRepository supportRepository;
	private final SubscriptionService subscriptionService;

	public BackOfficeAmapiaController(AmapAccountService amapAccountService, OrderService orderService,
			SupportRepository supportRepository, SubscriptionService subscriptionService) {
		this.amapAccountService = amapAccountService;
		this.orderService = orderService;
		this.supportRepository = supportRepository;
		this.subscriptionService = subscriptionService;

	}

	@GetMapping("/AmapList")
	private String amapiaBackOfficeAmapList(Model model) {

		model.addAttribute("amaps", amapAccountService.findAll());
		model.addAttribute("amapstotal", amapAccountService.findAll().size());
		return "BackOfficeAmapia/AmapList";
	}

	@GetMapping("/OrderList")
	private String amapiaBackOfficeOrderList(Model model) {

		model.addAttribute("orders", orderService.findAllforAmapia());
		model.addAttribute("orderstotal", orderService.findAllforAmapia().size());
		return "BackOfficeAmapia/OrderList";
	}

	@GetMapping("/SupportContact")
	private String amapiaBackOfficeSupport(Model model) {

		model.addAttribute("supports", supportRepository.findAll());
		return "BackOfficeAmapia/SupportContact";
	}

	@GetMapping("/")
	private String amapiaBackOfficeHome(Model model) {
		List<Amap> amaplist = amapAccountService.findAll();
		int totalsupp = 0;
		List<Support> listsupport = supportRepository.findAll();
		for (int i = 0; i < listsupport.size(); i++) {
			Support supp = listsupport.get(i);
			if (supp.isIsRead() == false) {
				totalsupp = totalsupp + 1;
			}
		}

		double total = 0;
		int NewAmap = 0;
		int Normal = 0;
		int Basique = 0;
		int Premium = 0;
		int janv = 0;
		int fev = 0;
		int mar = 0;
		int apr = 0;
		int mai = 0;
		int jun = 0;
		int jui = 0;
		int aug = 0;
		int sep = 0;
		int oct = 0;
		int nov = 0;
		int dec = 0;
		Calendar cal = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -30);
		Date date = c.getTime();
		for (int i = 0; i < amaplist.size(); i++) {
			Amap amap = amaplist.get(i);
			total = total + amap.getSubscription().getPrice().intValue();
			if (amap.getSubscription().getId() == 1) {
				Basique = Basique + 1;
			} else if (amap.getSubscription().getId() == 2) {
				Normal = Normal + 1;
			} else if (amap.getSubscription().getId() == 3) {
				Premium = Premium + 1;
			}
			if (amap.getDateCreated().after(date)) {
				NewAmap = NewAmap + 1;
			}

			cal.setTime(amap.getDateCreated());
			int month = cal.get(Calendar.MONTH);
			switch (month) {
			case 0:
				janv = janv + 1;
				 break;
			case 1:
				fev = fev + 1;
				 break;
			case 2:
				mar = mar + 1;
				 break;
			case 3:
				apr = apr + 1;
				 break;
			case 4:
				mai = mai + 1;
				 break;
			case 5:
				jun = jun + 1;
				 break;
			case 6:
				jui = jui + 1;
				 break;
			case 7:
				aug = aug + 1;
				 break;
			case 8:
				sep = sep + 1;
				 break;
			case 9:
				oct = oct + 1;
				 break;
			case 10:
				nov = nov + 1;
				 break;
			case 11:
				dec = dec + 1;
				 break;
			}
		}
		System.out.println(janv);
		model.addAttribute("jan", janv);
		model.addAttribute("fev", fev);
		model.addAttribute("mar", mar);
		model.addAttribute("apr", apr);
		model.addAttribute("mai", mai);
		model.addAttribute("jun", jun);
		model.addAttribute("jui", jui);
		model.addAttribute("aug", aug);
		model.addAttribute("sep", sep);
		model.addAttribute("oct", oct);
		model.addAttribute("nov", nov);
		model.addAttribute("dec", dec);
		model.addAttribute("Basique", Basique);
		model.addAttribute("Normal", Normal);
		model.addAttribute("Premium", Premium);
		model.addAttribute("newamap", NewAmap);
		model.addAttribute("totalmessage", totalsupp);
		model.addAttribute("total", total);
		model.addAttribute("totalamap", amaplist.size());
		model.addAttribute("amap", amaplist);

		return "BackOfficeAmapia/home";
	}

	@GetMapping("/Subscriptions")
	private String amapiaBackOfficeSubscriptions(Model model) {

		model.addAttribute("subscriptions", subscriptionService.findAll());

		return "BackOfficeAmapia/Subscriptions";
	}

	@GetMapping("/AdminTech")
	private String amapiaBackOfficeAdminTech(Model model) {

		return "BackOfficeAmapia/AdminTech";
	}

}
