package com.amapia.service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.amapia.entity.Amap;
import com.amapia.entity.Basket;
import com.amapia.entity.Producer;


public interface BasketService {
	List<Basket> findAll();

    List<Basket> getActiveBasket();
    Basket getBasketById(Long id);
    Basket save(Basket basket, MultipartFile file) throws IOException;
    List<Basket> getBasketsByProducerId(Long producerId);
//   Basket updateBasket(Long id, Basket Basket);
   List<Basket> getPublishedBasketsByProducerId(Long producerId);
   List<Basket> getLastTwoBasketsByAmap(Amap amap);
   List<Basket> getBasketsByAmap(Amap amap);

}
