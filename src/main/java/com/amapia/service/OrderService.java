package com.amapia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.amapia.entity.Amap;
import com.amapia.entity.Order;
@Service
public interface OrderService {
	List<Order> findAll();

	Order save(Order order);

	Optional<Order> findById(Long id);

	void deleteById(Long id);

	List<Order> findAllByAmapId(Long amapId);
	
	Order GenerateOrderSubAmapia( double price);

	List<Order> findAllforAmapia();
}
