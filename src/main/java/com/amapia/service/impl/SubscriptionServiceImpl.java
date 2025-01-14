package com.amapia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amapia.entity.Member;
import com.amapia.entity.Subscription;
import com.amapia.repository.SubscriptionRepository;
import com.amapia.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Override
	public List<Subscription> findAll() {
		return subscriptionRepository.findAll();
	}

	@Override
	public Subscription findById(Long id) {
		return subscriptionRepository.findById(id).orElse(null);
	}
	@Override
	public Subscription save(Subscription sub) {
		return subscriptionRepository.save(sub);
	}
}
