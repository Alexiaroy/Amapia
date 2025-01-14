package com.amapia.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amapia.entity.Amap;
import com.amapia.service.AmapAccountService;

@Controller
@RequestMapping("/")
public class ImagesController {

	private final AmapAccountService amapAccountService;

	public ImagesController(AmapAccountService amapAccountService) {
		super();
		this.amapAccountService = amapAccountService;
	}

	@GetMapping("/aboutSectionImg/{id}")
	@ResponseBody
	public ResponseEntity<byte[]> getAboutSectionImg(@PathVariable Long id) {
		Amap amap = amapAccountService.findById(id);
		if (amap != null && amap.getAboutSectionImgData() != null) {
			HttpHeaders headers = new HttpHeaders();
			String fileType = amap.getAboutSectionImgType().toLowerCase();
			if (fileType.equals("png")) {
				headers.setContentType(MediaType.IMAGE_PNG);
			} else {
				headers.setContentType(MediaType.IMAGE_JPEG);
			}
			return new ResponseEntity<>(amap.getAboutSectionImgData(), headers, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping("/bannerImg/{id}")
	@ResponseBody
	public ResponseEntity<byte[]> getBannerImg(@PathVariable Long id) {
		Amap amap = amapAccountService.findById(id);
		if (amap != null && amap.getBannerImgData() != null) {
			HttpHeaders headers = new HttpHeaders();
			String fileType = amap.getBannerImgType().toLowerCase();
			if (fileType.equals("png")) {
				headers.setContentType(MediaType.IMAGE_PNG);
			} else {
				headers.setContentType(MediaType.IMAGE_JPEG);
			}
			return new ResponseEntity<>(amap.getBannerImgData(), headers, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping("/logoImg/{id}")
	@ResponseBody
	public ResponseEntity<byte[]> getLogoImg(@PathVariable Long id) {
		Amap amap = amapAccountService.findById(id);
		if (amap != null && amap.getLogoImgData() != null) {
			HttpHeaders headers = new HttpHeaders();
			String fileType = amap.getLogoImgType().toLowerCase();
			if (fileType.equals("png")) {
				headers.setContentType(MediaType.IMAGE_PNG);
			} else {
				headers.setContentType(MediaType.IMAGE_JPEG);
			}
			return new ResponseEntity<>(amap.getLogoImgData(), headers, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}
