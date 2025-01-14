package com.amapia.service.impl;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amapia.entity.Amap;
import com.amapia.entity.Member;
import com.amapia.entity.Subscription;
import com.amapia.repository.AmapRepository;
import com.amapia.repository.SubscriptionRepository;
import com.amapia.service.AmapAccountService;
import com.stripe.service.SubscriptionService;

@Service
public class AmapAccountServiceImpl implements AmapAccountService {

	@Autowired
	private AmapRepository amapRepository;

	@Override
	public List<Amap> findAll() {
		return amapRepository.findAll();
	}

	@Override
	public Amap save(Amap amap) {
		System.out.println("Mot de passe avant insertion en base : " + amap.getPassword());
		if (amap.getId() == null) {
			amap.setLinkName(createUniqueLinkName(amap.getName()));
		}
		return amapRepository.save(amap);
	}

	@Override
	public Amap findById(Long id) {
		return amapRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		amapRepository.deleteById(id);
	}

	public String createUniqueLinkName(String name) {
		String normalizedLinkName = name.replaceAll("\\s+", "_");
		int suffix = 0;
		String uniqueLinkName = normalizedLinkName;

		while (amapRepository.existsByLinkName(uniqueLinkName)) {
			suffix++;
			uniqueLinkName = normalizedLinkName + "_" + suffix;
		}

		return uniqueLinkName;
	}

	@Override
	public Amap findByLinkName(String linkName) {
		return amapRepository.findByLinkName(linkName);
	}

	@Transactional
	@Override
	public Amap findByLinkNameWithMembers(String linkName) {
		return amapRepository.findByLinkNameWithMembers(linkName);
	}

	@Override
	public boolean existingEmail(String email) {
		return amapRepository.existsByEmail(email);
	}
	public Amap findByEmail(String email) {
		return amapRepository.findByEmail(email).orElse(null);

	}

	@Override

	public Amap authenticate(String email, String password) {
		Amap amap = amapRepository.findByEmail(email).orElse(null);
		if (amap == null) {
			System.out.println("Erreur : Aucun utilisateur avec cet email n'a été trouvé.");

			return null;
		}
		System.out.println("Mot de passe fourni par l'utilisateur : " + password);
		System.out.println("Mot de passe dans la base : " + amap.getPassword());

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (passwordEncoder.matches(password, amap.getPassword())) {
			System.out.println("succès");
			return amap;

		} else {
			System.out.println("Erreur : Le mot de passe est incorrect.");

			return null;
		}
	}



	public void deleteSubscription(long id) {
		// TODO Auto-generated method stub
		
		Amap amap = findById(id);
		
		save(amap);
	
	}
	
	

	@Override
	public Amap saveAboutSection(Amap amap, MultipartFile file) throws IOException {
		if (file != null && !file.isEmpty()) {
			amap.setAboutSectionImgData(file.getBytes());
			amap.setAboutSectionImgName(file.getOriginalFilename());
			amap.setAboutSectionImgType(file.getContentType());
		}
		return amapRepository.save(amap);
	}

	@Override
	public Amap saveBannerAndLogo(Amap amap, MultipartFile logofile, MultipartFile bannerfile) throws IOException {
		if (logofile != null && !logofile.isEmpty()) {
			amap.setLogoImgData(logofile.getBytes());
			amap.setLogoImgName(logofile.getOriginalFilename());
			amap.setLogoImgType(logofile.getContentType());
		}
		if (bannerfile != null && !bannerfile.isEmpty() && amap.isBannerChoice()) {
			amap.setBannerImgData(bannerfile.getBytes());
			amap.setBannerImgName(bannerfile.getOriginalFilename());
			amap.setBannerImgType(bannerfile.getContentType());
		} else {
			amap.setBannerImgData(null);
			amap.setBannerImgName(null);
			amap.setBannerImgType(null);
		}

		return amapRepository.save(amap);
	}

	}



	
	
	





