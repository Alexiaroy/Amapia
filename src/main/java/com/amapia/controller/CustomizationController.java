package com.amapia.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amapia.entity.Amap;
import com.amapia.entity.ColorType;
import com.amapia.service.AmapAccountService;
import com.amapia.service.MemberService;

@Controller
@RequestMapping("/")
public class CustomizationController {

	private final AmapAccountService amapAccountService;
	private final MemberService memberService;

	public CustomizationController(AmapAccountService amapAccountService, MemberService memberService) {
		this.amapAccountService = amapAccountService;
		this.memberService = memberService;
	}
	
	// saveNews
	@PostMapping("/{linkName}/backoffice/saveNews")
	public String saveNews(@PathVariable String linkName, @ModelAttribute Amap amap) {

		Amap existingAmap = amapAccountService.findByLinkName(linkName);
		existingAmap.setNews(amap.getNews());
		amapAccountService.save(existingAmap);
		
		return "redirect:/"+linkName+"/backoffice";
	}

	// saveAboutSection
	@PostMapping("/{linkName}/backoffice/saveAboutSection")
	public String saveAboutSection(
			@RequestParam("amapfile") MultipartFile amapfile, 
			@PathVariable String linkName, 
			@ModelAttribute Amap amap) {

		Amap existingAmap = amapAccountService.findByLinkName(linkName);
		
		existingAmap.setAboutSectionTitle(amap.getAboutSectionTitle());
		existingAmap.setAboutSectionText(amap.getAboutSectionText());
		
		try {
			amapAccountService.saveAboutSection(existingAmap, amapfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/"+linkName+"/backoffice";
	}

	// saveSubSection
	@PostMapping("/{linkName}/backoffice/saveSubSection")
	public String saveSubSection(@PathVariable String linkName,
			@ModelAttribute Amap amap) {

		Amap existingAmap = amapAccountService.findByLinkName(linkName);
		existingAmap.setSubSectionTitle(amap.getSubSectionTitle());
		existingAmap.setSubSectionText(amap.getSubSectionText());
		amapAccountService.save(existingAmap);

		return "redirect:/"+linkName+"/backoffice";
	}
	
	// saveBannerColorLogo
	@PostMapping("/{linkName}/backoffice/saveBannerColorLogo")
	public String saveBannerColorLogo(
			@RequestParam("logofile") MultipartFile logofile,
			@RequestParam("bannerfile") MultipartFile bannerfile,
			@PathVariable String linkName,
			@ModelAttribute Amap amap,
			@RequestParam("bannerColor") ColorType bannerColor) {
		
		Amap existingAmap = amapAccountService.findByLinkName(linkName);
		existingAmap.setLogoText(amap.getLogoText());
		existingAmap.setBannerColor(bannerColor);
		existingAmap.setBannerChoice(amap.isBannerChoice());
		
		try {
			amapAccountService.saveBannerAndLogo(existingAmap, logofile, bannerfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/"+linkName+"/backoffice";
	}
	
	@PostMapping("/{linkName}/backoffice/removeBannerImg")
	public String removeBannerImg(@PathVariable String linkName,
			@ModelAttribute Amap amap) {
		
	Amap existingAmap = amapAccountService.findByLinkName(linkName);	
	existingAmap.setBannerImgData(null);
	existingAmap.setBannerImgName(null);
	existingAmap.setBannerImgType(null);
	
	amapAccountService.save(existingAmap);
	
	return "redirect:/"+linkName+"/backoffice";
	}
}
