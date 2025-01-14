package com.amapia.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.amapia.entity.Amap;


public interface AmapAccountService {
	
	List<Amap> findAll();
	
	Amap save(Amap amap);
	
	Amap findById(Long id);
	
	void deleteById(Long id);

	String createUniqueLinkName(String name);

	Amap findByLinkName(String linkName);
	
	boolean existingEmail(String email);
	
	Amap findByEmail(String email);


	Amap authenticate(String email, String password);

	Amap findByLinkNameWithMembers(String linkName);


	Amap saveAboutSection(Amap amap, MultipartFile file) throws IOException;

	Amap saveBannerAndLogo(Amap amap, MultipartFile logofile, MultipartFile bannerfile) throws IOException ;



	void deleteSubscription(long id);


}
