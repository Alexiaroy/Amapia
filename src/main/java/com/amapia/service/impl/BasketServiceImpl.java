package com.amapia.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amapia.entity.Amap;
import com.amapia.entity.Basket;
import com.amapia.entity.Producer;
import com.amapia.repository.BasketRepository;
import com.amapia.service.BasketService;

@Service
public class BasketServiceImpl implements BasketService {
	@Autowired
	private BasketRepository basketRepository;

	@Override
	public List<Basket> findAll() {
		// TODO Auto-generated method stub
		return basketRepository.findAll();
	}

	@Override
	public List<Basket> getActiveBasket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Basket getBasketById(Long id) {
		return basketRepository.findById(id).get();
	}

	@Override
	public Basket save(Basket basket, MultipartFile file) throws IOException {
		if (file != null && !file.isEmpty()) {
			basket.setImageData(file.getBytes());
			basket.setImageName(file.getOriginalFilename());
			basket.setImageType(file.getContentType());
		}
		return basketRepository.save(basket);
	}

	@Override
	public List<Basket> getBasketsByProducerId(Long producerId) {
		// TODO Auto-generated method stub
		return basketRepository.findByProducerId(producerId);
	}

//	public Basket updateBasket(Long id, Basket Basket) {
//		Optional<Basket> basketA = getBasketById(id);
//		Basket BasketA = basketA.get();
//		BasketA.setActive(Basket.isActive());
//		BasketA.setDescription(Basket.getDescription());
//		BasketA.setName(Basket.getName());
//		BasketA.setPrice(Basket.getPrice());
//		BasketA.setProducer(Basket.getProducer());
//		BasketA.setStock(Basket.getStock());
//
//		return save(BasketA);
//	}
	@Override
	public List<Basket> getPublishedBasketsByProducerId(Long producerId) {

		return basketRepository.findByProducerIdandPublished(producerId);
	}
	
	@Override
	public List<Basket> getLastTwoBasketsByAmap(Amap amap) {
		List<Basket> allBaskets = basketRepository.findTop2ByAmapOrderByIdDesc(amap);
	    return allBaskets.stream().limit(2).collect(Collectors.toList());
	}

	
	@Override
	public List<Basket> getBasketsByAmap(Amap amap) {
	    return basketRepository.findBasketsByAmap(amap);
	}



}
