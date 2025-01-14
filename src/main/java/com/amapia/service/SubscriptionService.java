package com.amapia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amapia.entity.Subscription;
@Service
public interface SubscriptionService {
	
	List<Subscription> findAll();
	
	Subscription findById(Long id);
	Subscription save(Subscription subscription);
}
