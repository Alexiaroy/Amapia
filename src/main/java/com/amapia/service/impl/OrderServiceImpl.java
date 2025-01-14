package com.amapia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.amapia.entity.Amap;
import com.amapia.entity.Order;
import com.amapia.entity.OrderLine;
import com.amapia.repository.OrderRepository;
import com.amapia.service.AmapAccountService;
import com.amapia.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	
	
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public Optional<Order> findById(Long id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> findAllByAmapId(Long amapId) {
		// TODO Auto-generated method stub
		return orderRepository.findAllByAmapId(amapId);
	}
	
	public Order GenerateOrderSubAmapia(double price) {
		
		Order order = new Order();
		order.setMember(null);
		order.setPrice(price);
		order.setStatus(false);
		order.setAmap(null);
		save(order);
		return order;
	}
	@Override
	public List<Order> findAllforAmapia() {
		// TODO Auto-generated method stub
		return orderRepository.findAllforAmapia();
	}

}
